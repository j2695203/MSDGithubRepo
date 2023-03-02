#include <iostream>
#include <array>

using Block = std::array<uint8_t, 8>; // 64 bits

// AES
void runBlockCypher(){

    uint8_t password[] = {'h','o','m','e','w','o','r','k','s','u','c','k'};
    uint8_t password_wrong[] = {'s','l','e','e','p','m','o','r','e'};
    Block key = {'0','0','0','0','0','0','0','0'};
    Block key_wrong = {'0','0','0','0','0','0','0','0'};
    int tables[8][256];
    Block messages = {'v','a','c','a','t','i','o','n'};
    Block messages_encrypt;
    Block messages_encrypt_modifyBit;
    Block messages_decrypt;
    Block messages_decrypt_wrong;
    Block messages_decrypt_modifyBit;

    // 1. Compute secret key

    for( int i = 0; i < sizeof(password) / sizeof(uint8_t) ; i++ ){
        key[i%8] ^= password[i]; // xor
        key_wrong[i%8] ^= password_wrong[i];
    }

    // 2. Compute 8 substitution tables (each acting on 1 byte)
    srand (time(NULL));

    for( int i = 0; i < 8; i++ ){
        // initialize
        for( int j = 0; j < 256; j++ ){
            if( i == 0 ) {
                tables[i][j] = j;
            }else{
                tables[i][j] = tables[i-1][j]; // copy last table
            }
        }
        // Fisher–Yates shuffle
        if( i > 0 ){
            for( int j = 255; j > 0; j-- ){
                int r = rand() % (j+1);
                std::swap(tables[i][j], tables[i][r]);
            }
        }
    }


    // 3. Encryption algorithm
    for(int round = 0; round < 16; round++ ) {

        // 3-1. xor the current state with the key
        for (int i = 0; i < sizeof(messages); i++) {
            messages_encrypt[i] = messages[i] ^ key[i]; // xor
        }

        // 3-2. substitute the byte using appropriate table (byte# uses table#)
        for (int i = 0; i < sizeof(messages); i++) {
            messages_encrypt[i] = tables[i % 8][messages_encrypt[i]];
        }

        // 3-3. rotate the entire state 1 bit to the left
        uint8_t firstByte = messages_encrypt[0];
        for (int i = 0; i < sizeof(messages_encrypt)-1 ; i++) {
            messages_encrypt[i] = (messages_encrypt[i] << 1) | (messages_encrypt[i+1] >> (8 - 1));
        }
        messages_encrypt[sizeof(messages_encrypt)-1] = messages_encrypt[sizeof(messages_encrypt)-1] << 1 | firstByte >> 7;
    }
    // print the result of encryption
    std::cout<< "Encryption: ";
    for(char c: messages_encrypt){
        std::cout << c ;
    }


    // 4. Decrypt algorithm
    for(int round = 0; round < 16; round++ ) {

        // 4-1. (reverse 3-3) rotate the entire state 1 bit to the right
        uint8_t lastByte = messages_encrypt[sizeof(messages_encrypt)-1];
        for (int i = sizeof(messages_encrypt)-1 ; i > 0 ; i--) {
            messages_decrypt[i] = (messages_encrypt[i] >> 1) | (messages_encrypt[i-1] << (8 - 1));
        }
        messages_decrypt[0] = messages_encrypt[0] >> 1 | lastByte << 7;


        // 4-2. (reverse 3-2) reverse the byte using appropriate table (byte# uses table#)
        for (int i = 0; i < sizeof(messages); i++) {
            messages_decrypt[i] = std::distance(tables[i%8], std::find(tables[i%8], tables[i%8] + 255, messages_decrypt[i]));
        }

        // 4-3. (reverse 3-1) xor the current state with the key
        for (int i = 0; i < sizeof(messages_decrypt); i++) {
            messages_decrypt[i] ^= key[i]; // xor
            messages_decrypt_wrong[i] ^= key_wrong[i];
        }
    }

    // print the result of decryption
    std::cout<< "\nDecryption(correct password) : ";
    for(char c: messages_decrypt){
        std::cout << c ;
    }
    std::cout<< "\nDecryption(wrong password) : ";
    for(char c: messages_decrypt_wrong){
        std::cout << c ;
    }

    // modify 1 bit of the cyphertext, decrypt with the correct passwords
    messages_encrypt_modifyBit = messages_encrypt;
    messages_encrypt_modifyBit[0] <<= 1;
    messages_encrypt_modifyBit[0] >>= 1;


    for(int round = 0; round < 16; round++ ) {

        // 4-1. (reverse 3-3) rotate the entire state 1 bit to the right
        uint8_t lastByte = messages_encrypt_modifyBit[sizeof(messages_encrypt_modifyBit)-1];
        for (int i = sizeof(messages_encrypt_modifyBit)-1 ; i > 0 ; i--) {
            messages_decrypt_modifyBit[i] = (messages_encrypt_modifyBit[i] >> 1) | (messages_encrypt_modifyBit[i-1] << (8 - 1));
        }
        messages_decrypt_modifyBit[0] = messages_encrypt_modifyBit[0] >> 1 | lastByte << 7;


        // 4-2. (reverse 3-2) reverse the byte using appropriate table (byte# uses table#)
        for (int i = 0; i < sizeof(messages); i++) {
            messages_decrypt_modifyBit[i] = std::distance(tables[i%8], std::find(tables[i%8], tables[i%8] + 255, messages_decrypt_modifyBit[i]));
        }

        // 4-3. (reverse 3-1) xor the current state with the key
        for (int i = 0; i < sizeof(messages_decrypt); i++) {
            messages_decrypt_modifyBit[i] ^= key[i]; // xor
        }
    }

    std::cout<< "\nDecryption(modify 1 bit) : ";
    for(char c: messages_decrypt_modifyBit){
        std::cout << c ;
    }

}

// RC4
void runStreamCypher(){
    std::string key = "00000000";
    std::string key_wrong = "11111111";
    int s[256]; // state
    int s_wrong[256];
    std::string keyStream;
    std::string keyStream_wrong;
    std::string message1 = "Your salary is $1000";
    std::string message1_encrypt;
    std::string message1_decrypt;
    std::string message2 = "Never same keyStream";
    std::string message2_encrypt;
    std::string message2_decrypt;
    std::string message1_fake = "Your salary is $9999";

    // 1-1. Initialize the internal state from the key (correct key)
    for(int i = 0; i < sizeof(s) / sizeof(int); i++ ){
        s[i] = i;
        s_wrong[i] = i;
    }
    // (correct key)
    int j = 0;
    for(int i = 0; i < sizeof(s) / sizeof(int); i++ ){
        j = ( j + s[i] + key[i % key.length()] ) % 256;
        std::swap(s[i],s[j]);
    }
    // (wrong key)
    j = 0;
    for(int i = 0; i < sizeof(s) / sizeof(int); i++ ){
        j = ( j + s_wrong[i] + key_wrong[i % key_wrong.length()] ) % 256;
        std::swap(s_wrong[i],s_wrong[j]);
    }

    // 2-1. Pseudorandom number generator (correct key)
    int x = 0;
    int y = 0;

    while(x < message1.length() ){
        x = ( x + 1 ) % 256;
        y = ( y + s[x] ) % 256;
        std::swap(s[x], s[y]);
        keyStream += s[(s[x] + s[y]) % 256 ];
    }

    // 2-2. Pseudorandom number generator (wrong key)
    x = 0;
    y = 0;

    while(x < message1.length() ){
        x = ( x + 1 ) % 256;
        y = ( y + s_wrong[x] ) % 256;
        std::swap(s_wrong[x], s[y]);
        keyStream_wrong += s_wrong[(s[x] + s[y]) % 256 ];
    }

    // 3. Encryption
    std::cout<< "Encryption: ";
    for(int i = 0; i < message1.length(); i++ ){
        message1_encrypt[i] = message1[i] ^ keyStream[i];
        std::cout << message1_encrypt[i];
    }

    // 4-1. Decryption (correct key)
    std::cout<< "\nDecryption(correct key): ";
    for(int i = 0; i < message1.length(); i++ ){
        message1_decrypt[i] = message1_encrypt[i] ^ keyStream[i];
        std::cout << message1_decrypt[i];
    }

    // 4-2. Decryption (wrong key)
    std::cout<< "\nDecryption(wrong key): ";
    for(int i = 0; i < message1.length(); i++ ){
        message1_decrypt[i] = message1_encrypt[i] ^ keyStream_wrong[i];
        std::cout << message1_decrypt[i];
    }

    /*
     * 5. Verify encrypting 2 messages with same keyStream is insecure
     */

    // Encrypt message2
    for(int i = 0; i < message1.length(); i++ ){
        message2_encrypt[i] = message2[i] ^ keyStream[i];
        std::cout << message2_encrypt[i];
    }

    // XOR Two Encrypted Messages
    std::string messagesXOR;
    for(int i = 0; i < message2.length(); i++ ){
        messagesXOR[i] = message1_encrypt[i] ^ message2_encrypt[i];
    }

    std::cout<< "\nXOR Two Encrypted Messages with M1: ";
    for(int i = 0; i < message2.length(); i++ ){
        messagesXOR[i] ^= message1[i];
        std::cout << messagesXOR[i];
    }

    /*
     * 6. Modify part of a message using a bit-flipping attack.
     */

    // attacker: change to fake message and encrypt
    for( int i = 0; i < message1.length(); i++ ){
        message1_encrypt[i] = message1_fake[i] ^ message1[i] ^ message1_encrypt[i];
    }
    // Bob: decrypt message
    for( int i = 0; i < message1.length(); i++ ){
        message1_decrypt[i] = message1_encrypt[i] ^ keyStream[i];
    }

    std::cout<< "\nDecrypt Fake Message: ";
    for(int i = 0; i < message1.length(); i++ ){
        std::cout << message1_decrypt[i];
    }
}

int main() {

    std::cout<< "[BlockCypher] \n";
    runBlockCypher();

    std::cout<< "\n\n[StreamCypher] \n";
    runStreamCypher();

    return 0;
}

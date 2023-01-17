package assignment06;



public class MediocreHashFunctor implements HashFunctor{
    /**
     * Function to return a hash value of certain string.
     * Compute the ASCII value of the string.
     * (Divide ASCII value by the capacity, and take the remainder as hash value.)
     * @param item string for finding hash value
     * @return computing hash value of the item
     */
    @Override
    public int hash(String item) {
        // compute accumulated ASCII value of the string
        int sum = 0;
        for( int i = 0; i < item.length(); i++ ){
            sum += item.charAt(i);
        }
        return sum;
    }
}

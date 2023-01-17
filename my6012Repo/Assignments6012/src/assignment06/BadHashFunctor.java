package assignment06;

public class BadHashFunctor implements HashFunctor {
    /**
     * Function to return a hash value of certain string.
     * Compute the ASCII value of the first letter of the string, and multiply 17.
     * (Divide ASCII value by the capacity, and take the remainder as hash value.)
     * @param item string for finding hash value
     * @return computing hash value of the item
     */
    @Override
    public int hash(String item) {
        // compute ASCII value of the first letter
        int ascii = item.charAt(0);
        return ascii;
    }
}

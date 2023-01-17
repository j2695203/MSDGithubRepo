package assignment06;

public class GoodHashFunctor implements HashFunctor{
    /**
     * An implementation of Dan Bernstein's {@code djb2} hash function which is
     * slightly modified. Instead of the initial hash being 5381, it is zero.
     *
     * @param item The string to hash.
     * @return The hash code.
     */
    @Override
    public int hash(String item) {
        int hash = 0;
        for (int i = 0; i < item.length(); i++) {
            hash = item.charAt(i) + ((hash << 5) + hash);
        }
        return Math.abs(hash);
    }
}

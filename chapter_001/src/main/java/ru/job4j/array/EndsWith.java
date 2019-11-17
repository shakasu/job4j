package ru.job4j.array;

/**
 * A class for checking char-type "word" arrays for the end of a "post".
 *
 * @author Karen Shakhnazaryan (shakasuone@gmail.com).
 *
 */
public class EndsWith {
    /**
     *
     * @param word - verifiable array.
     * @param post - checking array.
     * @return - truth of check.
     */
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        for (int i = 0; i < post.length; i++) {
            if (word[word.length - i - 1] != post[post.length - i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
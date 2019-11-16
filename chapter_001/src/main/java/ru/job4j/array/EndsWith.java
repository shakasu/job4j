package ru.job4j.array;

/**
 * A class for checking char-type "word" arrays for the end of a "post".
 *
 * @author Karen Shakhnazaryan (shakasuone@gmail.com)
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
        int indexDifference = word.length - post.length - 1;
        int indexPost = post.length - 1;
        for (int indexWord = word.length - 1; indexWord > indexDifference; indexWord--) {
            if (word[indexWord] != post[indexPost]) {
                break;
            }
            indexPost--;
        }
        return indexPost == -1;
    }
}
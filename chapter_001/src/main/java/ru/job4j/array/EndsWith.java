package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        int indexDifference = word.length - post.length - 1;
        int indexPost = post.length - 1;
        int counter = 0;
        for (int indexWord = word.length - 1; indexWord > indexDifference; indexWord--) {
            if (word[indexWord] != post[indexPost]) {
                return false;
            }
                indexPost--;
        }
        return true;
    }
}
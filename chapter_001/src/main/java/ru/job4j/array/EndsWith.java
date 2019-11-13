package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        int indexDifference = word.length - post.length - 1;
        int indexPost = post.length - 1;
        int counter = 0;
        for (int indexWord = word.length - 1; indexWord > indexDifference; indexWord--) {
            if (word[indexWord] == post[indexPost]) {
                counter++;
                indexPost--;
            }
        }
        result = (counter == post.length);
        return result;
    }
}
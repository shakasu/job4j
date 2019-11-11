package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        TurnForChar turner = new TurnForChar();
        char[] returnPost = turner.back(post);
        char[] returnWord = turner.back(word);
        ArrayChar checker = new ArrayChar();
        boolean result = ArrayChar.startsWith(word, post);
        return result;
    }
}
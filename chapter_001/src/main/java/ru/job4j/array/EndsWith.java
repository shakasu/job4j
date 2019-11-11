package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = false;
        int counter = 0;
        int i = word.length - 1;
        int n = post.length - 1;
        while (i != n) {
            i--;
        }
        i = word.length - i - 1;
        n = 0;
        while (i != word.length) {
            if (word[i] == post[n]) {
                counter++;
            }
            i++;
            n++;
        }
        result = (counter == post.length);
        /*TurnForChar turner = new TurnForChar();
        char[] returnPost = turner.back(post);
        char[] returnWord = turner.back(word);
        ArrayChar checker = new ArrayChar();
        boolean result = ArrayChar.startsWith(word, post);*/
        return result;
    }
}
package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book republic = new Book("republic", 999);
        Book cleanCode = new Book("Clean code", 211);
        Book critiqueOfPureReason = new Book("Critique of Pure Reason", 2121);
        Book we = new Book("We", 21135);

        Book[] books = new Book[4];

        books[0] = republic;
        books[1] = cleanCode;
        books[2] = critiqueOfPureReason;
        books[3] = we;

        for (int index = 0; index < books.length; index++) {
            Book currentBook = books[index];
            System.out.println(currentBook.getTitle() + " - " + currentBook.getPages());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int index = 0; index < books.length; index++) {
            Book currentBook = books[index];
            System.out.println(currentBook.getTitle() + " - " + currentBook.getPages());
        }

        System.out.println("Show me 'Clean code', please");
        for (int index = 0; index < books.length; index++) {
            Book currentBook = books[index];
            if (currentBook.getTitle().equals("Clean code")) {
                System.out.println(currentBook.getTitle() + " - " + currentBook.getPages());
            }
        }
    }
}

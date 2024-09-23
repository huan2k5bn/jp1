import enums.Gender;
import model.Author;
import model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("Tran Anh Huan", "huan@gmail.com", Gender.M);
        Author author2 = new Author("To Mai Trang", "trang@gmail.com", Gender.F);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Programming", author1, 500.0, 10));
        books.add(new Book("Advanced Java", author1, 450.0, 5));
        books.add(new Book("Web Development", author2, 600.0, 7));

        System.out.println("Books sorted by name:");
        books.stream()
                .sorted(Comparator.comparing(Book::getName))
                .forEach(System.out::println);

        Book maxPriceBook = books.stream()
                .max(Comparator.comparingDouble(Book::getPrice))
                .orElse(null);
        System.out.println("\nBook with the highest price: " + maxPriceBook);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter author name to list their books:");
        String authorName = scanner.nextLine();
        List<Book> authorBooks = books.stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());

        if (authorBooks.isEmpty()) {
            System.out.println("No books found for author: " + authorName);
        } else {
            System.out.println("Books by " + authorName + ":");
            authorBooks.forEach(System.out::println);
        }
    }
}

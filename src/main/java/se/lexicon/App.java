package se.lexicon;

/**
 * Book Lender workshop
 * Lexicon
 */
public class App {
    public static void main(String[] args) {
        Book book1 = new Book("Bel Ami", "Guy de Maupassant");
        Book book2 = new Book("Bel Ami 2", "Guy de Maupassant");

        Person person = new Person("Mikael", "Engvall");

        // Lending books
        person.lendBook(book1);
        person.lendBook(book2);

        // Showing borrowed books
        person.showBooks();

        // Returning a book
        person.returnBook(book1);

        // Showing updated borrowed books
        person.showBooks();


    }
}

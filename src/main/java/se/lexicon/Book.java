package se.lexicon;

public class Book
{
    private String title;
    private String author;
    private boolean available = true;
    private Person loanTaker;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // if loanTaker is set -> set available to false  -> else true

    //todo: showPersonInformation()
}

package se.lexicon;

import static se.lexicon.Person.PersonIdGenerator.*;

public class Person {
    private String firstName;
    private String lastName;
    private Integer personId;  // Is to be created as an automatic generator

    public String[] borrowedBooks = new String[3];

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        personId = generateNextIdNumber(); // ClassName.StaticMethodName
    }

    // Methods

    public static class PersonIdGenerator {
        private static int nextId = 1;

        public static int generateNextIdNumber() {
            return nextId++;
        }
    }
    public void lendBook(Book book) {
        if (book.isAvailable()) {
            for (int i = 0; i < borrowedBooks.length; i++) {
                if (borrowedBooks[i] == null) {
                    borrowedBooks[i] = "Author: " + book.getAuthor() + ", Title: " + book.getTitle();
                    book.setAvailable(false); // Mark the book as unavailable
                    break;
                }
            }
        }
    }

    public void returnBook(Book book) {
        if (!book.isAvailable()) {
            for (int i = 0; i < borrowedBooks.length; i++) {
                if (borrowedBooks[i] != null && borrowedBooks[i].equals("Author: " + book.getAuthor() + ", Title: " + book.getTitle())) {
                    borrowedBooks[i] = null;
                    book.setAvailable(true); // Mark the book as available
                    break;
                }
            }
        }
    }
    public void showBooks() {
        System.out.println("Books borrowed by " + getFullName() + ":");
        boolean hasBorrowedBooks = false;
        for (String borrowedBook : borrowedBooks) {
            if (borrowedBook != null) {
                System.out.println(borrowedBook);
                hasBorrowedBooks = true;
            }
        }
        if (!hasBorrowedBooks) {
            System.out.println("No books borrowed.");
        }
    }


    // Getter & Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public static Integer getPersonId() {
//        return personId;
//    }

    public int setPersonId() {
        this.personId = personId;
        return 0;
    }

    public String getFullName() {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        } else if (lastName.isEmpty()) {
            return firstName;
        } else if (firstName.isEmpty()) {
            return lastName;
        } else {
            return firstName + " " + lastName;
        }
    }
}


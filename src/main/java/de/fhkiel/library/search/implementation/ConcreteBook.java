package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Condition;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class ConcreteBook implements de.fhkiel.library.search.Book {
    private final int id;
    private final String name;
    private final List<String> authors;
    private final List<String> keywords;
    private final LocalDate boughtDate;
    private final Optional<LocalDate> borrowedTill;
    private final int timesBorrowed;
    private final Condition condition;

    public ConcreteBook(
            int id,
            String name,
            List<String> authors,
            List<String> keywords,
            LocalDate boughtDate,
            Optional<LocalDate> borrowedTill,
            Condition condition,
            int timesBorrowed
    )
    {
        if (id < 0) throw new IllegalArgumentException();
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        if (authors.isEmpty()) throw new IllegalArgumentException();
        if (keywords.isEmpty()) throw new IllegalArgumentException();
        if (boughtDate.isAfter(LocalDate.now())) throw new DateTimeException("Date must be in past");
        if (!validDate(boughtDate)) throw new DateTimeException("Date must be after first book print");
        if (condition == null) throw new IllegalArgumentException();
        if (timesBorrowed < 0) throw new IllegalArgumentException();
        if (!checkAuthors(authors)) throw new IllegalArgumentException();
        if (!validTimesBorrowed(timesBorrowed, boughtDate)) throw new IllegalArgumentException();
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.keywords = keywords;
        this.boughtDate = boughtDate;
        this.borrowedTill = borrowedTill;
        this.condition = condition;
        this.timesBorrowed = timesBorrowed;
    }

    public boolean checkAuthors(List<String> authors) {
        for (String author : authors) {
            char[] chars = author.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if date is after first book print
     * @param date date to check
     * @return true if date is after first book print
     */
    public boolean validDate(LocalDate date) {
        return !(date.isBefore(LocalDate.of(1454, 1, 1)));
    }

    /**
     * Checks if timesBorrowed is valid
     * given that a book can be borrowed twice a day since bought
     * @param timesBorrowed times a book was borrowed
     * @return true if timesBorrowed is valid
     */
    public boolean validTimesBorrowed(int timesBorrowed, LocalDate boughtDate) {
        long daysBetween = ChronoUnit.DAYS.between(boughtDate, LocalDate.now());
        return (timesBorrowed < 2 * daysBetween);
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public List<String> authors() {
        return this.authors;
    }

    @Override
    public List<String> keywords() {
        return this.keywords;
    }

    @Override
    public Optional<LocalDate> borrowedTill() {
        return this.borrowedTill;
    }

    @Override
    public LocalDate bought() {
        return this.boughtDate;
    }

    @Override
    public int timesBorrowed() {
        return this.timesBorrowed;
    }

    @Override
    public Condition condition() {
        return this.condition;
    }
}

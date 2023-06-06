package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Condition;
import java.time.DateTimeException;
import java.time.LocalDate;
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
        if (id <= 0) throw new IllegalArgumentException();
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        if (authors.isEmpty()) throw new IllegalArgumentException();
        if (keywords.isEmpty()) throw new IllegalArgumentException();
        if (boughtDate.isAfter(LocalDate.now())) throw new DateTimeException("Date must be in past");
        if (borrowedTill.isEmpty()) throw new IllegalArgumentException();
        if (condition == null) throw new IllegalArgumentException();
        if (timesBorrowed < 0) throw new IllegalArgumentException();
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.keywords = keywords;
        this.boughtDate = boughtDate;
        this.borrowedTill = borrowedTill;
        this.condition = condition;
        this.timesBorrowed = timesBorrowed;
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

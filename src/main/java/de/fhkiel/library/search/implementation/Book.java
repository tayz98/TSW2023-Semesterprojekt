package de.fhkiel.library.search.implementation;

import de.fhkiel.library.search.Condition;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class Book implements de.fhkiel.library.search.Book {

    private int id;
    private String name;
    private List<String> authors;
    private List<String> keywords;
    private LocalDate boughtDate;
    private Optional<LocalDate> borrowedTill;
    private int timesBorrowed;
    private Condition condition;

    public Book(int id) {
        this.id = id;
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

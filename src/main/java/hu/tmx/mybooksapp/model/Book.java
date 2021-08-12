package hu.tmx.mybooksapp.model;

public class Book {
    private int id;
    private String title;
    private int releaseDate;
    private Author author;

    public Book(int id, String title, int releaseDate, Author author) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    public Book() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

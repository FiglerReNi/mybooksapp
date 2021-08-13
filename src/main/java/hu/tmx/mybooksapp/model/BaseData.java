package hu.tmx.mybooksapp.model;

import java.util.ArrayList;
import java.util.List;

public class BaseData {

    public static List<Author> authors = new ArrayList<>(List.of(
            new Author(1, "Leiner", "Laura", 36),
            new Author(2, "Sara", "Shepard", 44),
            new Author(3, "Cecily von", "Ziegesar", 51),
            new Author(4, "Stephenie", "Meyer", 47),
            new Author(5, "Anna", "Todd", 32)
    ));

    public static List<Book> books = new ArrayList<>(List.of(
            new Book(1, "Twilight", 2005,  authors.get(3)),
            new Book(2, "New Moon", 2006,  authors.get(3)),
            new Book(3, "Eclipse", 2007,  authors.get(3)),
            new Book(4, "Breaking Dawn", 2008,  authors.get(3)),
            new Book(5, "I Like It Like That", 2004,  authors.get(2)),
            new Book(6, "Because I'm Worth It", 2003,  authors.get(2)),
            new Book(7, "Pretty Little Liars", 2012,  authors.get(1)),
            new Book(8, "Szent Johanna Gimi", 2013,  authors.get(0)),
            new Book(9, "Mindig Karácsony", 2019,  authors.get(0)),
            new Book(10, "Higgy nekem", 2021,  authors.get(0)),
            new Book(11, "After", 2014,  authors.get(4)),
            new Book(12, "After We Collided", 2014,  authors.get(4)),
            new Book(13, "After We Fell", 2014,  authors.get(4)),
            new Book(14, "After Ever Happy", 2015,  authors.get(4))
    ));
}

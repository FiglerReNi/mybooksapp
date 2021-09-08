package hu.tmx.mybooksapp;

import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.Book;
import hu.tmx.mybooksapp.service.AuthorService;
import hu.tmx.mybooksapp.util.DBInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MybooksappApplication {

    @Autowired
    DBInitializer dbInitializer;
    @Autowired
    AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(MybooksappApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            dbInitializer.authorInitializer(List.of(
                    Author.builder().id(1).firstName("Leiner").lastName("Laura").age(36).build(),
                    Author.builder().id(2).firstName("Sara").lastName("Shepard").age(44).build(),
                    Author.builder().id(3).firstName("Cecily von").lastName("Ziegesar").age(51).build(),
                    Author.builder().id(4).firstName("Stephenie").lastName("Meyer").age(47).build(),
                    Author.builder().id(5).firstName("Anna").lastName("Todd").age(32).build()
            ));

            dbInitializer.bookInitializer(List.of(
                    Book.builder().id(1).title("Twilight").releaseDate(2005).author(authorService.getAuthorById(4)).build(),
                    Book.builder().id(2).title("New Moon").releaseDate(2006).author(authorService.getAuthorById(4)).build(),
                    Book.builder().id(3).title("Eclipse").releaseDate(2007).author(authorService.getAuthorById(4)).build(),
                    Book.builder().id(4).title("Breaking Dawn").releaseDate(2008).author(authorService.getAuthorById(4)).build(),
                    Book.builder().id(5).title("I Like It Like That").releaseDate(2004).author(authorService.getAuthorById(3)).build(),
                    Book.builder().id(6).title("Because I'm Worth It").releaseDate(2003).author(authorService.getAuthorById(3)).build(),
                    Book.builder().id(7).title("Pretty Little Liars").releaseDate(2012).author(authorService.getAuthorById(2)).build(),
                    Book.builder().id(8).title("Szent Johanna Gimi").releaseDate(2013).author(authorService.getAuthorById(1)).build(),
                    Book.builder().id(9).title("Mindig Karácsony").releaseDate(2019).author(authorService.getAuthorById(1)).build(),
                    Book.builder().id(10).title("Higgy nekem").releaseDate(2021).author(authorService.getAuthorById(1)).build(),
                    Book.builder().id(11).title("After").releaseDate(2014).author(authorService.getAuthorById(5)).build(),
                    Book.builder().id(12).title("After We Collided").releaseDate(2014).author(authorService.getAuthorById(5)).build(),
                    Book.builder().id(13).title("After We Fell").releaseDate(2014).author(authorService.getAuthorById(5)).build(),
                    Book.builder().id(14).title("After Ever Happy").releaseDate(2015).author(authorService.getAuthorById(5)).build()
            ));
        };
    }
}

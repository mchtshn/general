package com.mucahit.springwebapp.bootstrap;

import com.mucahit.springwebapp.domain.Address;
import com.mucahit.springwebapp.domain.Author;
import com.mucahit.springwebapp.domain.Book;
import com.mucahit.springwebapp.domain.Publisher;
import com.mucahit.springwebapp.repositories.AuthorRepository;
import com.mucahit.springwebapp.repositories.BookRepository;
import com.mucahit.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started bootstrap:");

        Publisher publisher = new Publisher("bob", new Address("line", "state", "city", "zip"));

        publisherRepository.save(publisher);


        Author mucahit = new Author("mucahit", "sahin");
        Book domain = new Book("domain driven design", "12345");

        mucahit.getBooks().add(domain);
        domain.getAuthors().add(mucahit);
        domain.setPublisher(publisher);
        publisher.getBooks().add(domain);

        authorRepository.save(mucahit);
        bookRepository.save(domain);
        publisherRepository.save(publisher);

        Author fatih = new Author("fatih", "sahin");
        Book noEjb = new Book("J2EE development without ejb", "12345");

        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);


        System.out.println("Number of books :: " + bookRepository.count());

        authorRepository.save(fatih);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);

        System.out.println("Number of publishers :: " + publisherRepository.count());
        System.out.println("Publisher's book number :: " + publisher.getBooks().size());

        System.out.println("Ended bootstrap");


    }
}

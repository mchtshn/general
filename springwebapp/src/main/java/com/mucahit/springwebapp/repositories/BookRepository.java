package com.mucahit.springwebapp.repositories;

import com.mucahit.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

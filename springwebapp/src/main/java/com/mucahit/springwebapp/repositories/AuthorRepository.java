package com.mucahit.springwebapp.repositories;

import com.mucahit.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}

package br.com.p2.biblioteca_api.repository;

import br.com.p2.biblioteca_api.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
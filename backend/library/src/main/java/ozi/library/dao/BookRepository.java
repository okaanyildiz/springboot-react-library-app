package ozi.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ozi.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}

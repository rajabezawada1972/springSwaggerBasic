package com.raja.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raja.model.Book;

@Repository
public interface BookRepristory extends JpaRepository<Book, Integer> {

}

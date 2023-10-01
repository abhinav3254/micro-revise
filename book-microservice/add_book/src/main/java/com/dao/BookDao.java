package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pojo.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

}

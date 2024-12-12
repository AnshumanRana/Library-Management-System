package com.LMS.LibraryManagementsystem.Repository;

import com.LMS.LibraryManagementsystem.Entity.Book;
import org.springframework.data.mongodb.core.MongoAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends MongoRepository<Book,String> {

//    Book updateBook(String id,Book book);
}

package com.LMS.LibraryManagementsystem.Repository;

import com.LMS.LibraryManagementsystem.Entity.Book;
import com.LMS.LibraryManagementsystem.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  extends MongoRepository<User,String> {
    Optional<User> findById(String  id);
    void deleteById(String id);


//    User updateUser(String id,User user);
}

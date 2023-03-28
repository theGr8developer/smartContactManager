package com.smart.smartcontactmanager.dao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.smart.smartcontactmanager.model.*;

public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("select u from User u where u.email = :email")
    public User getUserByUserName(@Param("email") String email);
}

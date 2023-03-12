package com.smart.smartcontactmanager.dao;
import org.springframework.data.repository.*;
import com.smart.smartcontactmanager.model.*;

public interface UserRepository extends CrudRepository<User,Integer> {
    
}

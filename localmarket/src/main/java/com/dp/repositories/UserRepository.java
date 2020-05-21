package com.dp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dp.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}

package com.baabbee.iframex.repository;

import org.springframework.data.repository.CrudRepository;

import com.baabbee.iframex.beans.User;

public interface UserRepository extends CrudRepository<User, Long> {

}

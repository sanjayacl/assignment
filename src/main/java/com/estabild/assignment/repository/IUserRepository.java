package com.estabild.assignment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estabild.assignment.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

	public List<User> findByUsername(String username);

}

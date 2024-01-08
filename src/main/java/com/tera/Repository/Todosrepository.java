package com.tera.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tera.Model.Todos;

public interface Todosrepository extends JpaRepository<Todos, Integer> {

	List<Todos> findByUsersId(int userId);

}

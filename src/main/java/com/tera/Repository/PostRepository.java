package com.tera.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tera.Model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUserId(int userId);

}

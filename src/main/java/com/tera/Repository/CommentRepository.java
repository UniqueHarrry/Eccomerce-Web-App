package com.tera.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tera.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	List<Comment> findByPostsUserIdAndPostsId(int userId, int postId);

}

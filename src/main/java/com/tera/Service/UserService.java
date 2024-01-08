package com.tera.Service;

import java.util.List;

import com.tera.Model.CommentDto;
import com.tera.Model.PostDto;
import com.tera.Model.TodosDto;
import com.tera.Model.User;
import com.tera.Model.UserDto;

public interface UserService {
	
	UserDto getUserById(int userId);

	PostDto createPostByUserId(PostDto postDto, int userId);
	
	List<PostDto> getPostByUserID(int userId);
	
	TodosDto createTodosByUserId(TodosDto todosDto, int userId);
	
	List<TodosDto> getTodosByUserID(int userId);
	
	CommentDto createCommentByPostId(CommentDto commentDto , int postId);
	
	List<CommentDto> getCommentByUserIdAndPostId(int userId, int postId);

}

package com.tera.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tera.Model.CommentDto;
import com.tera.Model.PostDto;
import com.tera.Model.TodosDto;
import com.tera.Model.User;
import com.tera.Model.UserDto;
import com.tera.Service.UserServiceImp;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserServiceImp userService;
	
	@GetMapping("{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int userId){
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PostMapping("{userId}/post")
	public ResponseEntity<PostDto> createPostByUserId(@RequestBody PostDto postDto, @PathVariable int userId) {
		return new ResponseEntity<>(userService.createPostByUserId(postDto, userId), HttpStatus.CREATED);
	}
	
	@GetMapping("{userId}/post")
	public ResponseEntity<List<PostDto>> getPostByUserID(@PathVariable int userId){
		return new ResponseEntity<>(userService.getPostByUserID(userId),HttpStatus.OK);
	}
	
	@PostMapping("{userId}/todos")
	public ResponseEntity<TodosDto> createTodosByUserId(@RequestBody TodosDto todosDto, @PathVariable int userId) {
		return new ResponseEntity<>(userService.createTodosByUserId(todosDto, userId), HttpStatus.CREATED);
	}
	
	@GetMapping("{userId}/todos")
	public ResponseEntity<List<TodosDto>> getTodosByUserID(@PathVariable int userId){
		return new ResponseEntity<>(userService.getTodosByUserID(userId),HttpStatus.OK);
	}
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> CreateCommentByPostId(@RequestBody CommentDto commentDto, @PathVariable int postId){
		return new ResponseEntity<>(userService.createCommentByPostId(commentDto, postId), HttpStatus.CREATED);
	}
	
	@GetMapping("{userId}/post/{postId}/comments")
	public ResponseEntity<List<CommentDto>> getCommentByUserIdAndPostId(@PathVariable int userId, @PathVariable int postId){
		return new ResponseEntity<>(userService.getCommentByUserIdAndPostId(userId,postId),HttpStatus.OK);
	}

}

package com.tera.Service;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tera.Model.Comment;
import com.tera.Model.CommentDto;
import com.tera.Model.Post;
import com.tera.Model.PostDto;
import com.tera.Model.Todos;
import com.tera.Model.TodosDto;
import com.tera.Model.User;
import com.tera.Model.UserDto;
import com.tera.Repository.CommentRepository;
import com.tera.Repository.PostRepository;
import com.tera.Repository.Todosrepository;
import com.tera.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private Todosrepository todosrepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	@Override
	public UserDto getUserById(int userId) {
		
		User user = userRepository.findById(userId).orElseThrow(null);
		return mapToDto(user);
	}

	

	public PostDto createPostByUserId(PostDto postDto, int userId) {
		Post post = MapToEntity(postDto);
		User user = userRepository.findById(userId).orElseThrow();
		
		post.setUser(user);
		postRepository.save(post);
		
		return MaptoDto(post);
	}
	
	
	
	public List<PostDto> getPostByUserID(int userId) {
		
		List<Post> posts = postRepository.findByUserId(userId);
		return posts.stream().map(post -> MaptoDto(post)).collect(Collectors.toList());
	}
	
	
	
	@Override
	public TodosDto createTodosByUserId(TodosDto todosDto, int userId) {
		
		Todos todos = mapToEntity(todosDto);
		User user = userRepository.findById(userId).orElseThrow();
		todos.setUsers(user);
		todosrepository.save(todos);
		return mapToDto(todos);
	}
	
	
	
	@Override
	public List<TodosDto> getTodosByUserID(int userId) {
		
		List<Todos> todos = todosrepository.findByUsersId(userId);
		return todos.stream().map(todo -> mapToDto(todo)).collect(Collectors.toList());
	}
	
	
	
	@Override
	public CommentDto createCommentByPostId(CommentDto commentDto, int postId) {
		
		Comment comment = mapToEntity(commentDto);
		Post post = postRepository.findById(postId).orElseThrow();
		
		comment.setPosts(post);
		commentRepository.save(comment);
		
		return mapToDto(comment);
	}
	
	
	
	@Override
	public List<CommentDto> getCommentByUserIdAndPostId(int userId, int postId) {
		
		List<Comment> comments = commentRepository.findByPostsUserIdAndPostsId(userId, postId);
		
		return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
	}
	
	
	//converting Dto to Entity
	public User mapToEntity(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		return user;
	}
	
	//converting Entity to Dto 
	public UserDto mapToDto(User user ) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
	
	//converting Dto to Entity
	public Post MapToEntity(PostDto postDto ) {
		Post post = new Post();
		post.setId(postDto.getId());
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle()); 
		return post;
		}
	//converting Entity to Dto 
	public PostDto MaptoDto(Post post) {
		PostDto postdto = new PostDto();
		postdto.setId(post.getId());
		postdto.setTitle(post.getTitle());
		postdto.setContent(post.getContent());
		return postdto;
		}
	
	
	//converting Dto to Entity
	public Todos mapToEntity(TodosDto todosDto) {
		Todos todos = new Todos();
		todos.setId(todosDto.getId());
		todos.setDueDate(todosDto.getDueDate());
		todos.setName(todosDto.getName());
		todos.setStatus(todosDto.getStatus());
		return todos;
	}
	
	//converting Entity to Dto
	public TodosDto mapToDto(Todos todos) {
		TodosDto todosDto = new TodosDto();
		todosDto.setId(todos.getId());
		todosDto.setDueDate(todos.getDueDate());
		todosDto.setName(todos.getName());
		todosDto.setStatus(todos.getStatus());
		return todosDto;
	}


	//convrting Dto to Entity
	public Comment mapToEntity(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setId(commentDto.getId());
		comment.setBody(commentDto.getBody());
		return comment;
	}
	
	//converting Entity to Dto
	public CommentDto mapToDto(Comment comment) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.setBody(comment.getBody());
		return commentDto;
	}

	

	


	

	



	
}

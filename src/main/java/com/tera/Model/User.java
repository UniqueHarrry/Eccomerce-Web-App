package com.tera.Model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Post> posts = new HashSet<>();

	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Todos> todos = new HashSet<>();

	
	}


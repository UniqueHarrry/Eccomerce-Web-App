package com.tera.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Comment_id")
	private int id;
	
	@Column(name = "Text")
	private String body;
	
	@ManyToOne
	@JoinColumn(name = "Post_id")
	private Post posts;
}

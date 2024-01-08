package com.tera.Model;

import javax.persistence.Column;
import lombok.Data;

@Data
public class CommentDto {

	
	@Column(name ="Comment_id")
	private int id;
	
	@Column(name = "Text")
	private String body;
}

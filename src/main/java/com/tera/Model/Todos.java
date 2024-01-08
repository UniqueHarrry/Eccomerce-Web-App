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
public class Todos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Task_Id")
	private int id;
	
	@Column(name = "Task_Name")
	private String name;
	private String dueDate;
	private String status;
	
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User users;
}

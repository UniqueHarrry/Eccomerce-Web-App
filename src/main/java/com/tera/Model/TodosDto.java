package com.tera.Model;

import javax.persistence.Column;
import lombok.Data;

@Data
public class TodosDto {

	@Column(name = "Task_Id")
	private int id;
	
	@Column(name = "Task_Name")
	private String name;
	private String dueDate;
	private String status;
}

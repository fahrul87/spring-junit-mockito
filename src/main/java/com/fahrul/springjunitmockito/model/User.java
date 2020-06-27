package com.fahrul.springjunitmockito.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collation = "user")
public class User {
	@Id
	private int id;
	private String name;
	private int age;
	private String address;

}

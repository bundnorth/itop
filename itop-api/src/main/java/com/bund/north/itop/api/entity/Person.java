package com.bund.north.itop.api.entity;


import lombok.Data;
import org.springframework.cglib.beans.BeanCopier;

@Data
public class Person {
	private int age;
	private String name;
	private String desc;
	private String hobies;

	public Person(Person1 p1, Person2 p2) {
		BeanCopier.create(Person1.class, Person.class, false)
				.copy(p1, this, null);
		BeanCopier.create(Person2.class, Person.class, false)
				.copy(p2, this, null);
	}
}

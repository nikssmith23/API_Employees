package com.marcos.controller;

public class A {
	int id;
	String name;

	public A() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public A(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

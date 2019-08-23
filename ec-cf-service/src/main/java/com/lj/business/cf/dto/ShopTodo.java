package com.lj.business.cf.dto;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ShopTodo.
 */
public class ShopTodo implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7290755386257285575L;
	
	/** 待办数量. */
	private int todoNum;
	
	/** 待办名称. */
	private String todoName;
	
	/** 类型. */
	private String todoType;
	
	/**
	 * Gets the todo num.
	 *
	 * @return the todo num
	 */
	public int getTodoNum() {
		return todoNum;
	}

	/**
	 * Sets the todo num.
	 *
	 * @param todoNum the new todo num
	 */
	public void setTodoNum(int todoNum) {
		this.todoNum = todoNum;
	}

	/**
	 * Gets the todo name.
	 *
	 * @return the todo name
	 */
	public String getTodoName() {
		return todoName;
	}

	/**
	 * Sets the todo name.
	 *
	 * @param todoName the new todo name
	 */
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	
	/**
	 * Gets the todo type.
	 *
	 * @return the todo type
	 */
	public String getTodoType() {
		return todoType;
	}

	/**
	 * Sets the todo type.
	 *
	 * @param todoType the new todo type
	 */
	public void setTodoType(String todoType) {
		this.todoType = todoType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopTodo [todoNum=").append(todoNum)
				.append(", todoName=").append(todoName).append(", todoType=")
				.append(todoType).append("]");
		return builder.toString();
	}

}

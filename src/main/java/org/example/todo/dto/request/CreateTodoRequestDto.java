package org.example.todo.dto.request;

import org.example.todo.dto.response.TodoResponseDto;
import org.example.todo.entity.Todo;

import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

	private String title;
	private String contents;
	private String name;

	public CreateTodoRequestDto(String title, String contents, String name) {
		this.title = title;
		this.contents = contents;
		this.name = name;
	}
	public static TodoResponseDto toDto(Todo todo) {
		return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents(), todo.getMember());
	}
}

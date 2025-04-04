package org.example.todo.dto.response;

import java.time.LocalDateTime;

import org.example.todo.entity.Member;
import org.example.todo.entity.Todo;

import lombok.Getter;

@Getter
public class TodoResponseDto {

	private Long id;
	private String title;
	private String contents;
	private Member member;

	public TodoResponseDto(Long id, String title, String contents, Member member) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.member = member;
	}

	public static TodoResponseDto toDto(Todo todo) {
		return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents(), todo.getMember());
	}
}

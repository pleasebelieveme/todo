package org.example.todo.dto.response;

import lombok.Getter;

@Getter
public class MemberResponseDto {

	private String name;
	private String email;

	public MemberResponseDto(String name, String email) {
		this.name = name;
		this.email = email;
	}
}

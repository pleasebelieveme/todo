package org.example.todo.dto.request;

import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

	private String oldPassword;
	private String newPassword;

	public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}
}

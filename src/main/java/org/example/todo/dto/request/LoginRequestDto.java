package org.example.todo.dto.request;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class LoginRequestDto {

	@NotBlank(message = "이메일은 필수 입력 값입니다.")
	@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", message = "옳바른 이메일 형식이 아닙니다.")
	private final String email;

	@NotBlank(message = "패스워드는 필수 입력 값입니다.")
	private final String password;

	public LoginRequestDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
}
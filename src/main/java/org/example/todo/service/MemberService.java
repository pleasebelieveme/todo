package org.example.todo.service;

import java.util.List;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.LoginResponseDto;
import org.example.todo.dto.response.MemberResponseDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Service
public interface MemberService {

	LoginResponseDto login(@NotBlank String email, @NotNull String password);
	SignUpResponseDto signUp(SignUpRequestDto requestDto);
	List<MemberResponseDto> findAllMembers();
	MemberResponseDto findById(Long id);
	void updatePassword(Long id, String oldPassword, String newPassword);
	void delete(Long id);
}

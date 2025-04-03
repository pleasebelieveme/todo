package org.example.todo.repository;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
	SignUpResponseDto signUp(SignUpRequestDto requestDto);
}

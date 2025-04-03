package org.example.todo.service;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
	SignUpResponseDto signUp(SignUpRequestDto requestDto);
}

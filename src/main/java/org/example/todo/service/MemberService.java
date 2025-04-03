package org.example.todo.service;

import java.util.List;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.MemberResponseDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
	SignUpResponseDto signUp(SignUpRequestDto requestDto);
	List<MemberResponseDto> findAllMembers();
}

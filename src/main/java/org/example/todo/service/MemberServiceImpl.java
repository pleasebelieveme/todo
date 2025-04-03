package org.example.todo.service;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.example.todo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public SignUpResponseDto signUp(SignUpRequestDto requestDto) {
		return null;
	}
}

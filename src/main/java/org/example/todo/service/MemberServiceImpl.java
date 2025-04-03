package org.example.todo.service;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.example.todo.entity.Member;
import org.example.todo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@Override
	public SignUpResponseDto signUp(SignUpRequestDto requestDto) {
		Member member = new Member(requestDto.getName(), requestDto.getPassword(), requestDto.getEmail());
		Member savedMember = memberRepository.save(member);
		return new SignUpResponseDto(savedMember.getId(), savedMember.getName(), savedMember.getEmail());
	}
}

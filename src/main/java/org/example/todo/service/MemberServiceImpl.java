package org.example.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.MemberResponseDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.example.todo.entity.Member;
import org.example.todo.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	@Override
	public List<MemberResponseDto> findAllMembers() {
		List<Member> memberList = memberRepository.findAll();
		return memberList.stream().map(Member::toDto).collect(Collectors.toList());
	}

	@Override
	public MemberResponseDto findById(Long id) {
		Optional<Member> optionalMember = memberRepository.findById(id);
		if(optionalMember.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exists id : " + id); // 요청은 성공했으나 컨텐츠가 없을 때, 통일성이 중요!
		}
		Member findMember = optionalMember.get();
		return new MemberResponseDto(findMember.getName(), findMember.getEmail());
	}
}

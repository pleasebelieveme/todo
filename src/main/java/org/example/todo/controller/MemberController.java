package org.example.todo.controller;

import java.util.List;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.MemberResponseDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.example.todo.entity.Member;
import org.example.todo.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
		System.out.println("컨트롤러 호출");
		SignUpResponseDto signUpResponseDto = memberService.signUp(requestDto);
		return new ResponseEntity<SignUpResponseDto>(signUpResponseDto, HttpStatus.CREATED);
	}

	@GetMapping
	public List<MemberResponseDto> findAllMembers() {
		return memberService.findAllMembers();
	}
}

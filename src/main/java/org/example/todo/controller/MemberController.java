package org.example.todo.controller;

import java.util.List;

import org.example.todo.common.Const;
import org.example.todo.dto.request.LoginRequestDto;
import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.request.UpdatePasswordRequestDto;
import org.example.todo.dto.response.LoginResponseDto;
import org.example.todo.dto.response.MemberResponseDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.example.todo.entity.Member;
import org.example.todo.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(
		@RequestBody @Valid LoginRequestDto requestDto,
		HttpServletRequest request
	){
		LoginResponseDto responseDto = memberService.login(requestDto.getEmail(),requestDto.getPassword());
		Long id = responseDto.getId();
		HttpSession session = request.getSession();
		session.setAttribute(Const.LOGIN_USER, id);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
		// System.out.println("컨트롤러 호출");
		SignUpResponseDto signUpResponseDto = memberService.signUp(requestDto);
		return new ResponseEntity<SignUpResponseDto>(signUpResponseDto, HttpStatus.CREATED);
	}

	@GetMapping
	public List<MemberResponseDto> findAllMembers() {
		return memberService.findAllMembers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MemberResponseDto> findMemberById(@PathVariable Long id) {
		return new ResponseEntity<MemberResponseDto>(memberService.findById(id), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Void> updatePassword (
		@PathVariable Long id,
		@RequestBody UpdatePasswordRequestDto requestDto
	) {
		memberService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMemberById(@PathVariable Long id) {
		memberService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

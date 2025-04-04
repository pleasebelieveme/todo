package org.example.todo.controller;

import java.util.List;

import org.example.todo.dto.request.CreateTodoRequestDto;
import org.example.todo.dto.response.TodoResponseDto;
import org.example.todo.entity.Member;
import org.example.todo.repository.MemberRepository;
import org.example.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

	private final TodoService todoService;
	private final MemberRepository memberRepository;

	@PostMapping
	public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto requestDto) {
		Member member = memberRepository.findMemberByName(requestDto.getName()).orElseThrow(() -> new RuntimeException("해당 회원을 찾을 수 없습니다."));
		TodoResponseDto TodoResponseDto = todoService.save(requestDto.getTitle(), requestDto.getContents(), member);
		return new ResponseEntity<>(TodoResponseDto, HttpStatus.CREATED);
	}

	@GetMapping
	public List<TodoResponseDto> findAll() {
		return todoService.findAllTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TodoResponseDto> findTodoById(@PathVariable Long id) {
		return new ResponseEntity<>(todoService.findById(id), HttpStatus.OK);
	}
}

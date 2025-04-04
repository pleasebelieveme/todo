package org.example.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.todo.dto.response.MemberResponseDto;
import org.example.todo.dto.response.TodoResponseDto;
import org.example.todo.entity.Member;
import org.example.todo.entity.Todo;
import org.example.todo.repository.MemberRepository;
import org.example.todo.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;
	private final MemberRepository memberRepository;

	@Override
	public TodoResponseDto save(String title, String contents, Member member) {
		Member findMember = memberRepository.findMemberByNameOrElseThrow(member.getName());
		Todo todo = new Todo(title, contents, member);
		todo.setMember(findMember);
		Todo savedTodo = todoRepository.save(todo);
		return new TodoResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents(), savedTodo.getMember());
	}

	@Override
	public List<TodoResponseDto> findAllTodos() {
		List<Todo> todoList = todoRepository.findAll();
		return todoList.stream().map(Todo::toDto).collect(Collectors.toList());
	}

	@Override
	public TodoResponseDto findById(Long id) {
		Optional<Todo> optionalTodo = todoRepository.findById(id);
		if(optionalTodo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Does not exists todo id : " + id);
		}
		Todo findTodo = optionalTodo.get();
		return new TodoResponseDto(findTodo.getId(), findTodo.getTitle(), findTodo.getContents(), findTodo.getMember());
	}

}

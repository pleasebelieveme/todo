package org.example.todo.service;

import org.example.todo.dto.response.TodoResponseDto;
import org.example.todo.entity.Member;
import org.example.todo.entity.Todo;
import org.example.todo.repository.MemberRepository;
import org.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

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
}

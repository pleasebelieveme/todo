package org.example.todo.service;

import java.util.List;

import org.example.todo.dto.response.TodoResponseDto;
import org.example.todo.entity.Member;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {

	public TodoResponseDto save(String title, String contents, Member member);
	List<TodoResponseDto> findAllTodos();
	TodoResponseDto findById(Long id);
	void updateTodo(Long id, String title, String contents);
	void delete(Long id);
}

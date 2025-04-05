package org.example.todo.repository;

import java.util.Optional;

import org.example.todo.dto.request.SignUpRequestDto;
import org.example.todo.dto.response.SignUpResponseDto;
import org.example.todo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

	Optional<Member> findMemberByName(String name);
	Optional<Member> findMemberByEmail(String email);

	default Member findMemberByNameOrElseThrow(String name) {
		return findMemberByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + name));
	}

	default Member findByIdOrElseThrow(Long id) {
		return findById(id)
			.orElseThrow(() ->
				new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Does not exist id = " + id
				));
	}
}

package org.example.todo.entity;

import org.aspectj.weaver.loadtime.definition.Definition;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

// use todo; 실행으로 mysql 스키마를 지정해주지 않으면 오류
@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "longtext")
	private String contents;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public Todo () {}

	public Todo(String title, String contents, Member member) {
		this.title = title;
		this.contents = contents;
		this.member = member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}

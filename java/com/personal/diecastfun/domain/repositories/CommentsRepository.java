package com.personal.diecastfun.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import com.personal.diecastfun.domain.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long>  {
}

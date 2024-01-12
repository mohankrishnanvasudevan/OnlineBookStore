package com.test.library.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.library.entity.AuthorEntity;

@Repository
public interface AuthorRespository extends JpaRepository<AuthorEntity, Long> {
	
	@Query("SELECT a FROM AuthorEntity a WHERE a.authorId = :authorId")
	AuthorEntity getByAuthorId(@Param("authorId") Long authorId);

}

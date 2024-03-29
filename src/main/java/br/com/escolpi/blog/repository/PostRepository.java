package br.com.escolpi.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.escolpi.blog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

package br.com.escolpi.blog.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escolpi.blog.model.Post;
import br.com.escolpi.blog.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post não encontrado."));
	}

	public Post save(Post post) {
		return repository.saveAndFlush(post);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}

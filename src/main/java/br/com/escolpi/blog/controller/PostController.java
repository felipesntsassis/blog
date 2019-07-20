package br.com.escolpi.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.escolpi.blog.entity.Post;
import br.com.escolpi.blog.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/posts/list");
		mv.addObject("posts", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Post post) {
		ModelAndView mv = new ModelAndView("/posts/edit");
		mv.addObject("post", post);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}

	@PostMapping("/save")
	public ModelAndView post(@Valid Post post, BindingResult result) {
		if (result.hasErrors()) {
			return add(post);
		}

		service.save(post);

		return findAll();
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);

		return findAll();
	}

}

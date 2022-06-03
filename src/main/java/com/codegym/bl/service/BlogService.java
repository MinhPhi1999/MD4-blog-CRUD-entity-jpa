package com.codegym.bl.service;

import com.codegym.bl.model.Blog;
import com.codegym.bl.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService{
    // tiêm sự phụ thuộc
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}

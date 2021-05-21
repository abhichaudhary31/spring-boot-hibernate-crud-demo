package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.BlogEntity;
import com.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogService {
     
    @Autowired
    BlogRepository repository;
     
    public List<BlogEntity> getAllBlogs()
    {
        List<BlogEntity> blogList = repository.findAll();
         
        if(blogList.size() > 0) {
            return blogList;
        } else {
            return new ArrayList<BlogEntity>();
        }
    }
     
    public BlogEntity getBlogById(Long id) throws RecordNotFoundException
    {
        Optional<BlogEntity> blog = repository.findById(id);
         
        if(blog.isPresent()) {
            return blog.get();
        } else {
            throw new RecordNotFoundException("No blog record exist for given id");
        }
    }
     
    public BlogEntity createOrUpdateBlog(BlogEntity entity) throws RecordNotFoundException
    {
        Optional<BlogEntity> blog = repository.findById(entity.getId());
         
        if(blog.isPresent())
        {
            BlogEntity newEntity = blog.get();
            newEntity.setBlogContent(entity.getBlogContent());
            newEntity.setBlogDate(entity.getBlogDate());
            newEntity.setBlogTitle(entity.getBlogTitle());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    }
     
    public void deleteBlogById(Long id) throws RecordNotFoundException
    {
        Optional<BlogEntity> blog = repository.findById(id);
         
        if(blog.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No blog record exist for given id");
        }
    }
}
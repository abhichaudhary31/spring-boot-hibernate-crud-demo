package com.demo.web;

import java.util.List;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.BlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.BlogService;
 
@RestController
@RequestMapping("/blog")
public class BlogController
{
    @Autowired
    BlogService service;
 
    @GetMapping
    public ResponseEntity<List<BlogEntity>> getAllBlogs() {
        List<BlogEntity> list = service.getAllBlogs();
 
        return new ResponseEntity<List<BlogEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<BlogEntity> getBlogById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        BlogEntity entity = service.getBlogById(id);
 
        return new ResponseEntity<BlogEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<BlogEntity> createOrUpdateBlog(BlogEntity entity)
                                                    throws RecordNotFoundException {
        BlogEntity updated = service.createOrUpdateBlog(entity);
        return new ResponseEntity<BlogEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteBlogById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteBlogById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}
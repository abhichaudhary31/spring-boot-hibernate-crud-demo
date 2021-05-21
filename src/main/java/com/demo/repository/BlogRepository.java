package com.demo.repository;

import com.demo.model.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 
@Repository
public interface BlogRepository
        extends JpaRepository<BlogEntity, Long> {
 
}

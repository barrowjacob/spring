package com.codeup.springblog.Models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepository extends JpaRepository<Post, Long> {


}
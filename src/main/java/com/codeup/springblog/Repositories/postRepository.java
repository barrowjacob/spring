package com.codeup.springblog.Repositories;

import com.codeup.springblog.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepository extends JpaRepository<Post, Long> {


}

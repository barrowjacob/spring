package com.codeup.springblog.Repositories;

import com.codeup.springblog.Models.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface sandwichRepository extends JpaRepository<Sandwich, Long> {
}

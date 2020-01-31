package com.codeup.springblog.Repositories;

import com.codeup.springblog.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long> {

}

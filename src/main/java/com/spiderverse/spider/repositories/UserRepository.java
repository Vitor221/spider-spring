package com.spiderverse.spider.repositories;

import com.spiderverse.spider.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

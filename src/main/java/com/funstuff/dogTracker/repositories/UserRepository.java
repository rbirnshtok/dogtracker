package com.funstuff.dogTracker.repositories;

import com.funstuff.dogTracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

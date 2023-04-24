package edu.joseph.course.repositories;

import edu.joseph.course.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

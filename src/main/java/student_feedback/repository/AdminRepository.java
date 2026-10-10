package student_feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_feedback.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsernameAndPassword(String username, String password);

}
package student_feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_feedback.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
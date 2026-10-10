package student_feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import student_feedback.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
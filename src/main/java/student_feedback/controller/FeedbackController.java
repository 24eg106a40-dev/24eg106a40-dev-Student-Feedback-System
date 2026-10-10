package student_feedback.controller;

import org.springframework.web.bind.annotation.*;
import student_feedback.entity.Feedback;
import student_feedback.repository.FeedbackRepository;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class FeedbackController {

    private final FeedbackRepository repository;

    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return repository.save(feedback);
    }
}
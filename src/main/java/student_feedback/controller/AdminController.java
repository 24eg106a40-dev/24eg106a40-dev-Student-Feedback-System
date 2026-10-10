package student_feedback.controller;

import org.springframework.web.bind.annotation.*;
import student_feedback.entity.Admin;
import student_feedback.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {

        return repository
                .findByUsernameAndPassword(
                        admin.getUsername(),
                        admin.getPassword()
                )
                .isPresent()
                ? "Login successful"
                : "Invalid username or password";
    }
}
package student_feedback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import student_feedback.entity.Admin;
import student_feedback.repository.AdminRepository;

@SpringBootApplication
public class StudentFeedbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentFeedbackApplication.class, args);
    }

    @Bean
    CommandLineRunner createDefaultAdmin(AdminRepository adminRepository) {
        return args -> {
            if (adminRepository.count() == 0) {
                adminRepository.save(new Admin("admin", "Admin@123"));
                System.out.println("Default admin created: admin / Admin@123");
            }
        };
    }
}
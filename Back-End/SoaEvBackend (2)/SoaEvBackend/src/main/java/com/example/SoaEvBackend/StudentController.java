package com.example.SoaEvBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/signup")
    public StudentEntity signup(@RequestBody StudentEntity student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/GetAll")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<StudentEntity> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody SignInRequest signInRequest) {
        boolean isValid = studentService.validateCredentials(signInRequest.getRegNo(), signInRequest.getPassword());
        if (isValid) {
            return ResponseEntity.ok("Sign-in successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    public static class SignInRequest {
        private String regNo;
        private String password;

        public String getRegNo() {
            return regNo;
        }

        public void setRegNo(String regNo) {
            this.regNo = regNo;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

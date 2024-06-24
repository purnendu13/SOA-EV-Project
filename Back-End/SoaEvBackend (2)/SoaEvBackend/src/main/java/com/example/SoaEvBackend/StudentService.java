package com.example.SoaEvBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public StudentEntity saveStudent(StudentEntity student) {
        return studentRepo.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<StudentEntity> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
    public boolean validateCredentials(String regNo, String password) {
        Optional<StudentEntity> studentOptional = studentRepo.findByRegNo(regNo);
        if (studentOptional.isPresent()) {
            StudentEntity student = studentOptional.get();
            return student.getPassword().equals(password);
        } else {
            return false;
        }
    }

}

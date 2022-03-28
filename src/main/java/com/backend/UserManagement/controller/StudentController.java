package com.backend.UserManagement.controller;
import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/student") // This means URL's start with /student (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
    @Autowired
    private StudentService studentService;

    // Add operation
    @PostMapping("/add")
    public User saveStudent(@RequestBody User student) {
        return studentService.saveStudent(student);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteStudent (@RequestParam long id) {
        studentService.deleteStudentById(id);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<User> fetchStudentList() {
        return studentService.getAllStudents();
    }

    // Update operation
    @PreAuthorize("hasRole('Student')")
    @PutMapping("/update/{id}")
    public User updateStudent(@RequestBody User student, @PathVariable("id") long id) {
        return studentService.updateStudent(student, id);
    }

}
package com.pack.springStudentDemo.Controller;

import com.pack.springStudentDemo.Model.Student;
import com.pack.springStudentDemo.Service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public void addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.create(student);
    }

}

package com.pack.springStudentDemo.Service;

import com.pack.springStudentDemo.Model.Student;
import com.pack.springStudentDemo.Repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student create(Student student) {
        Student studentresp = studentRepo.save(student);
        return studentresp;
    }
}

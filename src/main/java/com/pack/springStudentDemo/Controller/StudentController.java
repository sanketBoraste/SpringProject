package com.pack.springStudentDemo.Controller;

import com.pack.springStudentDemo.DTO.StudentRequestDTO;
import com.pack.springStudentDemo.DTO.StudentResponseDTO;
import com.pack.springStudentDemo.Model.Student;
import com.pack.springStudentDemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentResponseDTO addStudent(
            @RequestBody StudentRequestDTO student) {
//        student.setActive(false);
        return studentService.create(student);
    }

    @PostMapping("/creates")
    public List<Student> create(@RequestBody List<Student> students) {
//        students.setActive(false);
        return studentService.createAll(students);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        Student stdresp =  StudentService.getStudentsById(id);

        if (stdresp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stdresp);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> student = StudentService.getAll();
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        Student stdresp =  StudentService.updateStudent(id,student);
        if (stdresp == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stdresp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        boolean isDeleted = StudentService.DeleteStudent(id);
        if(isDeleted) {
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Integer id){
        boolean isDeleted = StudentService.deleteSoftly(id);
        if(!isDeleted) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok("Deleted");
    }

}

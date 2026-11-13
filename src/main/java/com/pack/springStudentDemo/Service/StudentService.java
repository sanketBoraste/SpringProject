package com.pack.springStudentDemo.Service;

import com.pack.springStudentDemo.DTO.StudentRequestDTO;
import com.pack.springStudentDemo.DTO.StudentResponseDTO;
import com.pack.springStudentDemo.Model.Student;
import com.pack.springStudentDemo.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private static StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

//    public static ResponseEntity<Student> getStudents() {
//        return StudentRepo.
//    }

    public static Student getStudentsById(Integer id) {
        Optional<Student> student = studentRepo.findByIdAndActiveIsFalse(id);
        return student.orElse(null);
    }

    public static List<Student> getAll() {
        return studentRepo.findByActiveIsFalse();
    }

    public static Student updateStudent(Integer id, Student student) {
        Optional<Student> studentupd = studentRepo.findByIdAndActiveIsFalse(id);
        if (studentupd.isEmpty()) {
            return null;
        }
        Student studenttoupdate = studentupd.get();
        studenttoupdate.setName(student.getName());
        studenttoupdate.setRollno(student.getRollno());
        studenttoupdate.setEmail(student.getEmail());
        studenttoupdate.setAge(student.getAge());
        studenttoupdate.setSubject(student.getSubject());
        studenttoupdate.setActive(false);
        return studentRepo.save(studenttoupdate);

    }

    public static boolean DeleteStudent(Integer id) {
        boolean isdeleted = studentRepo.existsById(id);
        if(isdeleted) {studentRepo.deleteById(id);return true;}
        else return false;
    }

    public static boolean deleteSoftly(Integer id) {
        Optional<Student> studentexist =studentRepo.findByIdAndActiveIsFalse(id);
        if (studentexist.isEmpty()) {
            return false;
        }
        Student studentTosave = studentexist.get();
        studentTosave.setActive(true);
        studentRepo.save(studentTosave);
        return true;

    }

    public StudentResponseDTO create(StudentRequestDTO studentreq) {
        Student student = MaptoEntity(studentreq);
        Student studentresp =  studentRepo.save(student);
        return MapToDTO(studentresp);

    }

    public List<Student> createAll(List<Student> students) {
        return studentRepo.saveAll(students);
    }

    private Stud
}

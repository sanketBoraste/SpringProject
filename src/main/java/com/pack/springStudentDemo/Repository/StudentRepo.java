package com.pack.springStudentDemo.Repository;

import com.pack.springStudentDemo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Optional<Student> findByIdAndActiveIsFalse(Integer id);

    List<Student> findByActiveIsFalse();


}

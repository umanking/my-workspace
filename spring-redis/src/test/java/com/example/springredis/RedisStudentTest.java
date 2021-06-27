package com.example.springredis;

import com.example.springredis.entity.Student;
import com.example.springredis.entity.Student.Gender;
import com.example.springredis.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

@SpringBootTest
public class RedisStudentTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void studentSaveTest() {
        Student student = new Student("K001", "andrew", Gender.MALE, 1);
        //KEY: Student:K001 로 저장됨

        // HKEYS Studnet:K001
        // HVALS Studnet:K001
        studentRepository.save(student);
    }

    @Test
    void findAllStudentsTest() {
        Iterable<Student> all = studentRepository.findAll();
        for (Student student : all) {
            System.out.println("student = " + student);
        }
    }

    @Test
    void updateStudentTest() {
        Student student = studentRepository.findById("K001").get();
        System.out.println("saved student = " + student);
        student.setName("Tom");
        student.setGrade(2);
        studentRepository.save(student);

        Student actual = studentRepository.findById("K001").get();
        System.out.println("actual = " + actual);
    }

    //    잘안됨
    @Test
    void queryMethodTest() {
        List<Student> students = studentRepository.findByName("Tom");
        System.out.println(students.size());

        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }

    @Test
    void queryByExamQueryTest() {
        Student student = new Student();
        student.setName("Tom");

        Example<Student> of = Example.of(student);
        Student tom = studentRepository.findOne(of).get();
        System.out.println("tom = " + tom);

    }
}

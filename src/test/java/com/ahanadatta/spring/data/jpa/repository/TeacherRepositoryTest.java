package com.ahanadatta.spring.data.jpa.repository;

import com.ahanadatta.spring.data.jpa.entity.Course;
import com.ahanadatta.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course1 = Course.builder()
                .title("DBMS")
                .credit(5)
                .build();
        Course course2 = Course.builder()
                .title("DSA")
                .credit(5)
                .build();
        Teacher teacher = Teacher
                .builder()
                .firstName("Sudhanshu")
                .lastName("Dalai")
               // .courses(List.of(course1,course2))
                .build();
        teacherRepository.save(teacher);
    }
}
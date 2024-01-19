package com.ahanadatta.spring.data.jpa.repository;

import com.ahanadatta.spring.data.jpa.entity.Guardian;
import com.ahanadatta.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest//helps to test repository layer and flushes data once over
class StudentRepositoryTest {

//    @BeforeEach
//    void setUp() {
//    }

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ahanadatta@gmail.com")
                .firstName("Ahanaa")
                .lastName("Dattaa")
//                .guardianName("Juthikaa Datta")
//                .guardianEmail("juthikaa@gmail.com")
//                .guardianMobile("990999765")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian  = Guardian.builder()
                .email("juthikaa@gmail.com")
                .name("Juthikaa Datta")
                .mobile("990999765")
                .build();

        Student student = Student.builder()
                .firstName("ahana")
                .emailId("ahana@gmail.com")
                .lastName("datta")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("ahana");

        System.out.println("students = " + students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("ana");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Juthika Datta");
        System.out.println("students = " + students);
    }


    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "ahana@gmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress
                        ("ahana@gmail.com");

        System.out.println("firstName = " + firstName);
    }

    //Native
    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative
                        ("ahana@gmail.com");
        System.out.println("student = " + student);

    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam
                        ("ahana@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public  void updateStudentNameByEmailIdTest(){
        studentRepository
                .updateStudentNameByEmailId
                        ("Shana","ahana@gmail.com");
    }

}
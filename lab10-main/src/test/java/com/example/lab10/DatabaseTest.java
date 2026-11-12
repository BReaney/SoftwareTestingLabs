package com.example.lab10;

import com.example.lab10.data.StudentRepository;
import com.example.lab10.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DatabaseTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp(){
        // Optional setup

    }

    @Test
    public void createTest() {
        // TODO: Implement test to verify saving a student
        assertEquals(0, studentRepository.count());
        studentRepository.save(new Student("Able", "Baker", 1));
        assertEquals(1, studentRepository.count());
        Student the_student = studentRepository.findAll().get(0);
        assertEquals(the_student.getFirstName(), "Able");
        assertEquals(the_student.getLastName(), "Baker");
        assertEquals(the_student.getActiveStatus(), 1);

    }


    @Test
    public void deleteTest() {
        // TODO: Implement test to verify deleting a student
        Student S1 = new Student("Tim", "Reaney", 1);
        studentRepository.save(S1);
        assertEquals(1, studentRepository.count());
        studentRepository.deleteById(S1.getId());
        assertEquals(0, studentRepository.count());
    }

    @Test
    public void findByLastNameTest() {
        // TODO: Implement test to find student by last name
        Student S1 = new Student("Tim", "Reaney", 1);
        Student S2 = new Student("Bob", "Dylan", 1);
        Student S3 = new Student("Clint", "Eastwood", 1);
        Student S4 = new Student("Ben", "Owen", 1);
        Student S5 = new Student("George", "Cloony", 1);
        Student S6 = new Student("Steve", "Smith", 1);
        studentRepository.save(S1);
        studentRepository.save(S2);
        studentRepository.save(S3);
        studentRepository.save(S4);
        studentRepository.save(S5);
        studentRepository.save(S6);
        Student Result = studentRepository.findByLastName("Reaney").get(0);
        assertEquals(Result.getFirstName(), S1.getFirstName());
        assertEquals(Result.getLastName(), S1.getLastName());
        assertEquals(Result.getId(),S1.getId());
    }

    @Test
    public void updateTest(){
        Student S1 = new Student("Tim", "Reaney", 1);
        studentRepository.save(S1);
        Student S2 = studentRepository.findAll().get(0);
        S2.setActiveStatus(0);
        studentRepository.deleteById(S1.getId());
        studentRepository.save(S2);

        int result = studentRepository.findAll().get(0).getActiveStatus();
        assertEquals(0, result);

    }
    @Test
    public void activeStudentsTest() {
        // TODO: Implement test for active students query
        Student S1 = new Student("Tim", "Reaney", 1);
        Student S2 = new Student("Bob", "Dylan", 0);
        Student S3 = new Student("Clint", "Eastwood", 1);
        Student S4 = new Student("Ben", "Owen", 0);
        Student S5 = new Student("George", "Cloony", 1);
        Student S6 = new Student("Steve", "Smith", 0);
        studentRepository.save(S1);
        studentRepository.save(S2);
        studentRepository.save(S3);
        studentRepository.save(S4);
        studentRepository.save(S5);
        studentRepository.save(S6);
        List<Student> result = studentRepository.findAllActiveStudents();
        assertEquals(3, result.size());
        Student result1 = result.get(0);
        Student result2 = result.get(1);
        Student result3 = result.get(2);

        assertTrue(result1.equals(S1));
        assertTrue(result2.equals(S3));
        assertTrue(result3.equals(S5));
    }

    @Test
    public void sortedFirstNamesTest() {
        // TODO: Implement test for sorting students by first name
        Student S1 = new Student("Tim", "Reaney", 1);
        Student S2 = new Student("Bob", "Dylan", 1);
        Student S3 = new Student("Clint", "Eastwood", 1);
        Student S4 = new Student("Ben", "Owen", 1);
        Student S5 = new Student("George", "Cloony", 1);
        Student S6 = new Student("Steve", "Smith", 1);
        studentRepository.save(S1);
        studentRepository.save(S2);
        studentRepository.save(S3);
        studentRepository.save(S4);
        studentRepository.save(S5);
        studentRepository.save(S6);
        List<Student> result = studentRepository.findAllFirstNameSort();

        Student result1 = result.get(0);
        Student result2 = result.get(1);
        Student result3 = result.get(2);
        Student result4 = result.get(3);
        Student result5 = result.get(4);
        Student result6 = result.get(5);


        assertTrue(result1.equals(S4));
        assertTrue(result2.equals(S2));
        assertTrue(result3.equals(S3));
        assertTrue(result4.equals(S5));
        assertTrue(result5.equals(S6));
        assertTrue(result6.equals(S1));


    }
}


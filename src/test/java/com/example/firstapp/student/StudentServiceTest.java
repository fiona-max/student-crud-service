package com.example.firstapp.student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(SpringExtension.class)
class StudentServiceTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    void testAddNewStudent() {
        Student student = new Student();
        student.setEmail("jane.doe@example.org");
        student.setDob(LocalDate.ofEpochDay(1L));
        student.setAge(1);
        student.setId(123L);
        student.setName("Name");
        Optional<Student> ofResult = Optional.of(student);
        when(this.studentRepository.findStudentByEmail((String) any())).thenReturn(ofResult);

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setDob(LocalDate.ofEpochDay(1L));
        student1.setAge(1);
        student1.setId(123L);
        student1.setName("Name");
        assertThrows(IllegalStateException.class, () -> this.studentService.addNewStudent(student1));
        verify(this.studentRepository).findStudentByEmail((String) any());
    }

    @Test
    void testAddNewStudent2() {
        Student student = new Student();
        student.setEmail("jane.doe@example.org");
        student.setDob(LocalDate.ofEpochDay(1L));
        student.setAge(1);
        student.setId(123L);
        student.setName("Name");
        when(this.studentRepository.save((Student) any())).thenReturn(student);
        when(this.studentRepository.findStudentByEmail((String) any())).thenReturn(Optional.empty());

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setDob(LocalDate.ofEpochDay(1L));
        student1.setAge(1);
        student1.setId(123L);
        student1.setName("Name");
        this.studentService.addNewStudent(student1);
        verify(this.studentRepository).findStudentByEmail((String) any());
        verify(this.studentRepository).save((Student) any());
        assertTrue(this.studentService.getStudent().isEmpty());
    }

    @Test
    void testAddNewStudent3() {
        Student student = new Student();
        student.setEmail("jane.doe@example.org");
        student.setDob(LocalDate.ofEpochDay(1L));
        student.setAge(1);
        student.setId(123L);
        student.setName("Name");
        Optional<Student> ofResult = Optional.of(student);
        when(this.studentRepository.findStudentByEmail((String) any())).thenReturn(ofResult);

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setDob(LocalDate.ofEpochDay(1L));
        student1.setAge(1);
        student1.setId(123L);
        student1.setName("Name");
        assertThrows(IllegalStateException.class, () -> this.studentService.addNewStudent(student1));
        verify(this.studentRepository).findStudentByEmail((String) any());
    }

    @Test
    void testAddNewStudent4() {
        Student student = new Student();
        student.setEmail("jane.doe@example.org");
        student.setDob(LocalDate.ofEpochDay(1L));
        student.setAge(1);
        student.setId(123L);
        student.setName("Name");
        when(this.studentRepository.save((Student) any())).thenReturn(student);
        when(this.studentRepository.findStudentByEmail((String) any())).thenReturn(Optional.empty());

        Student student1 = new Student();
        student1.setEmail("jane.doe@example.org");
        student1.setDob(LocalDate.ofEpochDay(1L));
        student1.setAge(1);
        student1.setId(123L);
        student1.setName("Name");
        this.studentService.addNewStudent(student1);
        verify(this.studentRepository).findStudentByEmail((String) any());
        verify(this.studentRepository).save((Student) any());
        assertTrue(this.studentService.getStudent().isEmpty());
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(this.studentRepository).deleteById((Long) any());
        when(this.studentRepository.existsById((Long) any())).thenReturn(true);
        this.studentService.deleteStudent(123L);
        verify(this.studentRepository).deleteById((Long) any());
        verify(this.studentRepository).existsById((Long) any());
        assertTrue(this.studentService.getStudent().isEmpty());
    }

    @Test
    void testDeleteStudent2() {
        doNothing().when(this.studentRepository).deleteById((Long) any());
        when(this.studentRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(IllegalStateException.class, () -> this.studentService.deleteStudent(123L));
        verify(this.studentRepository).existsById((Long) any());
    }
}


package com.example.firstapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping(path = "api/v1/student")
    public List<Student> getStudent(){
       return  studentService.getStudent();
    }
    @PostMapping(path = "api/v1/student")
    public void registerNewStudent(@RequestBody Student student){
       studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "api/v1/student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
      studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "api/v1/student/{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);

    }
}

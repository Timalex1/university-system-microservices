package design.boilerplate.springboot.controller;

import design.boilerplate.springboot.request.StudentRequest;
import design.boilerplate.springboot.response.StudentResponse;
import design.boilerplate.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getById/{id}")
    public StudentResponse getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PostMapping("/create")
    public StudentResponse createAddress(@RequestBody StudentRequest studentRequest){
        return studentService.createStudent(studentRequest);
    }

}
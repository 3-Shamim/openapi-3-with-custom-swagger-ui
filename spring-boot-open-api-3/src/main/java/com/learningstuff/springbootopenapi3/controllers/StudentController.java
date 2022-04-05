package com.learningstuff.springbootopenapi3.controllers;

import com.learningstuff.springbootopenapi3.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২৪/২/২২
 * Time: ১০:৫১ AM
 * Email: mdshamim723@gmail.com
 */

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @GetMapping(value = "")
    public List<Student> getStudents() {
        return new ArrayList<>();
    }

    @DeleteMapping(value = "/delete/{id}")
    public Student delete(@PathVariable("id") int id) {
        return null;
    }

    @PostMapping(value = "/create")
    public Student create(@RequestBody Student student) {
        return student;
    }

}

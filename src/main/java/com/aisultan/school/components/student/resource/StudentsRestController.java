package com.aisultan.school.components.student.resource;

import com.aisultan.school.components.student.mapper.StudentsMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsRestController {
    private StudentsMapper studentsMapper;
    public StudentsRestController(StudentsMapper mapper) {
        this.studentsMapper = mapper;
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer studentId) {
        studentsMapper.delete(studentId);
    }
}

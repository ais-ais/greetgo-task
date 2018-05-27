package com.aisultan.school.components.student.resource;


import com.aisultan.school.components.student.mapper.StudentsMapper;
import com.aisultan.school.components.student.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class StudentsResource {

    private StudentsMapper studentsMapper;

    public StudentsResource(StudentsMapper studentsMapper){
        this.studentsMapper = studentsMapper;
    }

    @GetMapping("/all")
    public String getAll(){
        System.out.println(studentsMapper.findAll());
        return "redirect:/main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("students", studentsMapper.findAll());
        return "main";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("students", new Students());
        return "add";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String newStudent(@Valid Students students, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "add";
        }

        System.out.println(students.getAdvisor());

        studentsMapper.insert(students);
        return "redirect:/main";
    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:/main";
    }
}

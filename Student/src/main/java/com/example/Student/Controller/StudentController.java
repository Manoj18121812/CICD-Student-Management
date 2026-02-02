package com.example.Student.Controller;

import com.example.Student.Entity.Student;
import com.example.Student.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service= service;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", service.getAllStudent());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("student", service.getStudentById(id));
        return "edit";
    }


    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Student student){
        service.saveStudent(student);
        return "redirect:/";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteStudent(id);
        return "redirect:/";
    }
}


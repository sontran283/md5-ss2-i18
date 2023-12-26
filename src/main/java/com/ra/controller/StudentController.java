package com.ra.controller;

import com.ra.model.entity.Classs;
import com.ra.model.entity.Student;
import com.ra.model.service.classs.ClassService;
import com.ra.model.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String index(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "/student/student";
    }

    @GetMapping("/add_student")
    public String addStudent(Model model) {
        List<Classs> classList = classService.findAll();
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("classList", classList);
        return "student/add_student";
    }

    @PostMapping("/add_student")
    public String createStudent(@ModelAttribute("student") Student student) {
        if (studentService.saveOrUpdate(student)) {
            return "redirect:/student";
        } else {
            return "/student/add_student";
        }
    }

    @GetMapping("/edit_student/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model) {
        List<Classs> classList = classService.findAll();
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("classList", classList);
        return "student/edit_student";
    }

    @PostMapping("/edit_student/{id}")
    public String updateStudent(@PathVariable("id") Integer id, @ModelAttribute("student") Student student) {
        if (studentService.saveOrUpdate(student)) {
            return "redirect:/student";
        }
        return "student/edit_student";
    }

    @GetMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return "redirect:/student";
    }
}

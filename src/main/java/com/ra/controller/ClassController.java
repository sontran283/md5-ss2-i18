package com.ra.controller;

import com.ra.model.entity.Classs;
import com.ra.model.service.classs.ClassService;
import com.ra.model.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/class")
    public String index(Model model) {
        List<Classs> classsList = classService.findAll();
        model.addAttribute("classsList", classsList);
        return "class";
    }

    @GetMapping("/add_class")
    public String addClass(Model model) {
        Classs classs = new Classs();
        model.addAttribute("classs", classs);
        return "add_class";
    }

    @PostMapping("/add_class")
    public String createClass(@ModelAttribute("classs") Classs classs) {
        if (classService.saveOrUpdate(classs)) {
            return "redirect:/class";
        }
        return "add_class";
    }

    @GetMapping("/edit_class/{id}")
    public String editClass(@PathVariable("id") Integer id, Model model) {
        Classs classs = classService.findById(id);
        model.addAttribute("classs", classs);
        return "edit_class";
    }

    @PostMapping("/edit_class/{id}")
    public String updateClass(@PathVariable("id") Integer id, @ModelAttribute("classs") Classs classs) {
        if (classService.saveOrUpdate(classs)) {
            return "redirect:/class";
        }
        return "redirect:/class" + id;
    }

    @GetMapping("/delete_class/{id}")
    public String deleteClass(@PathVariable("id") Integer id) {
        classService.delete(id);
        return "redirect:/class";
    }
}

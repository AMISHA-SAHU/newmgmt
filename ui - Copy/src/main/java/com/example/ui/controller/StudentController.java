package com.example.ui.controller;

import com.example.ui.model.Department;
import com.example.ui.model.Student;
import com.example.ui.services.Deptservices;
import com.example.ui.services.StudentService;
import com.example.ui.services.StudentServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class StudentController {
        @Autowired
        private StudentService studentService;
        @Autowired
        private Deptservices deptservices;
        @GetMapping("/")
        public ModelAndView Display(){

               //model.addAttribute();
               ModelAndView modelAndView=new ModelAndView();
               modelAndView.addObject("StudentList",studentService.getAllStudent());
               modelAndView.setViewName("home.html");
               return modelAndView;
        }
        @GetMapping("/adddetails")
        public ModelAndView addDetails(){
            Student student=new Student();

            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("student",student);
            modelAndView.setViewName("adddetails.html");
            return modelAndView;
        }
        @PostMapping("/savedetails")
        public RedirectView saveDetails(@ModelAttribute("student") Student student){

            studentService.SaveStudent(student);
            RedirectView redirectView= new RedirectView();
            redirectView.setUrl("/");
            return redirectView;
        }
         @GetMapping("/updateform/{id}")
       public ModelAndView updateform(@PathVariable (value = "id") int id){
            //get student from service
             Student student=studentService.getStudentbyid(id);
             ModelAndView modelAndView=new ModelAndView();
             modelAndView.addObject("student",student);
             modelAndView.setViewName("update_form.html");
             return modelAndView;
         }
         @GetMapping("/deleteData/{id}")
      public RedirectView deleteData(@PathVariable(value = "id") int id){
            studentService.deletDatabyid(id);
             RedirectView redirectView= new RedirectView();
             redirectView.setUrl("/");
             return redirectView;
         }
         @GetMapping("/getdeptdetail/{department}")
     public  ModelAndView showdeptdetail (@PathVariable (value="department")String department){
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.addObject("department",deptservices.getdepartment(department));
            modelAndView.setViewName("departmentDetail.html");
            return modelAndView;
         }



        }

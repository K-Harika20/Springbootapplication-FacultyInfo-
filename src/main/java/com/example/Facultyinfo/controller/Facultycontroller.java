package com.example.Facultyinfo.controller;

import com.example.Facultyinfo.model.Faculty;
import com.example.Facultyinfo.service.Facultyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/Harika")

public class Facultycontroller {
    @Autowired
    private Facultyservice service;
    @PostMapping("/addfaculty")
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return service.createfaculty(faculty);
    }
    @PostMapping ("/addfaculties")
    public List<Faculty> addfaculties(@RequestBody List<Faculty> faculties){

        return  service.createfaculties(faculties);
    }
    @GetMapping("/faculty/{id}")
    public Faculty getfaculty(@PathVariable int id){
        return service.getfaculty(id);
    }
    @GetMapping("/faculty")
    public List<Faculty> getfaculty(){

        return service.getfaculty();
    }
    @DeleteMapping("/faculty/{id}")
    public String deletefaculty(@PathVariable int id){
        return service.deletefaculty(id);
    }
    @PutMapping("/faculty/{id}")
    public Faculty updatefaculty(@PathVariable int id,@RequestBody Faculty faculty){
        return service.updatefaculty(id, faculty);
    }

}

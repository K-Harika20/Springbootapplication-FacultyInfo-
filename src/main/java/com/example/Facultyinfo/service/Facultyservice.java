package com.example.Facultyinfo.service;

import com.example.Facultyinfo.model.Faculty;
import com.example.Facultyinfo.repository.Facultyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Facultyservice {
    @Autowired
    private Facultyrepo repo;
    public Faculty createfaculty(Faculty faculty) {
        return repo.save(faculty);
    }
    public List<Faculty> createfaculties(List<Faculty> faculties) {
        return  repo.saveAll(faculties);
    }
    public List<Faculty> getfaculty() {

        return repo.findAll();
    }


    public Faculty getfaculty(int id) {
        return repo.findById(id).orElse(null);
    }


    public String deletefaculty(int id) {
        repo.deleteById(id);
        return "faculty data deleted with "+ id;
    }

    public Faculty updatefaculty(int id, Faculty faculty) {
        Optional<Faculty> faculty1=repo.findById(id);
        if(faculty1.isPresent()){
            Faculty faculty2=faculty1.get();
            faculty2.setName(faculty.getName());
            faculty2.setDepartment(faculty.getDepartment());
            faculty2.setDesignation(faculty.getDesignation());
            faculty2.setEmail(faculty.getEmail());
            faculty2.setPhone(faculty.getPhone());
            faculty2.setAddress(faculty.getAddress());
            faculty2.setPassword(faculty.getPassword());
            return repo.save(faculty2);
        }
        else{
            throw new RuntimeException("Faculty not found with id: " + id);
        }

    }


}

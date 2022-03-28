package com.backend.UserManagement.controller;

import com.backend.UserManagement.entity.User;
import com.backend.UserManagement.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/company") // This means URL's start with professor (after Application path)
@CrossOrigin(origins = "http://localhost:3000")

public class CompanyController {
    @Autowired
    private CompanyService companyService;

    // Add operation
    @PostMapping(path="/add")
    public User saveCompany(@RequestBody User user) {
        return companyService.saveCompany(user);
    }

    // Delete operation
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteCompany (@RequestParam long id) {
        companyService.deleteCompanyById(id);
        return "Deleted";
    }

    // Get all operation
    @GetMapping(path="/all")
    public List<User> fetchCompanyList() {
        return companyService.getAllCompany();
    }

    // Update operation
    @PutMapping("/update/{id}")
    public User updateCompany(@RequestBody User user, @PathVariable("id") int id) {
        return companyService.updateCompany(user, id);
    }
}
package com.ccp.demo.service;


import com.ccp.demo.controller.AuthController;
import com.ccp.demo.model.Student;
import com.ccp.demo.model.Traveller;
import com.ccp.demo.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Traveller saveTraveller(Traveller traveller) {
        return studentRepository.save(traveller);
    }

    @Override
    public Traveller loginTraveller(String username, String password) {
        Traveller traveller = studentRepository.findByUsername(username);
        logger.info("Searched for: {}"+ username+ password);

        //logger.info("Searched for: {}", studentRepository.findByUsername(username).getUsername()+ studentRepository.findByUsername(username).getPassword());
        if (traveller != null && traveller.getPassword().equals(password)) {
            return traveller;
        }
        return null; // Return null if traveller is not found or password does not match
    }

}
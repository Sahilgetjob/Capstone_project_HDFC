package com.hdfc.capstone.clientwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hdfc.capstone.clientwebservice.entity.EmployeeDto;

@RestController
public class ClientController{

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_URL = "https://localhost:8443/api/v1/";

    @GetMapping("/webService/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int employeeId){
        
        return restTemplate.getForEntity(SERVICE_URL+employeeId, EmployeeDto.class);
    }
}
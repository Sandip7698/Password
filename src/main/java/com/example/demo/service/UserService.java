package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.dto.Userdto;

public interface UserService {

	ResponseEntity<String> save(Userdto userdto);

}

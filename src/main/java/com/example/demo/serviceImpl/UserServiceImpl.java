package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.Userdto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	PasswordEncoder passwordEncoder ;
	@Override
	public ResponseEntity<String> save(Userdto userdto) {
		
		User user=new User();
		user.setUserName(userdto.getUserName());
		this.passwordEncoder=new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(userdto.getPassword()));
		userRepository.save(user);
		return new ResponseEntity<>("200 SUCCESSFULL REGISTERED",HttpStatus.OK);
	}

}

package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.ContactDto;
import com.user.dto.UserDto;
import com.user.feignclient.ConsumeContactService;
import com.user.feignclient.ContactServiceClasses;
import com.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ConsumeContactService consumeContactService;

	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId) {
		UserDto userDto = this.userService.getUserById(userId);
		ContactDto contactDto = consumeContactService.getContactById(userId);
		userDto.setContactId(contactDto.getContactId());
		ContactServiceClasses contactServiceClasses = new ContactServiceClasses();
		contactServiceClasses.setUserDto(userDto);
		contactServiceClasses.setContactDto(contactDto);
		return new ResponseEntity<ContactServiceClasses>(contactServiceClasses, HttpStatus.OK);
	}
	
	@GetMapping("/qwe")
	public ContactDto testConsumer() {
		return consumeContactService.getContactById(1);
	}
}

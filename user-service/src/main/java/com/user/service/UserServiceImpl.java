package com.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserDto;
import com.user.entity.User;
import com.user.exception.UserNotFoundException;
import com.user.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public UserDto getUserById(int userId) {
		
		User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id " + userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	
}

package com.user.feignclient;

import com.user.dto.ContactDto;
import com.user.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactServiceClasses {

	private UserDto userDto;
	private ContactDto contactDto;
}

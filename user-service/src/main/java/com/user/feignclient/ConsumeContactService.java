package com.user.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.dto.ContactDto;

@FeignClient("CONTACT-SERVICE")
public interface ConsumeContactService {

	@GetMapping("/contact/{contactId}")
	public ContactDto getContactById(@PathVariable int contactId);
}

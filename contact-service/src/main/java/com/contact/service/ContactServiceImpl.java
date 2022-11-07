package com.contact.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.dto.ContactDto;
import com.contact.entity.Contact;
import com.contact.repo.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ContactRepo contactRepo;

	@Override
	public ContactDto getContactById(int contactId) {
		Contact contact = this.contactRepo.findById(contactId).get();
		

		return this.modelMapper.map(contact, ContactDto.class);
	}

}

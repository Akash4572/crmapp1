package com.zohocrm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Entities.Contact;
import com.zohocrm.Repositories.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	@Override
	public void saveContact(Contact contact) {

		contactRepo.save(contact);
	}

}

package com.zohocrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entities.Contact;
import com.zohocrm.Entities.Lead;
import com.zohocrm.Services.ContactService;
import com.zohocrm.Services.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	@Autowired
	private ContactService contactService;
	//http://localhost:3306/zohocrmapp/viewCreateLeadPage
	@GetMapping("/viewCreateLeadPage")
	public String viewCreateLeadPage() {
		
		return"create_new_lead";
	}
	@PostMapping("/save")
	public String saveLead(@ModelAttribute ("lead") Lead lead,Model model) {
	
	leadService.saveOneLead(lead);
	model.addAttribute("lead", lead);
		return "lead_info";
}
	@PostMapping("/converLead")
	public String converLead(@RequestParam ("id") long id) {
		Lead lead=leadService.findLeadById(id);
		Contact contact = new Contact ();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveContact(contact);
		leadService.deleteLeadById(id);
		return "";
	}
	
}

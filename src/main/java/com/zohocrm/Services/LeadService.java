package com.zohocrm.Services;


import com.zohocrm.Entities.Lead;

public interface LeadService  {

	public void saveOneLead(Lead lead);

	public Lead findLeadById(long id);

	public void deleteLeadById(long id);
}

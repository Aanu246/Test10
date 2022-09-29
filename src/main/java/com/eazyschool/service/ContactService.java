package com.eazyschool.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import org.springframework.web.context.annotation.ApplicationScope;
//import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

import com.eazyschool.constants.EazySchoolConstants;
import com.eazyschool.model.Contact;
import com.eazyschool.repository.ContactRepository;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Service
//@RequestScope
//@SessionScope
//@ApplicationScope
public class ContactService {
	//private static Logger log = LoggerFactory.getLogger(ContactService.class);
	//private int counter = 0;
	
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	
	
	public ContactService() {
		System.out.println("Contact Service Bean initialized");
	}
	public  boolean saveMessageDetails(Contact contact) {
		boolean isSaved = true;
		contact.setStatus(EazySchoolConstants.OPEN);
		contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
		contact.setCreatedAt(LocalDateTime.now());
		int result = contactRepository.saveContactMsg(contact);
		
		if(result>0) {
			isSaved = true;
		}
		//log.info(contact.toString());
		return isSaved;
	}
	
	
	public  List<Contact> findMsgWithOpenStatus(){
		List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
	
		return contactMsgs;
	}
	
	public boolean updateMsgStatus(int contactId,String updatedBy) {
		boolean isUpdated = false;
		int result = contactRepository.updateMsgStatus(contactId,EazySchoolConstants.CLOSE, updatedBy);
		if(result>0) {
			isUpdated = true;
		}
		return isUpdated;
	}
	
	
	//public int getCounter() {
		//return counter;
	//}
//	public void setCounter(int counter) {
	//	this.counter = counter;
	//}

}

package com.io.phonebook.service;

import com.io.phonebook.entity.Contact;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService  {

    public Boolean saveContact(Contact contact);
    public List<Contact> getAllContacts();
    public Page<Contact> getAllContactsNEW(Integer pageNo, Integer pageSize);
    public Contact getContactById(Integer contactId);
    public Boolean deleteContactById(Integer contactId);
    public Boolean isContactExists(Contact contact);

}

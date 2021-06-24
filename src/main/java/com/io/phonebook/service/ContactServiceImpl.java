package com.io.phonebook.service;

import com.io.phonebook.entity.Contact;
import com.io.phonebook.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepo repo;

    @Autowired
    public ContactServiceImpl(ContactRepo repo) {
        this.repo = repo;
    }

    @Override
    public Boolean saveContact(Contact contact) {
         contact.setActiveSw("ACTIVE");
         Contact savedEntity = repo.save(contact);
         if(savedEntity!=null && savedEntity.getContactId()!=null) {
             return true;
         }
         return false;
    }

    @Override
    public List<Contact> getAllContacts() {
        Contact filter= new Contact();
        filter.setActiveSw("ACTIVE");
        Example<Contact> ex=  Example.of(filter);
        return repo.findAll(ex);
    }

    @Override
    public Page<Contact> getAllContactsNEW(Integer pageNo, Integer pageSize) {
        Contact filter= new Contact();
        filter.setActiveSw("ACTIVE");
        Example<Contact> ex=  Example.of(filter);
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return repo.findAll(ex,pageRequest);
    }

    // For edit
    @Override
    public Contact getContactById(Integer contactId) {
        Optional<Contact> contact = repo.findById(contactId);
        if(contact.isPresent()) {
            return contact.get();
        }
        return null;
    }

    @Override
    public Boolean deleteContactById(Integer contactId) {
        // Soft delete :
        Optional<Contact> findbyId = repo.findById(contactId);
        if(findbyId.isPresent()){
            Contact contact = findbyId.get();
            contact.setActiveSw("DELETE");
            repo.save(contact);
            return true;
        }
        return false;
    }

    @Override
    public Boolean isContactExists(Contact contact) {
        Example<Contact> example = Example.of(contact);
        return repo.exists(example);
    }
}

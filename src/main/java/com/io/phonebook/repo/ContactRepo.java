package com.io.phonebook.repo;


import com.io.phonebook.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Serializable> {


}

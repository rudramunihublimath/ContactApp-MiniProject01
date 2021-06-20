package com.io.phonebook.controller;

import com.io.phonebook.entity.Contact;
import com.io.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/editContact")
    public ModelAndView handleEditLinkClick(@RequestParam("cid") Integer contactId){
        Contact cobj = contactService.getContactById(contactId);

        ModelAndView mav = new ModelAndView();
        mav.addObject("contact",cobj);
        mav.setViewName("contact");

        return mav;
    }

    @GetMapping("/deleteContact")
    public String handleDeleteLinkClick(@RequestParam("cid") Integer contactId){
        contactService.deleteContactById(contactId);
        return "redirect:viewContacts";
    }
}

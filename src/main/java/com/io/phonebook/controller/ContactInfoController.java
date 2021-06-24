package com.io.phonebook.controller;

import com.io.phonebook.constant.AppConstant;
import com.io.phonebook.entity.Contact;
import com.io.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactInfoController {

    @Autowired
    private ContactService contactService;


    @GetMapping("/loadForm")
    public String loadRegForm(Model model){
        model.addAttribute(AppConstant.CONTACT,new Contact());
        return AppConstant.CONTACT;
    }

    @PostMapping("/saveContact")
    public String handleSaveBtnClick(@Valid Contact contact, BindingResult result, Model model){
        if(result.hasErrors()){
            return AppConstant.CONTACT;
        }

        Boolean contactExists = contactService.isContactExists(contact);
        if(contactExists){
            model.addAttribute("errMsg","Duplicate Contact found");
        }else {
            Boolean savedata = contactService.saveContact(contact);
            if(savedata)
                model.addAttribute("succMsg","Contact saved Successfully");
            else
                model.addAttribute("errMsg","Failed to saved Contact");
        }
        return  AppConstant.CONTACT;
    }

    @GetMapping("/viewContacts")
    public ModelAndView handleViewAllContactsClick(HttpServletRequest request){
        Integer pageSize=3;
        Integer pageNo=1;
        String parameter = request.getParameter("pNo");
        if(parameter!=null && !"".equals(parameter)) {
            pageNo = Integer.parseInt(parameter);
        }
        Page<Contact>  page = contactService.getAllContactsNEW(pageNo-1, pageSize);
        int totalPages = page.getTotalPages();
        List<Contact> allContacts = page.getContent();
        ModelAndView mav= new ModelAndView();
        mav.addObject("contacts",allContacts);
        mav.addObject("tp",totalPages);
        mav.addObject("currPno",pageNo);
        mav.setViewName("viewContacts");
        return mav;
    }

}

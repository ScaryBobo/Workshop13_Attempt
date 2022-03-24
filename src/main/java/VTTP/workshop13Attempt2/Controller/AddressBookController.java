package VTTP.workshop13Attempt2.Controller;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import VTTP.workshop13Attempt2.Model.ContactModel;
import VTTP.workshop13Attempt2.Utility.ContactUtil;

@Controller
public class AddressBookController {
    
    
    @GetMapping(path="/")
    public String contactform(Model model){
        model.addAttribute("contact", new ContactModel());
        return "contactform";
    }

    @PostMapping(path="/contact")
    public String submitContact(@ModelAttribute ContactModel contact, 
                                Model model, HttpServletResponse httpResponse){
    System.out.println("ID: " + contact.getId());
    System.out.println("Name: " + contact.getName());
    System.out.println("Email: " + contact.getEmail());
    System.out.println("Phone Number:" + contact.getPhoneNumber());
    
    httpResponse.setStatus(HttpStatus.CREATED.value());
    ContactUtil ct = new ContactUtil();
    ct.saveContact(contact, model);
    model.addAttribute("contact", new ContactModel(contact.getName(), contact.getEmail(), contact.getPhoneNumber(), contact.getId()));
    return "showcontact";
    }

    @GetMapping(path="/contact/{id}")
    public String getContactByIdString(@PathVariable String id, Model model){
        ContactUtil ct = new ContactUtil();
        ct.getContactById(model, id);

        return "showcontact";
    }

}



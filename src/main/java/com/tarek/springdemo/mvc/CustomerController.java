package com.tarek.springdemo.mvc;


import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add initbinder ... to convert trim input strings
    // remove leading and trailing whitespaces
    // resolve issue for our validation

    @InitBinder
    public void  initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);

    }

    @GetMapping("/")
    public String showForm(Model theModel){

        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult){

        System.out.println("last name " + theCustomer.getLastName());
        System.out.println("Binding result " + theBindingResult.toString());
        System.out.println("postal code "+ theCustomer.getPostalCode());
        System.out.println("\n\n\n\n\n");
        if (theBindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }

    }
}

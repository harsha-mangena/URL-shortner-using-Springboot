package com.harshamangena.urlshortner.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /**
     * API : /home
     */
    @GetMapping("/home")
    public String sayHello(){
        return "This is working fine.";
    }
    
}

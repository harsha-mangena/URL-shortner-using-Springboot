package com.harshamangena.urlshortner.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HomeController {

    /**
     * API : /home
     */
    @GetMapping("/home")
    public String sayHello(){
        log.info("Inside HomeControllers : End point -> /home");
        return "This is working fine.";
    }
    
}

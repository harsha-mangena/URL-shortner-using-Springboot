package com.harshamangena.urlshortner.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harshamangena.urlshortner.Exceptions.UrlAlreadyExistsException;
import com.harshamangena.urlshortner.Models.UrlDto;
import com.harshamangena.urlshortner.Services.UrlServiceImpl;

@RestController
@RequestMapping("/v1")
public class UrlController {

    @Autowired
    UrlServiceImpl urlService;
    
    /**
     * API : /register
     * param : String longUrl
     * return :Object UrlDto
     */
    @GetMapping("/register")
    public UrlDto registerLongUrl(@RequestParam String longUrl){
        return urlService.registerURL(longUrl);
    }

    /**
     * API : /register-custom
     * param : String longUrl, string shortUrl
     * return : Object UrlDto.
     */
    @GetMapping("/register-custom")
    public UrlDto registerCustomUrl(@RequestParam String longUrl, @RequestParam String customUrl){
        UrlDto response = urlService.registerUrl(longUrl, customUrl);

        if(response == null){
            throw new UrlAlreadyExistsException();
        }

        return response;
    }
}

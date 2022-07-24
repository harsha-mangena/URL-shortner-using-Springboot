package com.harshamangena.urlshortner.Services;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshamangena.urlshortner.Models.UrlDto;
import com.harshamangena.urlshortner.Repositories.UrlRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UrlServiceImpl implements IUrlService {

    @Autowired
    UrlRepository urlRepository;

    private UrlDto url;

    protected final String urlStarter = "https://shorted/" ;
    protected final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    protected String shortUrlHelper(){
        StringBuilder saltUrl = new StringBuilder();
        Random rnd = new Random();

        for(int i=0; i<8; i++) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            saltUrl.append(CHARS.charAt(index));
        }
        return urlStarter + saltUrl.toString();
    }


    /**
     * Method : This method checks if the system generated shortUrl is valid or not.(i.e generated url in the database or not)
     * @param url
     * @return boolean.
     */

    protected boolean isValidShortUrl(String url){
        log.info("Hitted DB checkpoint for shortURL");
        UrlDto  dtoResponse = urlRepository.findByshortUrl(url);
        return dtoResponse == null;

    } 

    /**
     * Method : Checks if the provided long url is already in the database.
     * @param url
     * @return Object UrlDto
     */
    protected UrlDto isValidLongUrl(String url){
        log.info("Hitted DB checkpoint for longURL");
        UrlDto dtoResponse = urlRepository.findBylongUrl(url);
        return dtoResponse;
    }

    /**
     * Method : This method is used to generate the short-url and to store
     */
    @Override
    public UrlDto registerURL(String longUrl) {
        String shortUrl = shortUrlHelper();

        //Checking if the given longurl is not in the system.
        url = isValidLongUrl(longUrl);

        if(url != null){
            return url;
        }
        
        //Checking if the shortUrl
        while(isValidShortUrl(shortUrl) != true){
            shortUrl = shortUrlHelper();
        }

        return saveURL(longUrl, shortUrl);
    }

    /**
     * Method : This method is used to store the customm urls provided by the user.
     */

    @Override
    public UrlDto registerUrl(String longUrl, String customUrl) {

        //Checking if the longUrl already in DB
        url = isValidLongUrl(longUrl);

        if(url != null){
            return url;
        }

        //Checking if the shortUrl already in DB
        if(isValidShortUrl(customUrl) != true){
            return null;
        }

        return saveURL(longUrl, customUrl);
    }

    
    private UrlDto saveURL(String longUrl, String shortUrl) {
        UrlDto request = UrlDto.builder()
                         .longUrl(longUrl)
                         .shortUrl(shortUrl)
                         .createdAt(LocalDate.now().toString())
                         .build();

        return urlRepository.save(request);
    }
    


}

package com.harshamangena.urlshortner.Services;

import com.harshamangena.urlshortner.Models.UrlDto;

public interface IUrlService {
    /**
     * Method : registerURL
     * @param : String longUrl
     * @return : Object UrlDto after saving in DB
     */
    public UrlDto registerURL(String longUrl);

    /**
     * Method : registerURL
     * @param : String longUrl, String shortUrl
     * @return : Object UrlDto after saving in DB
     */
    public UrlDto registerUrl(String longUrl, String shortUrl);
}

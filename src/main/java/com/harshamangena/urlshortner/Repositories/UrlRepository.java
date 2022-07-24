package com.harshamangena.urlshortner.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshamangena.urlshortner.Models.UrlDto;


@Repository
public interface UrlRepository  extends JpaRepository<UrlDto, String>{
    
    public UrlDto findByshortUrl(String shortUrl);

    public UrlDto findBylongUrl(String longUrl);
}

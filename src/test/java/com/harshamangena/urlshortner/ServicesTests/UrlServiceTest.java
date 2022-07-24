package com.harshamangena.urlshortner.ServicesTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.harshamangena.urlshortner.Models.UrlDto;
import com.harshamangena.urlshortner.Services.UrlServiceImpl;

@TestInstance(value = Lifecycle.PER_CLASS)
public class UrlServiceTest {
    
    @Mock
    private UrlServiceImpl urlService;

    String longUrl = "https://random.com/this-is-a-random-string-to-test";
    String shortUrl = "http://random.com/tiarsot";

    @BeforeAll
    void setUp(){

        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void registerUrlWithLongUrl(){

        when(urlService.registerURL(longUrl)).thenReturn(UrlDto.builder()
                                                                      .longUrl(longUrl)
                                                                      .shortUrl(shortUrl)
                                                                      .createdAt(LocalDate.now().toString())
                                                                      .build());

        UrlDto response = urlService.registerURL(longUrl);

        assertNotNull(response);

        assertEquals(response.getCreatedAt(), LocalDate.now().toString());
    }

    @Test
    public void registerUrlWithCustomUrl(){

        when(urlService.registerUrl(new String(), new String())).thenReturn(null);

        UrlDto response = urlService.registerUrl("" ,"");

        assertNull(response);
    }

}

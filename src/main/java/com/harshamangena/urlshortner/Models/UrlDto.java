package com.harshamangena.urlshortner.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "URLSTORE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlDto {
    
    @Id
    @Column(name = "short_url", nullable = false, unique = true)
    private String shortUrl;

    @Column(name = "long_url", nullable = false)
    private String longUrl;
    
    @Column(name = "created_at")
    private String createdAt; 
}

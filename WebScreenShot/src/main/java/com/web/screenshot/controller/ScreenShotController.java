package com.web.screenshot.controller;

import java.io.IOException;


import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.screenshot.service.WebSiteCrawler;

@RestController
public class ScreenShotController {

	
	@Autowired
    WebSiteCrawler websiteCrawl;
	
	
	@RequestMapping(value="/screenshots" ,produces = MediaType.IMAGE_PNG_VALUE)
	
	public @ResponseBody byte[]index( @RequestParam("url") String url  )  throws IOException {
		
		 
		  byte[]  outimage =websiteCrawl.crawl(url);
	    

	      return outimage;
	  

	}
}

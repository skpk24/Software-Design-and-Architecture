package com.ilinks.practice.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilinks.practice.exceptionHandler.ConversionException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.springframework.core.io.ClassPathResource;

@RestController
@RequestMapping("/api/v1")
public class Problem1 {
	
	
	@GetMapping(value ="xmlToJson")
	public String convertXmlToJson() throws ConversionException {
    //Keep the xml file in the resource folder 
		ClassPathResource xmlResource = new ClassPathResource("abc.xml");
		
		String xmlString = null;
		try {
			xmlString = new String(Files.readAllBytes(Paths.get(xmlResource.getURL().toURI())));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		
		JSONObject xmlJSONObj = null;
		if(xmlString != null) {
			try {
				xmlJSONObj = XML.toJSONObject(xmlString);
			} catch (JSONException e) {
				throw new ConversionException("Format not supported ");
			}
		}
		return xmlJSONObj.toString();
	}
}

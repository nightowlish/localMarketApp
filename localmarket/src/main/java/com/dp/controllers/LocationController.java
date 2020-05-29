package com.dp.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dp.entities.LocationResponse;
import com.dp.repositories.RawDBGeoIPLocationService;

@RestController
public class LocationController {

	//@Autowired
	private RawDBGeoIPLocationService locationService;
    
    public LocationController() throws IOException {
        locationService = new RawDBGeoIPLocationService();
    }
     
    @PostMapping("/GeoIPTest")
    public LocationResponse getLocation(
      @RequestParam(value="ipAddress", required=true) String ipAddress
    ) throws Exception {
       
        RawDBGeoIPLocationService locationService 
          = new RawDBGeoIPLocationService();
        return locationService.getLocation(ipAddress);
    }
}

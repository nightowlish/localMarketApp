package com.dp.repositories;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.dp.entities.LocationResponse;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class RawDBGeoIPLocationService {
	private DatabaseReader dbReader;
    
    public RawDBGeoIPLocationService() throws IOException {
        File database = new File("/home/theo/GeoLite2-City_20200421/GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }
     
    public LocationResponse getLocation(String ip) 
      throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);
         
        String cityName = response.getCity().getName();
        String latitude = 
          response.getLocation().getLatitude().toString();
        String longitude = 
          response.getLocation().getLongitude().toString();
        return new LocationResponse(ip, cityName, latitude, longitude);
    }
}

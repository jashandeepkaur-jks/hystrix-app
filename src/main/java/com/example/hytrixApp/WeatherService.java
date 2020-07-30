package com.example.hytrixApp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

@Autowired
    RestTemplate restTemplate;

@HystrixCommand(fallbackMethod = "unknown")
public String getWeather()
{
    return restTemplate.getForEntity("http://service/weather",String.class).getBody();
}


public String unknown()
{
    return "UNKNOWN";
}
}

package com.backend.apod.controller;
import com.backend.apod.model.ApodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class controller {

    private final RestTemplate restTemplate;

    public controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private String apikey;

    @GetMapping("apod")
    public ApodResponse getApod(@RequestParam String date) {
        String url = "https://api.nasa.gov/planetary/apod?api_key="+apikey+"&date="+date;
        ApodResponse response = restTemplate.getForObject(url, ApodResponse.class);
        assert response != null;
        System.out.println("SUCCESS! this is the title of the Apod Nasa: "+ response.getTitle());
        return response;
    }
}


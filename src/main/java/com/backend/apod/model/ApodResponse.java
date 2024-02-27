package com.backend.apod.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ApodResponse {

    private String url;
    private String title;
    private String explanation;

}

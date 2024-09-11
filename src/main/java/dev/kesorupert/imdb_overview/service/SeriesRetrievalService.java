package dev.kesorupert.imdb_overview.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class SeriesRetrievalService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Hello anonymous user";
        } else {
            return "Hello " + name;
        }
    }

}

package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.Model.Animal;

import java.io.File;
import java.util.List;

public class AnimalService {
    private ObjectMapper mapper;
    private MenuService menuService;
    private File shelter = new File("shelter.json");
    private List<Animal> animals;


    public AnimalService(MenuService menuService) {
        this.mapper = new JsonMapper();
        this.menuService = menuService;
    }
}

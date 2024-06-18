package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.example.Executor;
import org.example.Model.Pet;
import org.example.Texts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PetService {
    private ObjectMapper mapper;
    private MenuService menuService;
    private File shelter = new File("shelter.json");
    private List<Pet> pets = new ArrayList<>();


    public PetService(MenuService menuService) {
        this.mapper = new JsonMapper();
        this.menuService = menuService;
        CollectionType pets = mapper.getTypeFactory().constructCollectionType(List.class, Pet.class);
        try {
            if (!shelter.exists())
                shelter.createNewFile();

            this.pets = mapper.readValue(shelter, pets);
            } catch (IOException e) {
                System.err.println(Texts.NO_PETS_DATA.getText());
                e.printStackTrace();
                exit();
        }
    }

    public Executor addPet() {
        return () -> pets.add(menuService.addPet());
    }

    public Executor showAllPets() {
        return () -> this.pets.forEach(System.out::println);
    }

    public Executor takePet() {
        return () -> {
            String name = menuService.takePet();
            pets.removeIf(pet -> pet.getName().equals(name));
        };
    }

    public Executor saveData() {
        return () -> {
            try {
                mapper.writeValue(shelter, pets);
            } catch (IOException e) {
                System.err.println(Texts.CANT_SAVE_DATA.getText());
                e.printStackTrace();
            }
        };
    }

    public Executor exit() {
        return saveData();
    }
}

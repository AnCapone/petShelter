package org.example;

import org.example.service.MenuService;
import org.example.service.PetService;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        MenuService menuService = new MenuService(scanner);
        Map<String, Executor> orchestrator = init(menuService);

    }

    private static Map<String, Executor> init(MenuService menuService) {
        PetService petService = new PetService(menuService);
        return Map.of(
                "1", petService.addPet(),
                "2", petService.showAllPets(),
                "3", petService.takePet(),
                "4", petService.saveData()
        );
    }
}
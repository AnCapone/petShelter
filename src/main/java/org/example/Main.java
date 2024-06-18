package org.example;

import org.example.service.MenuService;
import org.example.service.PetService;

import java.lang.constant.Constable;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        MenuService menuService = new MenuService(scanner);
        Map<Constable, Executor> orchestrator = init(menuService);
        menuService.showMenu();
        Comands command;
        do {
            command = Comands.valueOf(scanner.next().toUpperCase());
            orchestrator.getOrDefault(command, () -> System.out.println(Texts.WRONG_COMMAND.getText())).execute();
            menuService.taskSuccesfull();
        } while (!Texts.MENU_EXIT.getText().equals(command));

    }

    private static Map<Constable, Executor> init(MenuService menuService) {
        PetService petService = new PetService(menuService);
        return Map.of(
                Comands.ADD, petService.addPet(),
                Comands.SHOW, petService.showAllPets(),
                Comands.TAKE, petService.takePet(),
                Comands.EXIT, petService.saveData()
        );
    }
}
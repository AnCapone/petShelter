package org.example.service;

import org.example.Model.Pet;
import org.example.Texts;

import java.util.List;
import java.util.Scanner;

public class MenuService {

    private final Scanner scanner;
    private final List<String> commands = List.of(
            Texts.MENU_ADD.getText(),
            Texts.MENU_SHOW_ALL.getText(),
            Texts.MENU_TAKE.getText(),
            Texts.MENU_EXIT.getText()
    );

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMenu() {
        System.out.println(Texts.WELCOME.getText());
        commands.forEach(System.out::println);
    }

    public Pet addPet() {
        Pet.PetBuilder builder = Pet.builder();
        System.out.println(Texts.PET_NAME.getText());
        builder.name(scanner.next());
        System.out.println(Texts.PET_AGE.getText());
        builder.age(scanner.nextInt());
        System.out.println(Texts.PET_TYPE.getText());
        builder.type(scanner.next());
        System.out.println(Texts.PET_BREED.getText());
        builder.breed(scanner.next());
        return builder.build();
    }

    public String takePet() {
        System.out.println(Texts.PET_NAME.getText());
        return scanner.next();
    }

    public void taskSuccesfull() {
        System.out.println(Texts.SUCCESFULL.getText());
    }
}


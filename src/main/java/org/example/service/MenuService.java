package org.example.service;

import org.example.Model.Animal;
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

    public Animal addPet() {
        Animal.AnimalBuilder builder = Animal.builder();
        System.out.println(Texts.ANIMAL_NAME.getText());
        builder.name(scanner.next());
        System.out.println(Texts.ANIMAL_AGE.getText());
        builder.age(scanner.nextInt());
        System.out.println(Texts.ANIMAL_TYPE.getText());
        builder.type(scanner.next());
        System.out.println(Texts.ANIMAL_BREED.getText());
        builder.breed(scanner.next());
        return builder.build();
    }

    public String takePet() {
        System.out.println(Texts.ANIMAL_NAME.getText());
        return scanner.next();
    }

    public void taskSuccesfull() {
        System.out.println(Texts.SUCCESFULL.getText());
    }
}


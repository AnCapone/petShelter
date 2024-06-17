package org.example;

public enum Texts {
    MENU_ADD("Add a new pet"),
    MENU_SHOW_ALL("Show all pets"),
    MENU_TAKE("Take a pet from shelter"),
    MENU_EXIT("Exit"),
    WELCOME("Welcome to the pet shelter!"),
    SUCCESFULL("Operation was succesfull!"),
    ANIMAL_NAME("Enter the name of the animal:"),
    ANIMAL_AGE("Enter the age of the animal:"),
    ANIMAL_TYPE("Enter the type of the animal:"),
    ANIMAL_BREED("Enter the breed of the animal:");


    private final String text;

    Texts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

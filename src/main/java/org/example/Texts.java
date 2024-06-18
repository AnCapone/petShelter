package org.example;

public enum Texts {
    MENU_ADD("Add a new pet"),
    MENU_SHOW_ALL("Show all pets"),
    MENU_TAKE("Take a pet from shelter"),
    MENU_EXIT("Exit"),
    WELCOME("Welcome to the pet shelter!"),
    SUCCESFULL("Operation was succesfull!"),
    PET_NAME("Enter the name of the animal:"),
    PET_AGE("Enter the age of the animal:"),
    PET_TYPE("Enter the type of the animal:"),
    PET_BREED("Enter the breed of the animal:"),
    NO_PETS_DATA("Can't get pets data!"),
    CANT_SAVE_DATA("Can't save pets data!"),
    WRONG_COMMAND("Wrong command!");



    private final String text;

    Texts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

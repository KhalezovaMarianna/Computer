package com.solvd.computer.classes;

public class Keyboard {
    private String color;
    private String typeButtons;


    public Keyboard(String color) {
        this.color = color;
    }

    public String getTypeButtons() {
        return typeButtons;
    }

    public void setTypeButtons(String typeButtons) {
        this.typeButtons = typeButtons;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

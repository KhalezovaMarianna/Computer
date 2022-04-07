package com.solvd.computer;

import com.solvd.exceptions.NameException;
import com.solvd.exceptions.TextEmailException;

public class Email {
    private String text;
    private String name;
    private String email;

    private TypeOfEmail typeOfEmail;


    public Email(String email) {
        this.email = email;
    }

    public Email(String text, String email) {
        this.text = text;
        this.email = email;
    }

    public TypeOfEmail getTypeOfEmail() {
        return typeOfEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameException {
        if (name.equals(null)) {
            throw new NameException("name wasn't found");
        }
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws TextEmailException {
        if (text == null) {
            throw new TextEmailException("text can't be empty");
        }
        this.text = text;
    }


}

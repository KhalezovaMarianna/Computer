package com.solvd.computer;

public enum Users {
    LENA("Lena", "Volnianko", "19.04.1969");


    private String name;
    private String firstName;
    private String dateOfBirth;

    Users(String name, String firstName, String dateOfBirth) {
        this.name = name;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


}

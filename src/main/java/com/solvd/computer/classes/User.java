package com.solvd.computer.classes;

import com.solvd.computer.interfaces.IEnableIncognito;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class User {
    private static final Logger LOGGER = LogManager.getLogger(User.class);

    private String name;
    private String firstName;
    private String dateOfBirth;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(firstName, user.firstName) && Objects.equals(dateOfBirth, user.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, dateOfBirth);
    }

    IEnableIncognito s = () -> LOGGER.info("Incognito mode enable");

    public void enableIncognitoMode() {
        s.enableIncognitoMode();
    }
}

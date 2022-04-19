package com.solvd.enums;

public enum Computer {
    USER_DELL(Users.LENA),
    USER_ASUS(Users.NATASHA);

    private Users user;

    Computer(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }
}

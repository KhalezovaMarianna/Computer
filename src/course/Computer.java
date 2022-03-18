package course;

public abstract class Computer {
    private Email email;
    private Keyboard keyboard;

    public Computer(String user) {
    }

    public Computer(Email email) {
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public abstract void send(User sender, User receiver, Email email);


}

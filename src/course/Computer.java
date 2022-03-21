package course;

public abstract class Computer implements ILaunch, IShutDown {
    private String user;
    private Email email;
    private Keyboard keyboard;
    public Computer() {
    }
    public Computer(String user) {
        this.user = user;
    }

    public Computer(Email email) {
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

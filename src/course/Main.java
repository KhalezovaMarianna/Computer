package course;

public class Main {

    public static void main(String[] args) {
        User sasha = new User("Sasha");
        User pasha = new User("Pasha");
        Email email1 = new Email("text1", "test1@gmail.ru");
        Email email2 = new Email("text2", "test2@gmail.ru");
        MacBook user1 = new MacBook("user1");
        Asus user2 = new Asus("user2");
        Asus user3 = new Asus("user2");
        System.out.println(user2.toString());
        //System.out.println((user2.equals(user3)));
        System.out.println(user2==user3);
        user1.send(pasha, sasha, email1);
        user2.send(sasha, pasha, email2);


    }
}

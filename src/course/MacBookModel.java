package course;

public final class MacBookModel extends MacBook {
    static {
        System.out.print(
                " You switched to control MacBook air ");
    }

    public static final String MACBOOK = "MacBook Air";

    public static void checkModel() {
        System.out.println(MACBOOK);
    }
}
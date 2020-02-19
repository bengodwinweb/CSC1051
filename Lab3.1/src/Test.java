import java.util.Random;

public class Test {

    public static void main(String[] args) {
        String m1, m2, m3;

        m1 = "Quest for the Holy Grail";
        m2 = m1.toLowerCase();
        m3 = m1 + " " + m2;

        System.out.println(m3);
        System.out.println();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println("Random number " + (i + 1) + " = " + rand.nextInt(10));
        }
    }
}

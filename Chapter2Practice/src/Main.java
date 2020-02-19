public class Main {

    public static void main(String[] args) {
        int b, a = 3, c = 5;
        b = 12 + a-- / ++c - (--a);
        System.out.println(b);

        a = 4;
        b = 3;
        a = 4 * 3 - 2 + b-- / 2 * 3 % 2 * 4 - 2;
        System.out.println(a--);

        System.out.println("He thrusts his fists\n\tagainst"+
            " the post\nand still insists\n\the sees the \"ghost\"");

        System.out.println("All the world's a stage and " +
                "all the men and women meerly players");

        double fResult;
        int num3 = 17, num4 = 5;
        fResult = num3 / num4;
        System.out.println(fResult);
        int num1 = 25, num2 = 40;
        int iResult;
        double val1 = 17.0, val2 = 12.78;
        fResult = num1 / num2;
        System.out.println(fResult);
        iResult = (int) (val1 / num4);
        fResult = (int) (val1 / num4);
        System.out.println(iResult);
        System.out.println(fResult);
        fResult = (int) ((double) num1 / num2);
        System.out.println(fResult);

    }
}
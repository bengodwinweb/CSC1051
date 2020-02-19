public class TestString {

    public static void main(String[] args) {
        int size = 0;
        String word = "Hello";
        char letter;
        String word2 = "";
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println("Word is " + word);

        letter = word.charAt(1);
        System.out.println("letter is '" + letter + "'");

        size = word.length();
        System.out.println("Length = " + size);

        word2 = word.toLowerCase();
        System.out.println(ANSI_RED + "Word is " + word2);
        System.out.println("This is red" + ANSI_RESET);
        System.out.println("This is regular");

        String str = "Space, the final frontier.";
        System.out.println(str.substring(7));
        System.out.println(str.toUpperCase());
        System.out.println(str.length());

    }
}

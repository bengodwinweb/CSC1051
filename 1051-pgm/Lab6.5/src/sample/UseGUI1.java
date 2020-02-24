// Ben Godwin
// Lab 6.5 -- UseGUI1.java
// I assert that the program I am submitting is the result of my own efforts

// Part A questions
// 1. By importing them from the javafx package
// 2. primaryStage.setTitle("A JavaFX Program");
// 3. Scene scene = new Scene(root, 300, 120, Color.LIGHTGREEN);
// 4. class: Text, object: hello
// 5. the order they are added to the Group is the order they are drawn on the screen
// 6. Text

package sample;

// Import javafx classes used in the application
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UseGUI1 extends Application {

    public void start(Stage primaryStage) {
        // Create a line of text to show author's name
        Text name = new Text(50, 50, "Ben Godwin");
        name.setFill(Color.WHITE); // set fill color of name to white

        // Create a line of text to show author's section #
        Text section = new Text(50, 70, "CSC 1051-001");
        section.setFill(Color.WHITE); // set fill color of section to white

        // Create two lines of text with lab # and "Hello World"
        Text text = new Text(50, 90, "Lab 6.5\nHello World");
        text.setFill(Color.WHITE); // set fill color of two lines to white

        // Add name, section, and text to a group
        Group root = new Group(name, section, text);
        // Add the group to the scene, set display size and background color
        Scene scene = new Scene(root, 350, 150, Color.BLUE);

        // Set title of primary stage to "AUTHOR'S NAME - DEMO"
        primaryStage.setTitle("BEN GODWIN - DEMO");
        primaryStage.setScene(scene); // add the scene to the primary stage
        primaryStage.show(); // show the primary stage
    }

    // main method to call the start method
    public static void main(String[] args) {
        launch(args);
    }
}


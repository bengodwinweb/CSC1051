// Ben Godwin
// Lab6.5 - UseGUI2.java
// I assert that the program I am submitting is the result of my own efforts

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UseGUI2 extends Application {

    public void start(Stage primaryStage) {


        // define colors that will be used later in the program
        Color bluePine = Color.rgb(50, 72, 81);
        Color newGrass = Color.rgb(134,172,65);
        Color reflection = Color.rgb(52,103,92);
        Color mist = Color.rgb(125,163,161);
        Color softBrown = Color.rgb(125, 93, 59);

        // define a gradient that will be used as the background fill for the stage
        Stop[] stops = new Stop[] { new Stop(0, bluePine), new Stop(1, reflection)};
        LinearGradient gradient1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

        // create a text object with a chinese proverb
        Text line1 = new Text(0, 0, "The best time to plant a tree was 20 years ago."); // first line of text
        line1.setFill(Color.WHITE); // set first line to white text
        line1.setFont(Font.font("American Typewriter", 16)); // set first line font and font size
        
        Text line2 = new Text(83, 33, "The second best time is now."); // second line of text
        line2.setFill(Color.WHITE); // set second line to white text
        line2.setFont(Font.font("American Typewriter", 20)); // set second line to same font as first, slightly larger size
        
        Text line3 = new Text(235, 75, "- Chinese Proverb"); // third line of text
        line3.setFill(Color.WHITE); // set third line to white text
        line3.setFont(Font.font("American Typewriter", 14)); // set third line to smaller font
        
        Group quote = new Group(line1, line2, line3); // add lines of quote to a quote group
        quote.setTranslateX(72); // set starting x position of quote group
        quote.setTranslateY(100); // set starting y position of quote group

        // declare a green line of width 4
        Line line = new Line(62, 19, 450, 220);
        line.setStrokeWidth(4);
        line.setStroke(newGrass);

        // declere a blue rectangle
        Rectangle rect = new Rectangle(55, 66, 386, 140);
        rect.setFill(mist);

        // declare a dark blue-green circle 
        Circle circle = new Circle(162, 210, 49);
        circle.setFill(reflection);

        // declare a an empty ellipse with a brown outline of width 5
        Ellipse ellipse = new Ellipse(450, 200, 250, 150);
        ellipse.setStroke(softBrown);
        ellipse.setStrokeWidth(5);
        ellipse.setFill(null);

        // group the shapes together
        Group shapes = new Group(line, ellipse, rect, circle);

        // add the shapes and quote to the root group
        Group root = new Group(shapes, quote);
        Scene scene = new Scene(root, 492, 295, gradient1); // make scene, background is gradient
        primaryStage.setTitle("Ben Godwin - Lab6.5 Part B"); // set stage title
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

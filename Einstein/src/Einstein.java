//************************************************************************
//  Einstein.java       Author: Lewis/Loftus
//
//  Demonstrates the use of various shape classes.
//************************************************************************

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Einstein extends Application
{
    //--------------------------------------------------------------------
    //  Creates and displays several shapes.
    //--------------------------------------------------------------------
    public void start(Stage primaryStage)
    {
        Line line = new Line(35, 60, 150, 170);

        Circle circle = new Circle(250, 100, 50);
        circle.setFill(Color.YELLOW);
        
        Rectangle rect = new Rectangle(60, 70, 250, 60);
        rect.setStroke(Color.RED);
        rect.setStrokeWidth(2);
        rect.setFill(null);        
        
        Text quote = new Text(120, 100, "Out of clutter, find " +
                "simplicity.\n-- Albert Einstein");
                
        Ellipse ellipse = new Ellipse(200, 100, 150, 50);
        ellipse.setFill(Color.PALEGREEN);        
        
        Group root = new Group(rect, circle, line, quote, ellipse);
        Scene scene = new Scene(root, 400, 200);
        
        primaryStage.setTitle("Einstein");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}

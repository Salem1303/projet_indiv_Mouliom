/**
 * Created by Salem on 20/11/2015.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;




public class ConvertisseurDeDevises extends Application {

    public double Convert(double x, int a  )
    {
        //     EUR USD GBP CHF
        //EUR       t0  t1  t2
        //USD  t3       t4  t5
        //GBP  t5   t6      t7
        //CHF  t8   t8   t9


        double[] t = { 1.0621 , 0.7007 , 1.0835 ,0.9416 , 0.6597 , 1.0201 , 1.4270 , 1.5156 , 4.5461, 0.9232, 0.9805, 0.6468 };


        x = x*t[a];


        return x ;

    }




    public static void main(String[] args) {
        //launch(args);
        Application.launch(ConvertisseurDeDevises.class, args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root,600,350,Color.GRAY);
        //Scene s = new Scene(root, 300, 300, Color.BLACK);
        primaryStage.setScene(scene);


        Button btn = new Button();
        btn.setLayoutX(200);
        btn.setLayoutY(200);
        root.getChildren().add(btn);
        btn.setText("CONVERT");

        Label label1 = new Label("From");
        label1.setLayoutY(40);
        Label label2 = new Label("To");
        label2.setLayoutY(40);
        label2.setLayoutX(150);


        //RadioButtons
        RadioButton rb1 = new RadioButton("EUR");
        rb1.setLayoutY(60);
        rb1.setText("EUR");
        RadioButton rb2 = new RadioButton("USD");
        rb2.setLayoutY(80);
        RadioButton rb3 = new RadioButton("GBP");
        rb3.setLayoutY(100);
        RadioButton rb4 = new RadioButton("CHF");
        rb4.setLayoutY(120);

        final ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb4.setToggleGroup(group);

        RadioButton rb5 = new RadioButton("EUR");
        rb5.setLayoutY(60);
        rb5.setLayoutX(150);
        RadioButton rb6 = new RadioButton("USD");
        rb6.setLayoutY(80);
        rb6.setLayoutX(150);
        RadioButton rb7 = new RadioButton("GBP");
        rb7.setLayoutY(100);
        rb7.setLayoutX(150);
        RadioButton rb8 = new RadioButton("CHF");
        rb8.setLayoutY(120);
        rb8.setLayoutX(150);
        final ToggleGroup group2 = new ToggleGroup();
        rb5.setToggleGroup(group2);
        rb6.setToggleGroup(group2);
        rb7.setToggleGroup(group2);
        rb8.setToggleGroup(group2);


        //Text field.add
        TextField textField = new TextField ();
        textField.setLayoutX(150);

        TextField tf = new TextField ();
        tf.setLayoutX(150);
        tf.setLayoutY(250);

        root.getChildren().add(textField);
        root.getChildren().add(label1);
        root.getChildren().add(label2);
        root.getChildren().add(rb1);
        root.getChildren().add(rb2);
        root.getChildren().add(rb3);
        root.getChildren().add(rb4);
        root.getChildren().add(rb5);
        root.getChildren().add(rb6);
        root.getChildren().add(rb7);
        root.getChildren().add(rb8);
        root.getChildren().add(tf);

        //

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int a=1000;
                if  ( rb1.isSelected() && rb6.isSelected() )
                {
                     a = 0 ;
                }

                double x =Double.parseDouble(textField.getText());
                tf.setText(Double.toString(Convert(x,a)));

            }
            });

        primaryStage.show();
    }
}

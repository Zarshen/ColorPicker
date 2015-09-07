package cs3744.hw1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.awt.*;


public class HW1 extends Application {

    private static double RED_VAL = 0;
    private static double GREEN_VAL = 0;
    private static double BLUE_VAL = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        HW1Model model = new HW1Model();
        HW1View view = new HW1View();
        HW1Controller controller = new HW1Controller(view, model);

        model.setRedSliderValue(RED_VAL);
        model.setGreenSliderValue(GREEN_VAL);
        model.setBlueSliderValue(BLUE_VAL);

        Scene scene = new Scene(view, 400, 500);
        scene.getStylesheets().add(HW1.class.getResource("stylesheets/hw1.css").toExternalForm());


        primaryStage.setTitle("HW1: bpp226");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(HW1.class, (java.lang.String[])null);
    }

}
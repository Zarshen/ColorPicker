package cs3744.hw1;

import javafx.beans.property.DoubleProperty;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;


public class HW1View extends GridPane {

    private Label colorBox = null;

    private Label  redSliderLabel;
    private Slider redSlider     ;
    private Label  redSliderValue;

    private Label  greenSliderLabel;
    private Slider greenSlider;
    private Label  greenSliderValue;

    private Label  blueSliderLabel;
    private Slider blueSlider;
    private Label  blueSliderValue;

    public HW1View(){
        super();

        //Layout
        setPadding(new Insets(10));
        setVgap(10);
        setHgap(10);

        //Column Settings
        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(25);
        column0.setHalignment(HPos.CENTER);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        column1.setHalignment(HPos.CENTER);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        column2.setHalignment(HPos.CENTER);

        getColumnConstraints().addAll(column0, column1, column2);

        //Row Settings

        RowConstraints row0 = new RowConstraints();
        row0.setPercentHeight(70);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(10);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(10);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(10);
        getRowConstraints().addAll(row0, row1, row2, row3);


        //Component value initialization
        colorBox = createLabel("", "colorBox");
        colorBox.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);


        redSliderLabel = createLabel("Red");
        redSlider      = createSlider("redSlider");
        redSliderValue = createLabel("0.00", "redSliderValue");

        greenSliderLabel = createLabel("Green");
        greenSlider      = createSlider("greenSlider");
        greenSliderValue = createLabel("0.00", "greenSliderValue");

        blueSliderLabel = createLabel("Blue");
        blueSlider      = createSlider("blueSlider");
        blueSliderValue = createLabel("0.00", "blueSliderValue");

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            redSliderValue.setText(String.format("%.2f", newValue.doubleValue()));
        });
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            greenSliderValue.setText(String.format("%.2f", newValue.doubleValue()));
        });
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            blueSliderValue.setText(String.format("%.2f", newValue.doubleValue()));
        });

        //Row 0
        add(colorBox, 0, 0, 3, 1);

        //Row 1
        add(redSliderLabel, 0, 1);
        add(redSlider, 1, 1);
        add(redSliderValue, 2, 1);

        //Row 2
        add(greenSliderLabel, 0, 2);
        add(greenSlider, 1, 2);
        add(greenSliderValue, 2, 2);

        //Row 3
        add(blueSliderLabel, 0, 3);
        add(blueSlider, 1, 3);
        add(blueSliderValue, 2, 3);
    }

    //Initialization Helper Functions
    Label createLabel(String name){
        Label label = new Label(name);
        label.setAlignment(Pos.CENTER);
        label.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return label;
    }
    Label createLabel(String name, String id){
        Label label = createLabel(name);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setId(id);
        return label;
    }
    Slider createSlider(String id){
        Slider slider = new Slider();
        slider.setId(id);
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(0);
        return slider;
    }

    //Access Functions

    public double getRedSlider(){return redProperty().get();}
    public void setRedSlider(double newValue){redProperty().set(newValue);}
    public DoubleProperty redProperty() { return redSlider.valueProperty();}

    public double getGreenSlider(){return greenProperty().get();}
    public void setGreenSlider(double newValue){greenProperty().set(newValue);}
    public DoubleProperty greenProperty() { return greenSlider.valueProperty();}

    public double getBlueSlider(){return blueProperty().get();}
    public void setBlueSlider(double newValue){blueProperty().set(newValue);}
    public DoubleProperty blueProperty() { return blueSlider.valueProperty();}



    public void setColor(Color c){
        String RGB = percentToRGB(c.getRed(), c.getGreen(), c.getBlue());
        String newBackgroundColor =  "-fx-background-color: rgb(" + RGB + ");";
        lookup("#colorBox").setStyle(newBackgroundColor);
    }
    public String percentToRGB(double red, double green, double blue){
        return Double.toString(red  *255)  + "," +
               Double.toString(green*255)  + "," +
               Double.toString(blue *255);

    }

}
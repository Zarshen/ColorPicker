package cs3744.hw1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class HW1Model {

    private DoubleProperty redSliderVal;
    private DoubleProperty greenSliderVal;
    private DoubleProperty blueSliderVal;
    private ObjectProperty<Color> color;

    public HW1Model() {
        redSliderVal    = new SimpleDoubleProperty(0);
        greenSliderVal  = new SimpleDoubleProperty(0);
        blueSliderVal   = new SimpleDoubleProperty(0);
        color           = new SimpleObjectProperty<Color>(Color.BLACK);

        redSliderVal.addListener(((observable, oldValue, newValue) -> {
            color.set(makeColor(newValue.doubleValue()/100, color.get().getGreen(), color.get().getBlue()));
        }));
        greenSliderVal.addListener(((observable, oldValue, newValue) -> {
            color.set(makeColor(color.get().getRed(), newValue.doubleValue()/100, color.get().getBlue()));
        }));
        blueSliderVal.addListener(((observable, oldValue, newValue) -> {
            color.set(makeColor(color.get().getRed(), color.get().getGreen(), newValue.doubleValue()/100));
        }));

    }

    public final double getRedSliderValue(){return redSliderVal.get();}
    public final void setRedSliderValue(double value){redSliderVal.set(value);}
    public DoubleProperty redSliderValueProperty() {return redSliderVal;}


    public final double getGreenSliderValue(){return greenSliderVal.get();}
    public final void setGreenSliderValue(double value){greenSliderVal.set(value);}
    public DoubleProperty greenSliderValueProperty() {return greenSliderVal;}

    public final double getBlueSliderValue(){return blueSliderVal.get();}
    public final void setBlueSliderValue(double value){blueSliderVal.set(value);}
    public DoubleProperty blueSliderValueProperty() {return blueSliderVal;}

    public final Color getColor(){return color.get();}
    public final void setColor(Color color){this.color.set(color);}
    public ObjectProperty<Color> colorObjectProperty(){return color;}

    private Color makeColor(double r, double g, double b){
        return Color.color(r,g,b);
    }
}

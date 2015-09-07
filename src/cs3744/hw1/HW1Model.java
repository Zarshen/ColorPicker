/*Data objects
        color object or 3 doubles
    // Properties
        Simple Double Properties**
        Simple Object Properties
    // Initial Values of Properties
        0
    // Allowed Values of Properties
        0-1
    //How are properties put together in a single data container
        Public class HW1Model{
            as i have it
        }
    //How can controller update properties and listen to properies changes?
        get/set value methods
    */


package cs3744.hw1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class HW1Model {

    private DoubleProperty redSliderVal = null;
    private DoubleProperty greenSliderVal  = null;
    private DoubleProperty blueSliderVal  = null;
    private ObjectProperty<Color> color = null;

    public HW1Model() {
        redSliderVal    = new SimpleDoubleProperty();
        greenSliderVal  = new SimpleDoubleProperty();
        blueSliderVal   = new SimpleDoubleProperty();
        color           = new SimpleObjectProperty<Color>();

        redSliderVal.addListener(((observable, oldValue, newValue) -> {
            color.set(makeColor(newValue.doubleValue(), greenSliderVal.get(), blueSliderVal.get()));
        }));
        greenSliderVal.addListener(((observable, oldValue, newValue) -> {
            color.set(makeColor(redSliderVal.get(), newValue.doubleValue(), blueSliderVal.get()));
        }));
        blueSliderVal.addListener(((observable, oldValue, newValue) -> {
            color.set(makeColor(redSliderVal.get(), greenSliderVal.get(), newValue.doubleValue()));
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

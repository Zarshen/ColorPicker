package cs3744.hw1;

public class HW1Controller {

    public HW1Controller(HW1View view, HW1Model model) {

        model.colorObjectProperty().addListener((observable, oldValue, newValue) ->{
            view.setColor(newValue);
        });
        view.redProperty().addListener((observable, oldValue, newValue)->{
            model.setRedSliderValue(newValue.doubleValue());
        });
        view.greenProperty().addListener((observable, oldValue, newValue)->{
            model.setGreenSliderValue(newValue.doubleValue());
        });
        view.blueProperty().addListener((observable, oldValue, newValue)->{
            model.setBlueSliderValue(newValue.doubleValue());
        });

    }

}

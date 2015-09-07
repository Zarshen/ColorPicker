package cs3744.hw1;

import javafx.scene.control.Slider;

/*Takes in instances of both the model and view and sets itself as a listener in both others*/


public class HW1Controller {

    private HW1Model model;
    private HW1View view;


    public HW1Controller(HW1View view, HW1Model model) {
        this.model = model;
        this.view = view;

        Slider redSlider = (Slider) view.getLayout().lookup("#redSlider");
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            view.setRedSliderLabel(newValue.doubleValue());
            model.setRedSliderValue(newValue.doubleValue());
            view.changeLabelBackground();
        });

        Slider greenSlider = (Slider) view.getLayout().lookup("#greenSlider");
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            view.setGreenSliderLabel(newValue.doubleValue());
            model.setGreenSliderValue(newValue.doubleValue());
            view.changeLabelBackground();
        });

        Slider blueSlider = (Slider) view.getLayout().lookup("#blueSlider");
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            view.setBlueSliderLabel(newValue.doubleValue());
            model.setBlueSliderValue(newValue.doubleValue());
            view.changeLabelBackground();
        });
    }

}

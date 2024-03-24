package com.example.colorchooser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class ColorChooserController {
    // instance variables for interacting with GUI components
    public static final NumberFormat number = NumberFormat.getIntegerInstance();
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // instance variables for managing
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize() {
        // bind TextField values to corresponding Slider values
        redTextField.textProperty().bindBidirectional((redSlider.valueProperty()), NumberFormat.getNumberInstance());
        greenTextField.textProperty().bindBidirectional((greenSlider.valueProperty()), NumberFormat.getNumberInstance());
        blueTextField.textProperty().bindBidirectional((blueSlider.valueProperty()), NumberFormat.getNumberInstance());
        alphaTextField.textProperty().bindBidirectional((alphaSlider.valueProperty()), NumberFormat.getNumberInstance());

        redTextField.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        try{
                            red = ((Number) Integer.parseInt(newValue)).intValue();
                            redTextField.setText(number.format(red));
                            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                        }
                        catch (NumberFormatException e){
                            red = 0;
                        }
                    }
                }
        );

        // listeners that set Rectangle's fill based on Slider changes
        redSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        red = newValue.intValue();
                        redTextField.setText(number.format(red));
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );
        greenSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        green = newValue.intValue();
                        greenTextField.setText(number.format(green));
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );
        greenTextField.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        try{
                            green = ((Number) Integer.parseInt(newValue)).intValue();

                            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                        }
                        catch (NumberFormatException e){
                            green = 0;
                        }
                    }
                }
        );
        blueSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        blue = newValue.intValue();
                        blueTextField.setText(number.format(blue));
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );
        blueTextField.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        try{
                            blue = ((Number) Integer.parseInt(newValue)).intValue();

                            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                        }
                        catch (NumberFormatException e){
                            blue = 0;
                        }
                    }
                }
        );
        alphaSlider.valueProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number oldValue, Number newValue) {
                        alpha = newValue.doubleValue();
                        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                    }
                }
        );
        alphaTextField.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
                        try{
                            alpha = ((Number) Integer.parseInt(newValue)).intValue();

                            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
                        }
                        catch (NumberFormatException e){
                            alpha = 0;
                        }
                    }
                }
        );
    }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
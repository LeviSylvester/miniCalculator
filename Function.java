package miniCalculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.text.DecimalFormat;

import static miniCalculator.UI.*;

class Function {

    private static void setEventOnMouseClickedNumericOrOperatorButton(String button) {
        buttons.get(button).setOnMouseClicked(event -> {
            calculatorTextField.appendText(button);
            System.out.print(button);
        });
    }

    private static void setMouseClickedClearButtonEvent() {
        buttons.get("C").setOnMouseClicked(event -> {
            calculatorTextField.clear();
            System.out.println();
        });
    }

    private static void setMouseClickedBackspaceButtonEvent() {
        buttons.get("Del").setOnMouseClicked(event -> {
            int length = calculatorTextField.getText().length();
            if (length > 0) {
                calculatorTextField.deleteText(length - 1, length);
            }
        });
    }

    private static void mathOperationBetweenTwoNumbers() {
        String initialText = calculatorTextField.getText();
        String[] operandStrings = initialText.split("[\\/\\*\\-\\+]");

        try {

            double[] operands = {Double.parseDouble(operandStrings[0]), Double.parseDouble(operandStrings[1])};
            double calculated = 0;

            if (initialText.contains("/")) {
                calculated = operands[0] / operands[1];
            } else if (initialText.contains("*")) {
                calculated = operands[0] * operands[1];
            } else if (initialText.contains("-")) {
                calculated = operands[0] - operands[1];
            } else if (initialText.contains("+")) {
                calculated = operands[0] + operands[1];
            }

            DecimalFormat decimalFormat4 = new DecimalFormat("#.####");
            String result = String.valueOf(decimalFormat4.format(calculated));
            if (result.contains(".0")) {
                result = result.substring(0, result.length() - 2);
            }

            calculatorTextField.setText(result);
            calculatorTextField.positionCaret(calculatorTextField.getText().length());

            System.out.println("\n" + calculatorTextField.getText());

        } catch (Exception e) {
            calculatorTextField.appendText("☻format!");
            System.out.println("\nWrong number format!");
        }
    }

    static void setCalculatorTextFieldEvent() {
        calculatorTextField.setOnKeyPressed(event -> {
            System.out.print(event.getText());
        });
    }

    static void setEventsOnMouseClickedButtons() {
        setMouseClickedBackspaceButtonEvent();
        setMouseClickedClearButtonEvent();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            setEventOnMouseClickedNumericOrOperatorButton(String.valueOf(j));
        }
        setEventOnMouseClickedNumericOrOperatorButton(".");
        setEventOnMouseClickedNumericOrOperatorButton("/");
        setEventOnMouseClickedNumericOrOperatorButton("*");
        setEventOnMouseClickedNumericOrOperatorButton("-");
        setEventOnMouseClickedNumericOrOperatorButton("+");
    }

    static void setEqualsButtonEventOnAction() {
        EventHandler<ActionEvent> equalsEvent = event -> {
            Function.mathOperationBetweenTwoNumbers();
        };
        buttons.get("=").setOnAction(equalsEvent);
    }

    static void fireEqualsButtonWhenEnterKeyIsPressedOnScene(Scene calculatorScene) {
        calculatorScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                buttons.get("=").fire();
            }
        });
    }

}

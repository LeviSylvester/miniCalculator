package miniCalculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

class UI {

    static Map<String, Button> buttons = new HashMap<>();
    static TextField calculatorTextField = new TextField();

    static void setStage(Stage calculatorStage) {
        calculatorStage.setTitle("MiniCalculator");
        calculatorStage.setHeight(230);
        calculatorStage.setWidth(176);
        calculatorStage.setX(150);
        calculatorStage.setY(300);
    }

    static Text setWelcomeText() {
        Text welcomeText = new Text("Thanks for using MiniCalculator1.1");
        welcomeText.setFont(Font.font("Veranda", 10));
        welcomeText.setFill(Paint.valueOf("#2455d1"));
        return welcomeText;
    }

    static HBox setDisplayHBox(TextField calculatorTextField) {
        HBox displayHBox = new HBox();
        displayHBox.getChildren().add(calculatorTextField);
        displayHBox.setAlignment(Pos.TOP_LEFT);
        return displayHBox;
    }

    static void makeButtons() {
        for (int i = 0; i < 10; i++) {
            Button button = new Button(String.format("  %s  ", i));
            buttons.put(String.valueOf(i), button);
        }
        Button buttonClear = new Button("  C  ");
        Button buttonBackspace = new Button(" Del");
        Button buttonDot = new Button("   .  ");
        Button buttonDivide = new Button("  ÷ ");
        Button buttonMultiply = new Button("  x  ");
        Button buttonSubtract = new Button("  -  ");
        Button buttonAdd = new Button("  + ");
        Button buttonEquals = new Button("  = ");
        buttons.put("C", buttonClear);
        buttons.put("Del", buttonBackspace);
        buttons.put(".", buttonDot);
        buttons.put("/", buttonDivide);
        buttons.put("*", buttonMultiply);
        buttons.put("-", buttonSubtract);
        buttons.put("+", buttonAdd);
        buttons.put("=", buttonEquals);
    }

    static GridPane setButtonsGrid(Map<String, Button> buttons) {
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.add(buttons.get("7"), 0, 1);
        buttonsGrid.add(buttons.get("4"), 0, 2);
        buttonsGrid.add(buttons.get("1"), 0, 3);
        buttonsGrid.add(buttons.get("C"), 1, 0);
        buttonsGrid.add(buttons.get("8"), 1, 1);
        buttonsGrid.add(buttons.get("5"), 1, 2);
        buttonsGrid.add(buttons.get("2"), 1, 3);
        buttonsGrid.add(buttons.get("0"), 1, 4);
        buttonsGrid.add(buttons.get("Del"), 2, 0);
        buttonsGrid.add(buttons.get("9"), 2, 1);
        buttonsGrid.add(buttons.get("6"), 2, 2);
        buttonsGrid.add(buttons.get("3"), 2, 3);
        buttonsGrid.add(buttons.get("."), 2, 4);
        buttonsGrid.add(buttons.get("/"), 3, 0);
        buttonsGrid.add(buttons.get("*"), 3, 1);
        buttonsGrid.add(buttons.get("-"), 3, 2);
        buttonsGrid.add(buttons.get("+"), 3, 3);
        buttonsGrid.add(buttons.get("="), 3, 4);
        buttonsGrid.setHgap(2);
        buttonsGrid.setVgap(2);
        return buttonsGrid;
    }

    static VBox setVBoxElements(Text welcomeText, HBox displayHBox, GridPane buttonsGrid) {
        VBox elementsVBox = new VBox();
        elementsVBox.setAlignment(Pos.TOP_LEFT);
        elementsVBox.setSpacing(5);
        elementsVBox.setPadding(new Insets(5, 0, 0, 5));
        elementsVBox.getChildren().addAll(welcomeText, displayHBox, buttonsGrid);
        return elementsVBox;
    }

}

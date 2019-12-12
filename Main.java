package miniCalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Starting MiniCalculator...");
    }

    @Override
    public void start(Stage calculatorStage) throws Exception {
        UI.setStage(calculatorStage);

        Text welcomeText = UI.setWelcomeText();

        HBox displayHBox = UI.setDisplayHBox(UI.calculatorTextField);

        UI.makeButtons();
        GridPane buttonsGrid = UI.setButtonsGrid(UI.buttons);

        VBox elementsVBox = UI.setVBoxElements(welcomeText, displayHBox, buttonsGrid);

        Function.setCalculatorTextFieldEvent();
        Function.setEventsOnMouseClickedButtons();
        Function.setEqualsButtonEventOnAction();

        Scene calculatorScene = new Scene(elementsVBox);

        Function.fireEqualsButtonWhenEnterKeyIsPressedOnScene(calculatorScene);

        calculatorStage.setScene(calculatorScene);
        calculatorStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping MiniCalculator.");
    }

}
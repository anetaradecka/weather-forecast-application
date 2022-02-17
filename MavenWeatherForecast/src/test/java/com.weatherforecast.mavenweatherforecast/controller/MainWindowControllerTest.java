package com.weatherforecast.mavenweatherforecast.controller;

import com.weatherforecast.mavenweatherforecast.view.ViewFactory;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit5.ApplicationTest;

//import javax.swing.text.ViewFactory;

@Disabled
@ExtendWith(MockitoExtension.class)
public class MainWindowControllerTest extends ApplicationTest {
    // To jest zalecany gotowiec, ale trzeba sie lepiej znac na JUnit
    // https://stackoverflow.com/questions/28245555/how-do-you-mock-a-javafx-toolkit-initialization/28416730

    private TextField fakeTextFieldWithText;
    private TextField fakeTextFieldWithoutText;

    /**
     * Will be called with {@code @Before} semantics, i.e. before each test method.
     */
    @Override
    public void start(Stage stage) {
//        fakeTextFieldWithText = new TextField("Boston");
//        fakeTextFieldWithoutText = new TextField("");
        stage.setScene(new Scene(new StackPane(), 100, 100));
        stage.show();
    }

    @Test
    public void shouldValidatePrimaryTextField() {
        //given
        ViewFactory fakeViewFactory = new ViewFactory();
        String fakeFxmlName = "";
        MainWindowController mainWindowController = new MainWindowController(fakeViewFactory, fakeFxmlName);
//        TextField fakePrimaryTextField = new TextField("Boston");
        mainWindowController.setPrimaryTextField(fakeTextFieldWithText);

        //when
        boolean primaryFieldIsValid = mainWindowController.isPrimaryFieldValid();

        //then
        Assertions.assertEquals(fakeTextFieldWithText.getText(), "Boston");
    }

}

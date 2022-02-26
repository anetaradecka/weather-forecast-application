package com.weatherforecast.mavenweatherforecast.controller;

import com.weatherforecast.mavenweatherforecast.Launcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.util.WaitForAsyncUtils;


@ExtendWith(ApplicationExtension.class)
public class MainWindowControllerTest  {

    @BeforeEach
    public void runAppToTests(FxRobot fxRobot) throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Launcher::new);
        FxToolkit.showStage();
        WaitForAsyncUtils.waitForFxEvents();
    }

    @Test
    public void shouldValidatePrimaryTextField(FxRobot fxRobot) {
        //given

        // when

        // then
        FxAssert.verifyThat("#primaryTextField", LabeledMatchers.hasText("Hello!"));
    }

}

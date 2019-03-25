package com.test.project.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "ru-RU");
        options.setExperimentalOption("prefs", prefs);
        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
    }
}

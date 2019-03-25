package com.test.project.pages;

import com.test.project.data.FormDataModel;
import com.test.project.data.FormTestModel;
import com.test.project.data.Mood;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPage {
    private Logger logger = LoggerFactory.getLogger(FormPage.class);

    private static final String URL = "https://docs.google.com/forms/d/e/1FAIpQLSdqT5F9_qhPDmJ4lfIH7buVkUvjf4LS9ODdqD7PYfVbfFTnpA/viewform";

    private static final By FORM_HEADER = By.className("freebirdFormviewerViewHeaderTitle");

    private static final By EMAIL_CONTAINER = By.xpath("//*[contains(text(), \"Адрес электронной почты\")]/ancestor::div[@role=\"listitem\"]");
    private static final By NAME_CONTAINER = By.xpath("//*[contains(text(), \"Имя\")]/ancestor::div[@role=\"listitem\"]");
    private static final By SEX_CONTAINER = By.xpath("//*[contains(text(), \"Пол\")]/ancestor::div[@role=\"listitem\"]");
    private static final By MOOD_CONTAINER = By.xpath("//*[contains(text(), \"Как ваше настроение\")]/ancestor::div[@role=\"listitem\"]");

    private static final By ERROR_MESSAGE_CONTAINER = By.className("freebirdFormviewerViewItemsItemErrorMessage");

    private static final By RESPONSE_CONFIRMATION = By.className("freebirdFormviewerViewResponseConfirmationMessage");

    private static final By SUBMIT_BUTTON = By.className("quantumWizButtonPaperbuttonContent");

    public void openPage() {
        open(URL);
        $(FORM_HEADER).shouldBe(visible);
    }

    public void fillForm(FormDataModel data) {
        logger.info("Try to set email to " + data.getEmail());
        findAndFillInput(EMAIL_CONTAINER, data.getEmail());
        logger.info("Try to set name to " + data.getName());
        findAndFillInput(NAME_CONTAINER, data.getName());

        fillSex(data.getSex());
        fillMood(data.getMood());

    }

    private void fillSex(String sex) {
        logger.info("Try to set gender to " + sex);
        if (sex == null) return;
        $(SEX_CONTAINER).find("[role=\"listbox\"]").shouldBe(visible).click();
        $(SEX_CONTAINER).findAll("content").find(text(sex)).click();
    }

    private void fillMood(Mood mood) {
        if (mood == null) return;
        logger.info("Try to fill mood with " + mood.getValue());
        $(MOOD_CONTAINER).findAll(".exportLabelWrapper")
                .shouldHave(sizeGreaterThan(0))
                .find(text(mood.getValue()))
                .shouldBe(visible)
                .click();

        if (mood == Mood.OTHER)
            findAndFillInput(MOOD_CONTAINER, mood.getInput());
    }

    private void findAndFillInput(By containerSelector, String value) {
        if (value == null) return;
        $(containerSelector).find("input").shouldBe(visible).setValue(value);
    }

    public void submitForm() {
        $(SUBMIT_BUTTON).click();
        System.out.println();
    }

    public void assertResult(FormTestModel testModel) {
        if (!testModel.requireValidation()) responseConfirmed();

        if (testModel.isEmailValidationRequires())
            validateContainerAndError(EMAIL_CONTAINER, testModel.getEmailValidationMessage());

        if (testModel.isNameValidationRequires())
            validateContainerAndError(NAME_CONTAINER, testModel.getNameValidationMessage());

        if (testModel.isSexValidationRequires())
            validateContainerAndError(SEX_CONTAINER, testModel.getSexValidationMessage());

        if (testModel.isMoodValidationRequires())
            validateContainerAndError(MOOD_CONTAINER, testModel.getMoodValidationMessage());
    }

    private void responseConfirmed() {
        $(RESPONSE_CONFIRMATION).shouldBe(visible);
    }

    private void validateContainerAndError(By containerSelector, String validationMessage) {
        logger.info("Checking name validation message to be equal to " + validationMessage);
        $(containerSelector)
                .shouldHave(cssClass("HasError"))
                .find(ERROR_MESSAGE_CONTAINER)
                .shouldBe(visible)
                .shouldHave(text(validationMessage));
    }
}

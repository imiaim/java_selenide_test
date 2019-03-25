package com.test.project.builder;

import com.test.project.data.FormDataModel;
import com.test.project.data.FormTestModel;
import com.test.project.data.Sex;
import com.test.project.data.ValidationMessages;

import static com.test.project.data.Mood.SUPER;

public class InvalidEmailDataBuilder {
    public static FormTestModel build() {
        FormDataModel formDataModel = new FormDataModel();
        formDataModel.setEmail("lorem");
        formDataModel.setName("Lorem Ipsum");
        formDataModel.setSex(new Sex("Мужской"));
        formDataModel.setMood(SUPER);

        FormTestModel formTestModel = new FormTestModel(formDataModel);
        formTestModel.setEmailValidationRequires(true);
        formTestModel.setEmailValidationMessage(ValidationMessages.INVALID_EMAIL);
        return formTestModel;
    }
}

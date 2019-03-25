package com.test.project.builder;

import com.test.project.data.FormDataModel;
import com.test.project.data.FormTestModel;
import com.test.project.data.Sex;

import static com.test.project.data.Mood.SUPER;

public class InvalidNameDataBuilder {
    public static FormTestModel build() {
        FormDataModel formDataModel = new FormDataModel();
        formDataModel.setName("123%^)(");
        formDataModel.setEmail("lorem@ipsum.com");
        formDataModel.setSex(new Sex("Мужской"));
        formDataModel.setMood(SUPER);

        FormTestModel formTestModel = new FormTestModel(formDataModel);
        formTestModel.setNameValidationRequires(true);
        formTestModel.setNameValidationMessage("");
        return formTestModel;
    }
}

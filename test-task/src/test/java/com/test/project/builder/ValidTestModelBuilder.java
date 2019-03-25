package com.test.project.builder;

import com.test.project.data.FormDataModel;
import com.test.project.data.FormTestModel;
import com.test.project.data.Sex;

import static com.test.project.data.Mood.SUPER;

public class ValidTestModelBuilder {
    public static FormTestModel build() {
        FormDataModel formDataModel = new FormDataModel();
        formDataModel.setEmail("lorem@ipsum.com");
        formDataModel.setName("Lorem Ipsum");
        formDataModel.setSex(new Sex("Мужской"));
        formDataModel.setMood(SUPER);

        return new FormTestModel(formDataModel);
    }
}

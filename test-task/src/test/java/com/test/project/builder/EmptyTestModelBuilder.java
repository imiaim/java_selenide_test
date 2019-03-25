package com.test.project.builder;

import com.test.project.data.FormDataModel;
import com.test.project.data.FormTestModel;
import com.test.project.data.ValidationMessages;

public class EmptyTestModelBuilder {
    public static FormTestModel build() {
        FormDataModel formDataModel = new FormDataModel();
        FormTestModel formTestModel = new FormTestModel(formDataModel);

        formTestModel.setEmailValidationRequires(true);
        formTestModel.setEmailValidationMessage(ValidationMessages.FIELD_REQUIRED);

        formTestModel.setNameValidationRequires(true);
        formTestModel.setNameValidationMessage(ValidationMessages.FIELD_REQUIRED);

        formTestModel.setSexValidationRequires(true);
        formTestModel.setSexValidationMessage(ValidationMessages.FIELD_REQUIRED);

        formTestModel.setMoodValidationRequires(true);
        formTestModel.setMoodValidationMessage(ValidationMessages.FIELD_REQUIRED);

        return formTestModel;
    }
}

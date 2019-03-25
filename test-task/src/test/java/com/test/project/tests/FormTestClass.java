package com.test.project.tests;

import com.test.project.builder.EmptyTestModelBuilder;
import com.test.project.builder.InvalidEmailDataBuilder;
import com.test.project.builder.InvalidNameDataBuilder;
import com.test.project.builder.ValidTestModelBuilder;
import com.test.project.data.FormTestModel;
import com.test.project.pages.FormPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTestClass extends BaseTest {
    private FormPage page = new FormPage();

    @Test(dataProvider = "FormDataModel")
    public void submitFormTest(FormTestModel testModel) {
        page.openPage();
        page.fillForm(testModel.getFormData());
        page.submitForm();
        page.assertResult(testModel);
    }


    @DataProvider(name = "FormDataModel")
    public static Object[] formData() {
        return new Object[]{
                EmptyTestModelBuilder.build(),
                InvalidEmailDataBuilder.build(),
                InvalidNameDataBuilder.build(),
                ValidTestModelBuilder.build()
        };
    }
}

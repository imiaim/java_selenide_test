package com.test.project.data;

public class FormTestModel {
    private final FormDataModel formData;

    public FormTestModel(FormDataModel formData) {
        this.formData = formData;
    }

    private boolean emailValidationRequires;
    private boolean nameValidationRequires;
    private boolean sexValidationRequires;
    private boolean moodValidationRequires;

    private String emailValidationMessage;
    private String nameValidationMessage;
    private String sexValidationMessage;
    private String moodValidationMessage;

    public FormDataModel getFormData() {
        return formData;
    }

    public boolean isEmailValidationRequires() {
        return emailValidationRequires;
    }

    public void setEmailValidationRequires(boolean emailValidationRequires) {
        this.emailValidationRequires = emailValidationRequires;
    }

    public boolean isNameValidationRequires() {
        return nameValidationRequires;
    }

    public void setNameValidationRequires(boolean nameValidationRequires) {
        this.nameValidationRequires = nameValidationRequires;
    }

    public boolean isSexValidationRequires() {
        return sexValidationRequires;
    }

    public void setSexValidationRequires(boolean sexValidationRequires) {
        this.sexValidationRequires = sexValidationRequires;
    }

    public boolean isMoodValidationRequires() {
        return moodValidationRequires;
    }

    public void setMoodValidationRequires(boolean moodValidationRequires) {
        this.moodValidationRequires = moodValidationRequires;
    }

    public String getEmailValidationMessage() {
        return emailValidationMessage;
    }

    public void setEmailValidationMessage(String emailValidationMessage) {
        this.emailValidationMessage = emailValidationMessage;
    }

    public String getNameValidationMessage() {
        return nameValidationMessage;
    }

    public void setNameValidationMessage(String nameValidationMessage) {
        this.nameValidationMessage = nameValidationMessage;
    }

    public String getSexValidationMessage() {
        return sexValidationMessage;
    }

    public void setSexValidationMessage(String sexValidationMessage) {
        this.sexValidationMessage = sexValidationMessage;
    }

    public String getMoodValidationMessage() {
        return moodValidationMessage;
    }

    public void setMoodValidationMessage(String moodValidationMessage) {
        this.moodValidationMessage = moodValidationMessage;
    }

    public boolean requireValidation(){
        return emailValidationRequires || nameValidationRequires || sexValidationRequires || moodValidationRequires;
    }
}

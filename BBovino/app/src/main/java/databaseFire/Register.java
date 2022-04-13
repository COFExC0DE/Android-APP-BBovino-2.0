package databaseFire;

public class Register {

    // variables for storing our data.
    private String editTextUserRegister, editTextEmailRegister, editTextTextPasswordRegister, editTextTextConfirmPasswordRegister;

    public Register(String editTextUserRegister, String editTextEmailRegister, String editTextTextPasswordRegister) {
        this.editTextUserRegister = editTextUserRegister;
        this.editTextEmailRegister = editTextEmailRegister;
        this.editTextTextPasswordRegister = editTextTextPasswordRegister;
    }

    public String getEditTextUserRegister() {
        return editTextUserRegister;
    }

    public void setEditTextUserRegister(String editTextUserRegister) {
        this.editTextUserRegister = editTextUserRegister;
    }

    public String getEditTextEmailRegister() {
        return editTextEmailRegister;
    }

    public void setEditTextEmailRegister(String editTextEmailRegister) {
        this.editTextEmailRegister = editTextEmailRegister;
    }

    public String getEditTextTextPasswordRegister() {
        return editTextTextPasswordRegister;
    }

    public void setEditTextTextPasswordRegister(String editTextTextPasswordRegister) {
        this.editTextTextPasswordRegister = editTextTextPasswordRegister;
    }
}
package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        int len = 0;
        int digit = 0;
        int upperCase = 0;
        int lowerCase = 0;
        int specialCharacter = 0;

        if (newPassword.length() > 7) {
            len++;
        }

        for (int i = 0; i < newPassword.length(); i++) {
            char ch = newPassword.charAt(i);
            if (Character.isDigit(ch)) {
                digit++;
            }
            if (Character.isUpperCase(ch)) {
                upperCase++;
            }
            if (Character.isLowerCase((ch))) {
                lowerCase++;
            }
            if (!Character.isLetterOrDigit(ch) && !Character.isSpaceChar(ch)) {
                specialCharacter++;
            }
        }

        if (oldPassword.equals(password)) {
            if (len > 0 && digit > 0 && upperCase > 0 && lowerCase > 0 && specialCharacter > 0) {
                password = newPassword;
            }
        }
    }
}

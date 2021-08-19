package com.ikramdg.validation;

import java.util.regex.Pattern;

public class PhoneNumberValidation {

    private static final String VALID_PHONE_NUMBER_REGEX = "^\\d{10}$";

    // TODO validation

    private static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern validPattern = Pattern.compile(VALID_PHONE_NUMBER_REGEX);
        return validPattern.matcher(phoneNumber).matches();

    }
    /**
     * Checks if the phone number is valid. In this case, it was determined as 10 digits.
     *
     * @param phoneNumber
     * @return true if phone number is valid.
     */
    public static String validMessage(String phoneNumber) {
        if(!isValidPhoneNumber(phoneNumber)) {
            return "Phone number is not valid";
        }
        return null;
    }
}

package Utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    public static boolean isEmail (String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        return  emailMatcher.matches();
    }

    public static boolean isAValidDate(String date){

        String dateRegex = "^(0[0-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})";
        Pattern datePattern = Pattern.compile(dateRegex);
        Matcher dateMatcher = datePattern.matcher(date);

        return  dateMatcher.matches();
    }

    public static boolean isPersonalIDValid(String personalNumber) {

        String cleanIdNumber = personalNumber.replaceAll("[^0-9]", "");

        if (cleanIdNumber.length() != 11) return false;

        if(cleanIdNumber.matches("(\\d)\\1{10}")) return  false;

        int firstDigit = calculateDigit(cleanIdNumber.substring(0, 9), 10);
        int secondDigit = calculateDigit(cleanIdNumber.substring(0,10), 11);

        String trueIdNumber = cleanIdNumber.substring(0, 9) + String.valueOf(firstDigit) + String.valueOf(secondDigit);

        return cleanIdNumber.equals(trueIdNumber);
    }

    private static int calculateDigit(String base, int weight){

        int sum = 0;

        for (int idx = 0; idx < base.length(); idx++){

            sum += Character.getNumericValue(base.charAt(idx)) * weight;
            weight -= 1;
        }

        int rest = sum % 11;

        return  (rest < 2) ? 0 : 11 - rest;
    }
}

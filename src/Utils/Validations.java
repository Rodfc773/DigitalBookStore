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

    public static boolean isPersonalIDValid(String personalNumber){

        String cleanIdNumber = personalNumber.replaceAll("[^0-9]","");

        if(cleanIdNumber.length() != 11) throw new IllegalArgumentException("The CPF is invalid");

        String firstNineDigits = cleanIdNumber.substring(0,8);

        ArrayList<Integer> intDigits = new ArrayList<>();

        for (int idx = 0; idx < firstNineDigits.length(); idx++){

            int numericalChar = Character.getNumericValue(firstNineDigits.charAt(idx));
            intDigits.add(numericalChar);
        }

        int weights = 10;
        int result = 0;

        for (Integer intDigit : intDigits) {

            result += intDigit * weights;
        }

        return false;
    }
}

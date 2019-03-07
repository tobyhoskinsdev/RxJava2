package examples.aaronhoskins.com.rxjava.utilities;

import java.util.ArrayList;

import static examples.aaronhoskins.com.rxjava.model.CommonConstants.BLANK;

public class StringUtils {
    //check if string is null or empty
    public static boolean isActuallyEmpty(String stringToCheck) {
        return stringToCheck == null || stringToCheck.isEmpty();
    }

    //turn an array of strings to a single string
    public static String createStringFromArrayList(ArrayList<String> arrayList){
        StringBuilder sb = new StringBuilder();
        for(String currentString : arrayList) {
            sb.append(currentString);
            sb.append(BLANK);
        }
        return sb.toString();
    }

}

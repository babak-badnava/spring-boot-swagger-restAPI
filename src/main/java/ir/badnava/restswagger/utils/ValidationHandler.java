package ir.badnava.restswagger.utils;

public class ValidationHandler {

    public static boolean isNull(String str) {
        if (str == null || str.trim().isEmpty() || "null".equals(str))
            return true;
        return false;
    }
}

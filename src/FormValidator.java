import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidator {
    private Pattern pattern;
    private Matcher matcher;
    private final String EMAIL_REGEX = "^[a-z0-9.]+@([a-z0-9]+\\.){1,2}[a-z0-9]{2,6}$";
    private final String PHONE_REGEX = "^((08|09)\\d{7})|((03|04|07)\\d{8})$";

    public boolean email(String regex) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public boolean phone(String regex) {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

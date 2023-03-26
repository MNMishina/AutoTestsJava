package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringModifier {
    // отдельный класс для преобразования строки в красивый вид
    public static String getUniqueString(String str) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}

/**
 * Паттерн Property Reader. Получает значение браузера, url, проперти нэйм (из строки, если нет, то получает из файла).
 *
 * На вход получаем url и конкретный браузер из файла framework.properties. В случае исключения, выводим в консоль сообщение об ошибке + StackTrace.
 */

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String getUrl() {
        return getProperty("url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(getProperty("browser"));
    }

    private static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    private static String getPropertyFromFile(String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("src/test/resources/framework.properties");
            prop.load(input);
        } catch (IOException ex) {
            System.out.println("Cannot read property value for " + propertyName);
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(propertyName);
    }
}



/*    public static String getBaseUrl() {
            return getProperty("url");
        }
        public static Browser getBrowser() {
            return Browser.valueOf(getProperty("browser"));
        }
        private static String getProperty(String propertyName) {
            if (System.getProperty(propertyName) == null) {
                return getPropertyFromFile(propertyName);
            } else {
                return System.getProperty(propertyName);
            }
        }
*/


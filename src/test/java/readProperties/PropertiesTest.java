package readProperties;

import core.BaseTest;
import org.junit.Test;

import java.io.IOException;

public class PropertiesTest extends BaseTest {
    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperty = System.getProperty("url");
        System.out.println(urlFromProperty);
    }

    @Test
    public void readFromConf() {
        String urlFromConf = ConfigProvider.URL;
        System.out.println(urlFromConf);
        Integer ageFromConf = ConfigProvider.AGE;
        System.out.println(ageFromConf);
        String adminLoginFromConf = ConfigProvider.ADMIN_LOGIN;
        System.out.println(adminLoginFromConf);
        String demoPasswordFromConf = ConfigProvider.DEMO_PASSWORD;
        System.out.println(demoPasswordFromConf);
        Boolean isDemoAdminFromConf = ConfigProvider.IS_DEMO_ADMIN;
        System.out.println(isDemoAdminFromConf);
        if(ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")){
            System.out.println("Админ действительно является админом");
        } else {
            System.out.println("Нет, не является админом");
        }
    }
}

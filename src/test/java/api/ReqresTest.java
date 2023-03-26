/**
 * АПИ Тест 1: получение списка пользователей со 2й страницы https://reqres.in/
 * Проверить, что id и аватары юзеров совпадают
 * Проверить, что почта юзеров заканчсивается на @reqres.in
 * <p>
 * Тест 2: протестить регистрацию юзера в системе (успешная/с ошибкой из-за отсутствия пароля). Проверить коды ошибок
 * <p>
 * Тест 3: Операция LIST<RESOURCE> возвращает данные, отсортированные по годам
 * <p>
 * Тест 4: Удаление 2го юзера и сравнение статус-кода
 * <p>
 * Тест 5: Обновление инфы о пользователе и сравнение даты обновления с текущей датой на машине
 */
package api;

import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    //@NoArgsConstructor


    @Test // получение списка пользователей со 2й страницы сайта, сверка аватара и id юзеров
    public void checkAvatarAndIdTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                //.contentType(ContentType.JSON)
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        //users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(String.valueOf(x.getId()))));

        //Assert.assertTrue(users.stream().allMatch(x-> x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x -> String.valueOf(x.getId())).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test   // успешная регистрация
    public void successRegTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        // Проверка, что пришел не пустой результат
        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());
        // Проверка, что id совпадает с ожидаемым
        Assert.assertEquals(id, successReg.getId());
        // Проверка, что token совпадает с ожидаемым
        Assert.assertEquals(token, successReg.getToken());
    }

    @Test   // неуспешная регистрация
    public void unSuccessRegTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecError400());
        Register user = new Register("sydney@fife", "");
        UnSuccessReg unSuccessReg = given()
                .body(user)
                //.when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Missing password", unSuccessReg.getError());
    }

    @Test
    public void sortedYearsTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<ColorsData> colors = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(sortedYears, years);
        System.out.println(years);
        System.out.println(sortedYears);
    }

    @Test
    public void deleteUserTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }

    @Test
    public void timeTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String regex = "(.{5})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");
        System.out.println(currentTime.replaceAll(regex, ""));
        Assert.assertEquals((currentTime.replaceAll(regex, "")), response.getUpdatedAt().replaceAll(regex, ""));
        System.out.println(response.getUpdatedAt().replaceAll(regex, ""));
    }

    @Test
    public void getSingleResource() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        ColorsData singleResource = given()
                .when()
                .get("/api/unknown/2")
                .then().log().all()
                .extract().as(ColorsData.class);

    }

    @Test
    public void successfulLogin() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        String token = "QpwL5tke4Pnpja7X4";
        Login user = new Login("eve.holt@reqres.in", "cityslicka");
        SuccessLogin successLogin = given()
                .body(user)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().as(SuccessLogin.class);
        Assert.assertNotNull(successLogin.getToken());
        Assert.assertEquals(token, successLogin.getToken());
    }

}

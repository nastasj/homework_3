import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testov");
        $("#userEmail").setValue("test@testov.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("9451203654");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(5);
        $(".react-datepicker__year-select").selectOption(90);
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("Picture.webp");
        $("#currentAddress").setValue("Some address");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();
        $(".table-dark tbody tr", 0).shouldHave(text("Test Testov"));
        $(".table-dark tbody tr", 1).shouldHave(text("test@testov.com"));
        $(".table-dark tbody tr", 2).shouldHave(text("Male"));
        $(".table-dark tbody tr", 3).shouldHave(text("9451203654"));
        $(".table-dark tbody tr", 4).shouldHave(text("10 June,1990"));
        $(".table-dark tbody tr", 5).shouldHave(text("Maths, Economics"));
        $(".table-dark tbody tr", 6).shouldHave(text("Sports, Reading, Music"));
        $(".table-dark tbody tr", 7).shouldHave(text("Picture.webp"));
        $(".table-dark tbody tr", 8).shouldHave(text("Some address"));
        $(".table-dark tbody tr", 9).shouldHave(text("Haryana Panipat"));
    }
}

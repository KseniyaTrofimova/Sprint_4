package practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import practicum.HomePage;
import static practicum.Resources.*;

@RunWith(Parameterized.class)
public class FAQTest {

    @Rule
    public WebDriverFactory factory = new WebDriverFactory();
    // Параметры для каждого теста
    private final int questionNumber;
    private final String expectedAnswer;

    public FAQTest(int questionNumber, String expectedAnswer) {
        this.questionNumber = questionNumber;
        this.expectedAnswer = expectedAnswer;
    }

    // Данные для тестов
    @Parameterized.Parameters(name = "Вопрос #{0}: проверка ответа")
    public static Object[][] testData() {
        return new Object[][]{
                {1, COST_AND_PAYMENT_ANSWER_TEXT},
                {2, MULTIPLE_SCOOTERS_ANSWER_TEXT},
                {3, RENTAL_TIME_CALCULATION_ANSWER_TEXT},
                {4, TODAY_ORDER_ANSWER_TEXT},
                {5, ORDER_EXTENSION_ANSWER_TEXT},
                {6, CHARGER_INCLUDED_ANSWER_TEXT},
                {7, ORDER_CANCELLATION_ANSWER_TEXT},
                {8, OUTSIDE_MKAD_DELIVERY_ANSWER_TEXT}
        };
    }

    @Test
    public void checkFAQAnswer() {
        var driver = factory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.openMainPage();
        homePage.CookieButtonClick();
        homePage.scrollDownFAQ();
        homePage.clickQuestion(questionNumber);
        String actualAnswer = homePage.getAnswerText(questionNumber);
        homePage.isCorrectText(actualAnswer, expectedAnswer);
    }
}
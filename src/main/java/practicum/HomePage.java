package practicum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By COOKIE_BUTTON = By.xpath(".//button[text()='да все привыкли']");
    private final By FAQ_SECTION = By.className("Home_FAQ__3uVm4");
    private final By HEADER_ORDER_BUTTON = By.xpath(".//button[text()='Заказать'][1]");
    private final By PAGE_ORDER_BUTTON = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");
    private static final String URL = "https://qa-scooter.praktikum-services.ru";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public HomePage openMainPage() {
        driver.get(URL);
        return this;
    }
    // Метод для принятия куки
    public void CookieButtonClick() {
        driver.findElement(COOKIE_BUTTON).click();
    }
    public void scrollDownFAQ() {
        WebElement faq = wait.until(ExpectedConditions.visibilityOfElementLocated(FAQ_SECTION));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", faq);
    }
    // Метод для сравнения ответа на вопрос с ОР
    public void isCorrectText(String answer, String text) {
        Assert.assertEquals(text, answer);
    }
    // Методы для клика по кнопкам Заказать
    public void clickHeaderOrderButton() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }
    public void clickPageOrderButton() {
        // Скролл до кнопки
        WebElement bigButton = driver.findElement(PAGE_ORDER_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(PAGE_ORDER_BUTTON).click();
    }
    public void clickQuestion(int questionNumber) {
        By question = By.id(String.format("accordion__heading-%d", questionNumber - 1));
        wait.until(ExpectedConditions.elementToBeClickable(question)).click();
    }
    public String getAnswerText(int questionNumber) {
        By answer = By.id(String.format("accordion__panel-%d", questionNumber - 1));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answer)).getText();
    }
}


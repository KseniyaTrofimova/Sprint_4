package practicum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private final By COOKIE_BUTTON = By.xpath(".//button[text()='да все привыкли']");
    private final By HOW_MUCH_COST_QUESTION = By.xpath(".//div[@class='accordion__item'][1]");
    private final By MULTIPLE_SCOOTERS_QUESTION = By.xpath(".//div[@class='accordion__item'][2]");
    private final By RENTAL_TIME_CALCULATION_QUESTION = By.xpath(".//div[@class='accordion__item'][3]");
    private final By ORDER_FOR_TODAY_QUESTION = By.xpath(".//div[@class='accordion__item'][4]");
    private final By EXTEND_OR_EARLY_RETURN_QUESTION = By.xpath(".//div[@class='accordion__item'][5]");
    private final By CHARGER_INCLUDED_QUESTION = By.xpath(".//div[@class='accordion__item'][6]");
    private final By CANCEL_ORDER_QUESTION = By.xpath(".//div[@class='accordion__item'][7]");
    private final By OUTSIDE_MKAD_DELIVERY_QUESTION = By.xpath(".//div[@class='accordion__item'][8]");
    private final By COST_AND_PAYMENT_ANSWER = By.id("accordion__panel-0");
    private final By MULTIPLE_SCOOTERS_ANSWER = By.id("accordion__panel-1");
    private final By RENTAL_TIME_CALCULATION_ANSWER = By.id("accordion__panel-2");
    private final By TODAY_ORDER_ANSWER = By.id("accordion__panel-3");
    private final By ORDER_EXTENSION_ANSWER = By.id("accordion__panel-4");
    private final By CHARGER_INCLUDED_ANSWER = By.id("accordion__panel-5");
    private final By ORDER_CANCELLATION_ANSWER = By.id("accordion__panel-6");
    private final By OUTSIDE_MKAD_DELIVERY_ANSWER = By.id("accordion__panel-7");
    private final By HEADER_ORDER_BUTTON = By.xpath(".//button[text()='Заказать'][1]");
    private final By PAGE_ORDER_BUTTON = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");
    private static final String URL = "https://qa-scooter.praktikum-services.ru";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollDownFAQ() {
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
    }

    public void openMainPage() {
        driver.get(URL);
    }
    // Метод для принятия куки
    public void CookieButtonClick() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    // Методы для открытия вопросов
    public void clickHowMuchCostQuestion() {
        driver.findElement(HOW_MUCH_COST_QUESTION).click();
    }
    public void clickMultipleScootersQuestion() {
        driver.findElement(MULTIPLE_SCOOTERS_QUESTION).click();
    }
    public void clickRentalTimeCalculationQuestion() {
        driver.findElement(RENTAL_TIME_CALCULATION_QUESTION).click();
    }
    public void clickOrderForTodayQuestion() {
        driver.findElement(ORDER_FOR_TODAY_QUESTION).click();
    }
    public void clickExtendOrEarlyReturnQuestion() {
        driver.findElement(EXTEND_OR_EARLY_RETURN_QUESTION).click();
    }
    public void clickChargerIncludedQuestion() {
        driver.findElement(CHARGER_INCLUDED_QUESTION).click();
    }
    public void clickCancelOrderQuestion() {
        driver.findElement(CANCEL_ORDER_QUESTION).click();
    }
    public void clickOutsideMkadDeliveryQuestion() {
        driver.findElement(OUTSIDE_MKAD_DELIVERY_QUESTION).click();
    }
    // Метод для сравнения ответа на вопрос с ОР
    public void isCorrectText(String answer, String text) {
        Assert.assertEquals(text, answer);
    }
        // Геттеры для получения текса ответов
        public String getCostAndPaymentAnswer() {
            return driver.findElement(COST_AND_PAYMENT_ANSWER).getText();
    }
    public String getMultipleScootersAnswer() {
        return driver.findElement(MULTIPLE_SCOOTERS_ANSWER).getText();
    }
    public String getRentalTimeCalculationAnswer() {
        return driver.findElement(RENTAL_TIME_CALCULATION_ANSWER).getText();
    }
    public String getTodayOrderAnswer() {
        return driver.findElement(TODAY_ORDER_ANSWER).getText();
    }
    public String getOrderExtensionAnswer() {
        return driver.findElement(ORDER_EXTENSION_ANSWER).getText();
    }
    public String getChargerIncludedAnswer() {
        return driver.findElement(CHARGER_INCLUDED_ANSWER).getText();
    }
    public String getOrderCancellationAnswer() {
        return driver.findElement(ORDER_CANCELLATION_ANSWER).getText();
    }
    public String getOutsideMkadDeliveryAnswer() {
        return driver.findElement(OUTSIDE_MKAD_DELIVERY_ANSWER).getText();
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
    public void clickQuestion(int number) {
        driver.findElement(By.id("accordion__heading-" + (number - 1))).click();
    }

    public String getAnswer(int number) {
        return driver.findElement(By.id("accordion__panel-" + (number - 1))).getText();
    }
}


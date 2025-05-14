package practicum;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.hamcrest.core.Is.is;

public class HomePage {
    private final WebDriver driver;
    //Окно принятия куки
    private final By CookieButton = By.xpath(".//button[text()='да все привыкли']");
    // Сколько это стоит? И как оплатить?
    private final By question1 = By.xpath(".//div[@class='accordion__item'][1]");
    // Хочу сразу несколько самокатов! Так можно?
    private final By question2 = By.xpath(".//div[@class='accordion__item'][2]");
    // Как рассчитывается время аренды?
    private final By question3 = By.xpath(".//div[@class='accordion__item'][3]");
    // Можно ли заказать самокат прямо на сегодня?
    private final By question4 = By.xpath(".//div[@class='accordion__item'][4]");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private final By question5 = By.xpath(".//div[@class='accordion__item'][5]");
    // Вы привозите зарядку вместе с самокатом?
    private final By question6 = By.xpath(".//div[@class='accordion__item'][6]");
    // Можно ли отменить заказ?
    private final By question7 = By.xpath(".//div[@class='accordion__item'][7]");
    // Я живу за МКАДом, привезёте?
    private final By question8 = By.xpath(".//div[@class='accordion__item'][8]");
    // Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private final By answer1 = By.id("accordion__panel-0");
    // Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private final By answer2 = By.id("accordion__panel-1");
    // Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private final By answer3 = By.id("accordion__panel-2");
    // Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private final By answer4 = By.id("accordion__panel-3");
    // Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private final By answer5 = By.id("accordion__panel-4");
    // Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private final By answer6 = By.id("accordion__panel-5");
    // Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private final By answer7 = By.id("accordion__panel-6");
    // Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private final By answer8 = By.id("accordion__panel-7");
    // Маленькая кнопка Заказать на чердаке
    private final By headerOrderButton = By.xpath(".//button[text()='Заказать'][1]");
    // Большая кнопка заказать на странице
    private final By pageOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Метод для принятия куки
    public void CookieButtonClick() {
        driver.findElement(CookieButton).click();
    }

    // Методы для открытия вопросов
    public void clickQuestion1() {
        driver.findElement(question1).click();
    }
    public void clickQuestion2() {
        driver.findElement(question2).click();
    }
    public void clickQuestion3() {
        driver.findElement(question3).click();
    }
    public void clickQuestion4() {
        driver.findElement(question4).click();
    }
    public void clickQuestion5() {
        driver.findElement(question5).click();
    }
    public void clickQuestion6() {
        driver.findElement(question6).click();
    }
    public void clickQuestion7() {
        driver.findElement(question7).click();
    }
    public void clickQuestion8() {
        driver.findElement(question8).click();
    }
    // Метод для сравнения ответа на вопрос с ОР
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }
    // Геттеры для получения текса ответов
    public String getAnswer1() {
        return driver.findElement(answer1).getText();
    }
    public String getAnswer2() {
        return driver.findElement(answer2).getText();
    }
    public String getAnswer3() {
        return driver.findElement(answer3).getText();
    }
    public String getAnswer4() {
        return driver.findElement(answer4).getText();
    }
    public String getAnswer5() {
        return driver.findElement(answer5).getText();
    }
    public String getAnswer6() {
        return driver.findElement(answer6).getText();
    }
    public String getAnswer7() {
        return driver.findElement(answer7).getText();
    }
    public String getAnswer8() {
        return driver.findElement(answer8).getText();
    }
    // Методы для клика по кнопкам Заказать
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickPageOrderButton() {
        // Скролл до кнопки
        WebElement bigButton = driver.findElement(pageOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(pageOrderButton).click();
    }
}
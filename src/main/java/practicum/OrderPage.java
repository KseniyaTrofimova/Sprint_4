package practicum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;
    // Локаторы для заголовков
    private final By orderHeader = By.xpath("//div[text()='Для кого самокат']");
    private final By aboutOrderHeader = By.xpath("//div[text()='Про аренду']");
    private final By acceptCookieButton = By.xpath("//button[text()='да все привыкли']");
    // Локаторы для полей формы
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayField = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By orderNextButton = By.xpath("//button[text()='Далее']");
    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.xpath("//div[@class='Dropdown-placeholder']");
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By orderCreateButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    private final By orderConfirmButton = By.xpath("//button[text()='Да']");
    private final By confirmHeader = By.xpath("//button[text()='Посмотреть статус']");
    // Шаблоны для динамических локаторов
    private static final String SUBWAY_STATION_TEMPLATE = "//div[text()='%s']";
    private static final String RENTAL_PERIOD_TEMPLATE = "//div[text()='%s']";
    private static final String SCOOTER_COLOR_TEMPLATE = "//label[text()='%s']";

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    //Геттер для получения текста заголовка страницы заказа
    public String getOrderHeader() {
        return driver.findElement(orderHeader).getText();
    }
    //Геттер для получения текста на кнопке для просмотра статуса заказа
    public String getConfirmHeader() {
        return driver.findElement(confirmHeader).getText();
    }
    //Метод для проверки открытия страницы
    public void isPageOpen(String headerText, String text) {
        Assert.assertEquals(text, headerText);
    }
    //Метод для принятия куки
    public void acceptCookieButtonClick() {
        driver.findElement(acceptCookieButton).click();
    }
    //Метод для заполнения поля Имя
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //Метод для заполнения поля Фамилия
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    //Метод для заполнения поля Адрес доставки
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //Метод для заполнения поля Станция метро
    public void setSubway(String subway) {
        driver.findElement(subwayField).click();
        By subwayStationLocator = By.xpath(String.format(SUBWAY_STATION_TEMPLATE, subway));
        driver.findElement(subwayStationLocator).click();
    }
    //Метод для заполнения поля Телефон
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    //Метод для перехода ко второй странице создания заказа
    public void clickOrderNextButton() {
        driver.findElement(orderNextButton).click();
    }
    //Метод для заполнения поля Дата доставки
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
    //Метод для заполнения поля Срок аренды
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(aboutOrderHeader).click();
        driver.findElement(rentalPeriodField).click();
        By rentalPeriodLocator = By.xpath(String.format(RENTAL_PERIOD_TEMPLATE, rentalPeriod));
        driver.findElement(rentalPeriodLocator).click();
    }
    //Метод для заполнения поля Цвет самоката
    public void setColor(String color) {
        By colorLocator = By.xpath(String.format(SCOOTER_COLOR_TEMPLATE, color));
        driver.findElement(colorLocator).click();
    }
    //Метод для заполнения поля Комментарий для курьера
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    //Метод для перехода к подтверждению заказа
    public void clickOrderCreateButton() {
        driver.findElement(orderCreateButton).click();
    }
    //Метод для подтверждения заказа
    public void clickOrderConfirmButton() {
        driver.findElement(orderConfirmButton).click();
    }
}
package practicum;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
public class OrderPage {
    private final WebDriver driver;
    private final By orderHeader = By.xpath(".//div[text()='Для кого самокат']");
    private final By aboutOrderHeader = By.xpath(".//div[text()='Про аренду']");
    private final By acceptCookieButton = By.xpath(".//button[text()='да все привыкли']");
    //Имя
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес доставки
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Селектор со списком станций метро
    private final By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Телефон
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By orderNextButton = By.xpath(".//button[text()='Далее']");
    //Дата доставки
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    //Комментарий для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private final By orderCreateButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    //Кнопка подтверждения заказа
    private final By orderConfirmButton = By.xpath(".//button[text()='Да']");
    //Кнопка посмотреть статус
    private final By confirmHeader = By.xpath(".//button[text()='Посмотреть статус']");
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
        MatcherAssert.assertThat(headerText, is(text));
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
        driver.findElement(By.xpath(".//div[text()='"+subway+"']")).click();
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
        driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();
    }
    //Метод для заполнения поля Цвет самоката
    public void setColor(String color) {
        driver.findElement(By.xpath(".//label[text()='"+color+"']")).click();
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
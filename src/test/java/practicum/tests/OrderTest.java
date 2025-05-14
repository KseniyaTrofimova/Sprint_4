package practicum.tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import practicum.HomePage;
import practicum.OrderPage;
import static practicum.Resources.confirmHeader;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Ксения", "Трофимова", "г. Москва, ул. Пушкина, д.10", "Театральная", "89130154567", "01.02.2026", "сутки", "чёрный жемчуг", "Не звонить в дверь"},
                {"Илья", "Сергеев", "пр. Маяковского 6", "Маяковская", "+79657651234", "10.11.2027", "двое суток", "серая безысходность", "Привезите чистый самокат"},
        };
    }

    @Test
    public void OrderPositiveTest() {
        //Создание веб-драйвера для Chrome
        driver = new ChromeDriver();
        //Создание веб-драйвер для Firefox
        //driver = new FirefoxDriver();
        //Открытие домашней страницы Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        //Создание объекта класса с домашней страницей
        HomePage objHomePage = new HomePage(driver);
        //Клик по кнопке заказать на чердаке
        objHomePage.clickHeaderOrderButton();
        //Создан объект класса со страницей заказа
        OrderPage objOrderPage = new OrderPage(driver);
        //Принятие куки
        objOrderPage.acceptCookieButtonClick();
        //Позитивный сценарий для оформления заказа
        objOrderPage.setName(name);
        objOrderPage.setSurname(surname);
        objOrderPage.setAddress(address);
        objOrderPage.setSubway(subway);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.clickOrderNextButton();
        objOrderPage.setDate(date);
        objOrderPage.setRentalPeriod(rentalPeriod);
        objOrderPage.setColor(color);
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderCreateButton();
        objOrderPage.clickOrderConfirmButton();
        //Проверка, что открылась страница успешного создания заказа
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader() ,confirmHeader);
    }

    @After
    public void tearDown() {
        //Закрытие браузера
        driver.quit();
    }
}
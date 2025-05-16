package practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import practicum.HomePage;
import practicum.OrderPage;

import static practicum.Resources.CONFIRM_HEADER;

@RunWith(Parameterized.class)
public class OrderTest {
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

    @Parameterized.Parameters(name = "Order: {0} {1}, {3} station, {7} color")
    public static Object[][] getDateSetForOrder() {
        return new Object[][] {
                {"Ксения", "Трофимова", "г. Москва, ул. Пушкина, д.10", "Театральная", "89130154567", "01.02.2026", "сутки", "чёрный жемчуг", "Не звонить в дверь"},
                {"Илья", "Сергеев", "пр. Маяковского 6", "Маяковская", "+79657651234", "10.11.2027", "двое суток", "серая безысходность", "Привезите чистый самокат"},
        };
    }

    @Rule
    public WebDriverFactory factory = new WebDriverFactory();

    @Test
    public void OrderPositiveTest() {
        var driver = factory.getDriver();
        HomePage objHomePage = new HomePage(driver);
        objHomePage.openMainPage();
        objHomePage.clickHeaderOrderButton();
        OrderPage objOrderPage = new OrderPage(driver);
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
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader() ,CONFIRM_HEADER);
    }
}
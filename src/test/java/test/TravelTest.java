package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.DataHelper;
import data.SQLHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        String appUrl = System.getProperty("app.url");
        open(appUrl);
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSuccessWithValidDebitCard() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val validCardInformation = DataHelper.getValidCardInformation();
        cardData.fillCardInformationForSelectedWay(validCardInformation);
        cardData.checkIfPaymentSuccessful();
        val paymentId = SQLHelper.getPaymentId();
        val statusForPaymentByDebitCard = SQLHelper.getStatusForPaymentByDebitCard(paymentId);
        val paymentAmount = SQLHelper.getPaymentAmount(paymentId);
        assertEquals("APPROVED", statusForPaymentByDebitCard);
        assertEquals("4500000", paymentAmount);
    }

    @Test
    void shouldSuccessWithValidCreditCard() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val validCardInformation = DataHelper.getValidCardInformation();
        cardData.fillCardInformationForSelectedWay(validCardInformation);
        cardData.checkIfPaymentSuccessful();
        val paymentId = SQLHelper.getPaymentId();
        val statusForPaymentByCreditCard = SQLHelper.getStatusForPaymentByCreditCard(paymentId);
        assertEquals("APPROVED", statusForPaymentByCreditCard);
    }

    @Test
    void shouldNotSuccessWithInvalidDebitCard() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByDebitCard();
        val invalidCardInformation = DataHelper.getInvalidCardInformation();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfPaymentNotSuccessful();
        val paymentId = SQLHelper.getPaymentId();
        val statusForPaymentByDebitCard = SQLHelper.getStatusForPaymentByDebitCard(paymentId);
        assertThat(statusForPaymentByDebitCard, equalTo("DECLINED"));
    }

    @Test
    void shouldNotSuccessWithWrongCardNumber() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithWrongLongCardNumber();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }
    @Test
    void shouldNotSuccessWithShortestCardNumber() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithShortestCardNumber();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    void shouldNotSuccessWithWrongMonth() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithWrongMonth();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    void shouldNotSuccessWithWrongYear() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithWrongYear();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    void shouldNotSuccessWithWrongYearFromOneNumber() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithWrongYearWithOneNumber();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    void shouldNotSuccessWithWrongCVC() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithWrongCvc();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    void shouldNotSuccessWithWrongName() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithWrongHolderName();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }

    @Test
    void shouldNotSuccessWithoutName() {
        val mainPage = new MainPage();
        val cardData = mainPage.buyByCreditCard();
        val invalidCardInformation = DataHelper.getCardInformationWithoutName();
        cardData.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData.checkIfWrongFormatOfField();
        val cardData2 = mainPage.buyByDebitCard();
        cardData2.fillCardInformationForSelectedWay(invalidCardInformation);
        cardData2.checkIfWrongFormatOfField();
    }
}

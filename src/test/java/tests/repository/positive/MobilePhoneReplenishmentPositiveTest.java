package tests.repository.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.base.BaseTest;
import static constants.Constants.DOMAINS_URL.PRIVAT24_MOBILE_REPLENISHMENT_URL;
import static constants.Constants.TestDataForMobileReplenishment.*;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests to check the operation of replenishment of the mobile phone number")
@Story("A positive scenario")
@ExtendWith(Listener.class)
public class MobilePhoneReplenishmentPositiveTest extends BaseTest {

	@Test
	@DisplayName("Public session, non-client, ")
	void applyingForAnOldCarLoanPublicSession() {
		basePage.goToURL(PRIVAT24_MOBILE_REPLENISHMENT_URL);
		mobilePhoneReplenishment
			.enterPhoneNumber(PHONE_NUMBER_UKRAINE)
			.enterAmount("12")
			.enterCardNumber(TEST_CARD_1)
			.enterExpDate(EXP_DATE_CARD_1)
			.enterCvvCode(CVV_CODE_CARD_1)
			.submitMobileReplenishment()
			.checkPaymentAmountAndCommission("12", "1")
			.checkPaymentCurrency("UAH", "UAH");
	}
}

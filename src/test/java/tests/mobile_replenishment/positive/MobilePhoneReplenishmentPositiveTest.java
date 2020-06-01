package tests.mobile_replenishment.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import tests.base.BaseTest;
import static constants.Constants.CURRENCY.CURRENCY_UAH;
import static constants.Constants.DOMAINS_URL.PRIVAT24_MOBILE_REPLENISHMENT_URL;
import static constants.Constants.TestDataForMobileReplenishment.*;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests to check the operation of replenishment of the mobile phone number")
@Story("A positive scenario")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
public class MobilePhoneReplenishmentPositiveTest extends BaseTest {

	@Test
	@DisplayName("Public session, non-client, replenishment of mobile numbers for the minimum amount")
	void checkMinimumReplenishmentAmount() {
		basePage.goToURL(PRIVAT24_MOBILE_REPLENISHMENT_URL);
		mobilePhoneReplenishment
			.enterPhoneNumber(PHONE_NUMBER_UKRAINE)
			.enterAmount("1")
			.enterCardNumber(TEST_CARD_1)
			.enterExpDate(EXP_DATE_CARD_1)
			.enterCvvCode(CVV_CODE_CARD_1)
			.submitMobileReplenishment()
			.checkPaymentAmountAndCommission("1", "1")
			.checkPaymentCurrency(CURRENCY_UAH, CURRENCY_UAH)
			.checkPaymentCardAndRecipient(TEST_CARD_1_THE_LAST_FOUR_DIGITS, "Kyivstar Ukraine");
	}

	@Test
	@DisplayName("Public session, non-client, redirect checking for authorization, after selecting card from wallet")
	void checkRedirectOnAuthorization() {
		basePage.goToURL(PRIVAT24_MOBILE_REPLENISHMENT_URL);
		mobilePhoneReplenishment
			.selectCardFromWallet()
			.checkIsDisplayedAuthWidget();
	}
}

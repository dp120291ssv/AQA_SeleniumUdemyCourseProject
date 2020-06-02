package tests.car_loans.positive;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import static constants.Constants.DOMAINS_URL.PRIVAT24_CAR_LOANS_URL;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo/edit?usp=sharing")
@Feature("Tests to check credit for cars")
@Story("A positive scenario")
public class CarLoansPositiveTest extends BaseTest {

	@Test
	@DisplayName("Public session, non-client, applying for a loan for a car with a mileage")
	void applyingForAnOldCarLoanPublicSession() {
		basePage.goToURL(PRIVAT24_CAR_LOANS_URL);
		carLoans
			.checkSelectedTabWithMileageAuto()
			.enterAmountFieldCarCost("1500000")
			.enterAmountFieldPrepaidExpense("900000")
			.selectPhoneCodeButton()
			.searchPhoneCountryCodeField("Russ")
			.selectCountryCountryRussiaFromList()
			.enterPhoneNumber("000000000")
			.submitOrderButton()
			.checkIsDisplayedConfirm();
	}

	@Test
	@DisplayName("Public session, non-client, reviewing the contract")
	void selectAgreementsTabInPubSession() {
		basePage.goToURL(PRIVAT24_CAR_LOANS_URL);
		carLoans
			.selectAgreementsTab()
			.checkIsDisplayedAuthWidget();
	}
}

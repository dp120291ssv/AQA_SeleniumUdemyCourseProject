package tests.authorization.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.base.BaseTest;
import static constants.Constants.DOMAINS_URL.PRIVAT24_CAR_LOANS_URL;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests on logic for authorization")
@Story("A positive scenario")
@ExtendWith(Listener.class)
public class CarLoansPositiveTest extends BaseTest {

	@Test
	@DisplayName("Публичная сессия, неклиент, подача заявки на кредит на авто с пробегом")
	void applyingForAnOldCarLoanPublicSession() {
		basePage.goToURL(PRIVAT24_CAR_LOANS_URL);
		carLoans
			.checkSelectedTabWithMileageAuto()
			.typeAmountFieldCarCost("1500000")
			.typeAmountFieldPrepaidExpense("900000")
			.selectPhoneCodeButton()
			.searchPhoneCountryCodeField("Russ")
			.selectCountryCountryRussiaFromList()
			.typeJustPhoneNumber("000000000")
			.applyOrderButton()
			.checkIsDisplayedConfirm();
	}

//	@Test
//	@DisplayName("Публичная сессия, клиент, подача заявки на кредит на новое авто")
//	void applyingForANewCarLoanPublicSession() {
//		basePage.goToURL(PRIVAT24_CAR_LOANS_URL);
//		carLoans
//			.selectTabANewAuto()
//			.typeAmountFieldCarCost("1400000")
//			.dragAndDropSum()
//			.checkPrepaidExpenseSumAfterDragAndDrop("1400000")
//			.selectPhoneCodeButton()
//			.searchPhoneCuntryCodeField("Укр")
//			.selectCuntryCodeButtonFromList("Україна")
//			.typeJustPhoneNumber("686979712")
//			.applyOrderButton()
//			.checkIsDisplayedAuthWidget();
//	}
//
//	@Test
//	@DisplayName("Публичная сессия, просмотр договора")
//	void selectAgreementsTabInPubSession() {
//		basePage.goToURL(PRIVAT24_CAR_LOANS_URL);
//		carLoans
//			.selectAgreementsTab()
//			.checkIsDisplayedAuthWidget();
//	}
}

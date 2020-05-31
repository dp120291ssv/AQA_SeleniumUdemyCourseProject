package tests.repository.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.base.BaseTest;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests to check the operation of replenishment of the mobile phone number")
@Story("A positive scenario")
@ExtendWith(Listener.class)
public class MobilePhoneReplenishmentPositiveTest extends BaseTest {

	@Test
	public void check(){
		
	}
}

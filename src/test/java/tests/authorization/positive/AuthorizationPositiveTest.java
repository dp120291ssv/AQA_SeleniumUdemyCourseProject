package tests.authorization.positive;

import io.qameta.allure.Step;
import org.junit.Test;
import tests.base.BaseTest;

import static constants.Constants.AuthData.*;

public class AuthorizationPositiveTest extends BaseTest {

	@Step
	@Test
	public void checkAuthorization(){
		basePage.goToURL(GITHUB_URL);
		authorizationPage.login(USER_LOGIN, USER_PASSWORD)
			.checkIsCorrectUserAuthorized(USER_NAME);
	}

	@Step
	@Test
	public void checkLogout(){
		basePage.goToURL(GITHUB_URL);
		authorizationPage.login(USER_LOGIN, USER_PASSWORD)
			.checkIsCorrectUserAuthorized(USER_NAME)
			.logOut();
//			.checkIsUserNotAuthorized();
	}
}

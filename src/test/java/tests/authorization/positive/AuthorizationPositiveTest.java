package tests.authorization.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.base.BaseTest;
import static constants.Constants.AuthData.*;

@Feature("Проверка логики авторизации")
@Story("Позитивные сценарии")
@ExtendWith(Listener.class)
public class AuthorizationPositiveTest extends BaseTest {

	@Test
	public void checkAuthorization(){
		basePage.goToURL(GITHUB_URL);
		authorizationPage.login(USER_LOGIN, USER_PASSWORD)
			.checkIsCorrectUserAuthorized(USER_NAME);
	}

	@Test
	public void checkLogout(){
		basePage.goToURL(GITHUB_URL);
		authorizationPage.login(USER_LOGIN, USER_PASSWORD)
			.checkIsCorrectUserAuthorized(USER_NAME)
			.logOut()
			.checkIsUserNotAuthorized();
	}
}

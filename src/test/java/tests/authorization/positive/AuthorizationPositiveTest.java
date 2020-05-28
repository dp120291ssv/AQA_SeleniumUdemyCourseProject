package tests.authorization.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.base.BaseTest;
import static constants.Constants.AuthData.*;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests on logic for authorization")
@Story("A positive scenario")
@ExtendWith(Listener.class)
public class AuthorizationPositiveTest extends BaseTest {

	@Test
	public void checkAuthorization(){
		basePage.goToURL(GITHUB_URL);
		authorizationPage.selectLoginForm()
			.typeLogin(USER_LOGIN)
			.typePassword(USER_PASSWORD)
			.submitAuthorization()
			.selectUserProfilePicture()
			.checkIsCorrectUserAuthorized(USER_NAME);
	}

	@Test
	public void checkLogout(){
		basePage.goToURL(GITHUB_URL);
		authorizationPage.selectLoginForm()
			.typeLogin(USER_LOGIN)
			.typePassword(USER_PASSWORD)
			.submitAuthorization()
			.selectUserProfilePicture()
			.checkIsCorrectUserAuthorized(USER_NAME)
			.selectLogOut()
			.checkIsUserNotAuthorized();
	}

	@Test
	public void checkPasswordRecovery(){
		basePage.goToURL(GITHUB_URL);
		authorizationPage.selectLoginForm()
			.selectPasswordRecovery()
			.typeEmail(USER_EMAIL)
			.submitResetPasswordWithEmail()
			.checkIsResetPasswordSuccess();
	}
}

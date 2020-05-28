package tests.repository.positive;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import static constants.Constants.AuthData.*;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests for the logic to work with the repository")
@Story("A positive scenario")
public class RepositoryPositiveTests extends BaseTest {

	@Test
	public void checkTheCreationOfRepository() {
		basePage.goToURL(GITHUB_URL);
		authorizationPage.selectLoginForm()
			.typeLogin(USER_LOGIN)
			.typePassword(USER_PASSWORD)
			.submitAuthorization()
			.selectUserProfilePicture()
			.checkIsCorrectUserAuthorized(USER_NAME);
	}

	@Test
	public void checkDeleteTheRepository() {
		basePage.goToURL(GITHUB_URL);
		authorizationPage.selectLoginForm()
			.typeLogin(USER_LOGIN)
			.typePassword(USER_PASSWORD)
			.submitAuthorization()
			.selectUserProfilePicture()
			.checkIsCorrectUserAuthorized(USER_NAME);
	}
}

package tests.repository.positive;

import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import static constants.Constants.AuthData.*;
import static constants.Constants.TestData.REPOSITORY_NAME;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests for the logic to work with the repository")
@Story("A positive scenario")
public class RepositoryPositiveTests extends BaseTest {

	@Test
	public void checkThCreatingAndDeletingARepository() {
		basePage.goToURL(GITHUB_URL);
		authorizationPage.selectLoginForm()
			.enterLogin(USER_LOGIN)
			.enterPassword(USER_PASSWORD)
			.submitAuthorization();
		repositoryPage.submitCreateNewRepository()
			.enterTheRepositoryName(REPOSITORY_NAME)
			.selectRadioButtonPrivate()
			.selectCheckboxInitReadMe()
			.submitCreateRepository()
			.checkIsCorrectRepositoryName(REPOSITORY_NAME)
			.selectTabSettings()
			.selectDeleteRepository()
			.enterUsernameAndRepositoryNameToConfirmDeletion(USER_NAME + "/" + REPOSITORY_NAME)
			.confirmDeleteRepository()
			.сheckTheMessageThatTheRepositoryIsDeleted("Your repository \""+ USER_NAME + "/" + REPOSITORY_NAME +
				"\" was successfully deleted.");;
	}
}

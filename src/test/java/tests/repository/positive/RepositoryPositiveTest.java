package tests.repository.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.base.BaseTest;

@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo")
@Feature("Tests for the logic to work with the repository")
@Story("A positive scenario")
@ExtendWith(Listener.class)
public class RepositoryPositiveTest extends BaseTest {

//	@Test
//	public void checkThCreatingAndDeletingARepository() {
//		basePage.goToURL(GITHUB_URL);
//		authorizationPage.selectLoginForm()
//			.enterLogin(USER_LOGIN)
//			.enterPassword(USER_PASSWORD)
//			.submitAuthorization();
//		repositoryPage.submitCreateNewRepository()
//			.enterTheRepositoryName(REPOSITORY_NAME)
//			.selectRadioButtonPrivate()
//			.selectCheckboxInitReadMe()
//			.submitCreateRepository()
//			.checkIsCorrectRepositoryName(REPOSITORY_NAME)
//			.selectTabSettings()
//			.selectDeleteRepository()
//			.enterUsernameAndRepositoryNameToConfirmDeletion(USER_NAME + "/" + REPOSITORY_NAME)
//			.confirmDeleteRepository()
//			.сheckTheMessageThatTheRepositoryIsDeleted("Your repository \""+ USER_NAME + "/" + REPOSITORY_NAME +
//				"\" was successfully deleted.");;
//	}
}

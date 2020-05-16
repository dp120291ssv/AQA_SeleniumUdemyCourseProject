package base;

import pages.base.BasePage;
import pages.authorization.AuthorizationPage;
import pages.repository.RepositoryPage;

public class BaseTest {

	protected BasePage basePage = new BasePage();
	protected AuthorizationPage authorizationPage = new AuthorizationPage();
	protected RepositoryPage repositoryPage = new RepositoryPage();
}

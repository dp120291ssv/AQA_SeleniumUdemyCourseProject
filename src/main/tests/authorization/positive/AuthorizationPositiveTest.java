package authorization.positive;

import base.BaseTest;
import org.junit.Test;
import static constants.Constants.AuthData.GITHUB_URL;
import static constants.Constants.AuthData.USER_LOGIN;
import static constants.Constants.AuthData.USER_PASSWORD;

public class AuthorizationPositiveTest extends BaseTest{

	@Test
	public void checkAuthorization(){
		basePage.goToURL(GITHUB_URL);
		commonActions.getAuthorizationPage()
			.login(USER_LOGIN, USER_PASSWORD)
			.checkIsUserAuthorized();
	}
}

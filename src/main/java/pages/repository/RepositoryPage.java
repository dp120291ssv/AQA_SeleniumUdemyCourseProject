package pages.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class RepositoryPage extends BasePage{
	/**
	 * чек-лист: https://docs.google.com/spreadsheets/d/19e7u4TNyf2yRV6iJE8o1G2JlythWVH8MZPxyqZtf_Xo
	 * */

	public RepositoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
}

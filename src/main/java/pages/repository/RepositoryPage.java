package pages.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class RepositoryPage extends BasePage {

	public RepositoryPage(WebDriver driver) {
		super(driver);
	}

	private final By buttonNewRepository = By.xpath("(//a[@href='/new'])[2]");
	private final By inputRepositoryName = By.xpath("//input[@id='repository_name']");
	private final By radioButtonPrivat = By.xpath("//input[@id='repository_visibility_private']");
	private final By checkBoxInitReadMe = By.xpath("//input[@id='repository_auto_init']");
	private final By buttonCreateRepository = By.xpath("//button[contains(text(), 'Create repository')]");

	/**
	 * Submit New button to create a repository
	 * */
	public RepositoryPage submitCreateNewRepository(){
		driver.findElement(buttonNewRepository).click();
		return this;
	}

	/**
	 * Submit New button to create a repository
	 * @param repositoryName new repository name
	 * */
	public RepositoryPage enterTheRepositoryName(String repositoryName){
		driver.findElement(inputRepositoryName).sendKeys(repositoryName);
		return this;
	}

	/**
	 * Select radio button to make the repository private
	 * */
	public RepositoryPage selectRadioButtonPrivate(){
		driver.findElement(radioButtonPrivat).click();
		return this;
	}

	/**
	 * Selecting a checkbox to create a file README
	 * */
	public RepositoryPage selectCheckboxInitReadMe(){
		driver.findElement(checkBoxInitReadMe).click();
		return this;
	}

	/**
	 * Confirm repository creation
	 * */
	public RepositoryPage submitCreateRepository(){
		driver.findElement(buttonCreateRepository).click();
		return this;
	}

//		Assert.assertEquals("udemyTest1", explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@data-hovercard-type='user'])[1]")))
//			.getText());
//
//		Assert.assertEquals("new1", explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-pjax='#js-repo-pjax-container']")))
//			.getText());
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Private')]")));
//


//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='js-selected-navigation-item reponav-item'])[7]")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//summary[contains(text(), 'Delete this repository')]")))
//			.click();
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='verify'])[3]")))
//			.sendKeys("udemyTest1/new1");
//
//		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'I understand the consequences, delete this repository')]")))
//			.click();
//
//		Assert.assertEquals("Your repository \"udemyTest1/new1\" was successfully deleted.", explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='js-flash-container']/div/div")))
//			.getAttribute("outerText"));


}

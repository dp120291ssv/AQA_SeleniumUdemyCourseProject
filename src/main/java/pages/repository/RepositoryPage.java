package pages.repository;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private final By repositoryName = By.xpath("//a[@data-pjax='#js-repo-pjax-container']");
	private final By tabSettings = By.xpath("(//a[@class='js-selected-navigation-item reponav-item'])[7]");
	private final By buttonDeleteRepository = By.xpath("//summary[contains(text(), 'Delete this repository')]");
	private final By inputVerify = By.xpath("(//input[@name='verify'])[3]");
	private final By buttonConfirmDeleteRepository = By.xpath("//button[contains(text(), 'I understand the consequences, delete this repository')]");
	private final By messageThatRepositoryIsDeleted = By.xpath("//div[@id='js-flash-container']/div/div");

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
		driver.findElement(buttonCreateRepository).submit();
		return this;
	}

	/**
	 * Select the settings tab in the repository
	 * */
	public RepositoryPage selectTabSettings(){
		driver.findElement(tabSettings).click();
		return this;
	}

	/**
	 * Select delete repository
	 * */
	public RepositoryPage selectDeleteRepository(){
		driver.findElement(buttonDeleteRepository).click();
		return this;
	}

	/**
	 * Enter username and repository name to confirm deletion
	 * */
	public RepositoryPage enterUsernameAndRepositoryNameToConfirmDeletion(String userAndRepositoryName){
		driver.findElement(inputVerify).sendKeys(userAndRepositoryName);
		return this;
	}

	/**
	 * Confirm delete repository
	 * */
	public RepositoryPage confirmDeleteRepository(){
		driver.findElement(buttonConfirmDeleteRepository).click();
		return this;
	}

	/**
	 * Confirm repository creation
	 * */
	public RepositoryPage checkIsCorrectRepositoryName(String nameOfRepository){
		WebElement actualRepositoryName = driver.findElement(repositoryName);
		Assertions.assertEquals(nameOfRepository, actualRepositoryName.getText());
		return this;
	}

	/**
	 * Chech the message that the repository is deleted
	 * */
	public RepositoryPage сheckTheMessageThatTheRepositoryIsDeleted(String expectedMessage){
		Assertions.assertEquals(expectedMessage, driver.findElement(messageThatRepositoryIsDeleted).getAttribute("outerText"));
		return this;
	}
}

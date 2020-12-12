package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YouTube {
@FindBy(xpath="//input[@id='search']")
public WebElement searchBar;

public void navigateToHomepage() {
	
}
}

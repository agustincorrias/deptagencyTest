package site;

import driver.DriverManager;
import org.openqa.selenium.By;
import selenium.ElementOperations;

public class MainPage extends ElementOperations {


    private By btnAgree = By.xpath("//button[contains(.,'AGREE')]");
    private By firstChip = By.xpath("//img[contains(@name,'space02')]");
    private By secondChip = By.xpath("//img[contains(@name,'space22')]");
    private By firstSpace = By.xpath("//img[contains(@name,'space13')]");
    private By secondSpace = By.xpath("//img[contains(@name,'space33')]");

    private By listOfIaChips = By.xpath("//img[@src='me1.gif'])");
    private By listOfSecondChips = By.xpath("(//img[@src='you1.gif'])");


    public MainPage(DriverManager driverManager) {
        super(driverManager);
    }

    public void acceptPrivacy() {
        waitFor(5);
        clickElement(btnAgree);
    }

    public void firstMove() {

        moveChip(firstChip, firstSpace);
        waitFor(5);
        moveChip(secondChip, secondSpace);
        waitFor(1);
    }

    public int countChipsFirstPlayer(){
        return countChips(listOfSecondChips);
    }


}

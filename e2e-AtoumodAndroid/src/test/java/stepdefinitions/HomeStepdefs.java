package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Homepages;

public class HomeStepdefs {

    private final Homepages home = new Homepages();

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        home.verifyHomeTitleIsVisible();
    }

    @When("I click the Later button")
    public void iClickTheLaterButton() {
        home.clickLater();
    }

    @And("I verify the Terms message")
    public void iVerifyTheTermsMessage() {
        home.verifyTermsTextIsVisible();
    }

    @And("I accept the Terms")
    public void iAcceptTheTerms() {
        home.acceptTermsIfNeeded();
    }

    @And("If geolocation popup appears I click OK")
    public void ifGeolocationPopupAppearsIClickOK() {
        home.confirmGeolocationIfVisible();
    }

    @And("I allow map permission")
    public void iAllowMapPermission() {
        home.allowPermissionIfVisible();
    }

    @And("I click the Check later button")
    public void iClickTheCheckLaterButton() {
        home.tapCheckLaterByCoordinates();
    }

    @Then("I search network {string}")
    public void iSearchNetwork(String network) {
        home.searchNetwork(network);
    }
}

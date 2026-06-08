package stepdefinitions.api;

import api.ApiClient;
import hooks.Hooks;

import com.microsoft.playwright.APIResponse;

import io.cucumber.java.en.*;

import utils.ConfigReader;
import utils.JsonUtil;

public class LoginValidationSteps {

    private String payload;

    private APIResponse response;

    private ApiClient apiClient =
            new ApiClient(
                    ConfigReader.get("baseUrl"));

    @Given("User loads {string}")
    public void user_loads(String fileName) {

        payload =
                JsonUtil.readJson(
                        "src/test/resources/testdata/login/"
                                + fileName
                                + ".json");

        System.out.println(payload);
    }

    @When("User sends login request using loaded payload")
    public void user_sends_login_request() {

        response =
                apiClient.post(
                        "/api/ecom/auth/login",
                        payload);

        System.out.println(
                response.text());

            Hooks.test.info("Endpoint : /api/ecom/auth/login");

            Hooks.test.info("Payload : " + payload);

            Hooks.test.info("Status Code : " + response.status());

            Hooks.test.info("Response : " + response.text());
    }

    @Then("Login status code should be {int}")
    public void login_status_code_should_be(
            Integer expectedStatus) {

        System.out.println(
                "Expected : "
                        + expectedStatus);

        System.out.println(
                "Actual : "
                        + response.status());

        org.testng.Assert.assertEquals(
                response.status(),
                expectedStatus.intValue());
    }
}
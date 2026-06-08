package stepdefinitions.api;

import api.ApiClient;
import api.ApiResponseValidator;
import hooks.Hooks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.ConfigReader;
import utils.SessionManager;

public class AddProductSteps {

    ApiClient apiClient =
            new ApiClient(
                    ConfigReader.get("baseUrl"));

    APIResponse response;

    ApiResponseValidator validator =
            new ApiResponseValidator();

   @When("User adds a product")
public void user_adds_a_product() {

    System.out.println(
            "TOKEN = "
                    + SessionManager.getToken());

    System.out.println(
            "USERID = "
                    + SessionManager.getUserId());

    response =
            apiClient.addProduct(
                    SessionManager.getToken(),
                    SessionManager.getUserId());

    String responseBody =
            response.text();

    System.out.println(responseBody);

    try {

        ObjectMapper mapper =
                new ObjectMapper();

        JsonNode jsonNode =
                mapper.readTree(responseBody);

        String productId =
                jsonNode.get("productId")
                        .asText();

        SessionManager.setProductId(
                productId);

        System.out.println(
                "PRODUCT ID : "
                        + productId);

        Hooks.test.pass(
                "Product Created Successfully");

        Hooks.test.info(
                "Product ID : "
                        + productId);

        Hooks.test.info(
                "Endpoint : /api/ecom/product/add-product");

        Hooks.test.info(
                "Status Code : "
                        + response.status());

        Hooks.test.info(
                "Response : "
                        + responseBody);

    } catch (Exception e) {

        Hooks.test.fail(
                "Failed to extract Product ID");

        throw new RuntimeException(e);
    }
}

    @Then("Product should be created successfully")
    public void product_should_be_created_successfully() {

        validator.validateStatusCode(
                response,
                201);
    }
}
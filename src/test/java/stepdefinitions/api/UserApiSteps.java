package stepdefinitions.api;

import api.ApiClient;
import api.ApiResponseValidator;
import hooks.Hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;

import io.cucumber.java.en.*;

import utils.ConfigReader;
import utils.JsonUtil;
import utils.SessionManager;

public class UserApiSteps {

    ApiClient apiClient;

    APIResponse response;

    String payload;

    ApiResponseValidator validator =
            new ApiResponseValidator();

    @Given("User prepares login payload")
    public void user_prepares_login_payload() {

        payload = JsonUtil.readJson(
                "src/test/resources/testdata/login/positive.json");

        System.out.println(payload);
    }

   

    @When("User sends login request")
    public void user_sends_login_request() throws JsonMappingException, JsonProcessingException {

        apiClient =
                new ApiClient(
                        ConfigReader.get("baseUrl"));

        response =
                apiClient.post(
                        "/api/ecom/auth/login",
                        payload);

        System.out.println(
                response.text());

                Hooks.test.info(
        "Login API Executed");

        
        //Takeing value from response
        String responseBody = response.text();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode =
                mapper.readTree(responseBody);

        String token =
                jsonNode.get("token").asText();

        String userId =
                jsonNode.get("userId").asText();

        SessionManager.setToken(token);
        SessionManager.setUserId(userId);
        
        String maskedResponse =
        responseBody.replaceAll(
                "\"token\":\".*?\"",
                "\"token\":\"********\"");
                
        Hooks.test.info(
        "Response : "
                + maskedResponse);

        System.out.println("TOKEN : " + token);
        System.out.println("USERID : " + userId);
    }
    
}
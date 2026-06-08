package api;

import com.microsoft.playwright.APIResponse;
import org.testng.Assert;

public class ApiResponseValidator {

    public void validateStatusCode(
            APIResponse response,
            int expectedStatus){

        Assert.assertEquals(
                response.status(),
                expectedStatus,
                "Status Code Mismatch");
    }

    public void validateResponseContains(
            APIResponse response,
            String expectedText){

        Assert.assertTrue(
                response.text().contains(expectedText),
                "Expected text not found");
    }
    
    public void printResponse(
            APIResponse response){

        System.out.println(
                response.text());
    }
}
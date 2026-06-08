package api;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;
import com.microsoft.playwright.options.FormData;
import com.microsoft.playwright.options.RequestOptions;

public class ApiClient {

    private Playwright playwright;
    private APIRequestContext request;

    public ApiClient(String baseUrl) {

        playwright = Playwright.create();

        request = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL(baseUrl));
    }
    

    public APIResponse get(String endpoint) {

        return request.get(endpoint);
    }
    
    

    public APIResponse post(String endpoint,String body) {

        return request.post(
                endpoint,
                RequestOptions.create()
                        .setHeader("Content-Type",
                                "application/json")
                        .setData(body));
    }

    //login api call
    public APIResponse put(String endpoint, String body) {

        return request.put(
                endpoint,
                RequestOptions.create()
                        .setData(body)
        );
    }
    
    
    
   //AddProduct Api call
    public APIResponse delete(String endpoint) {

        return request.delete(endpoint);
    }
    
public APIResponse addProduct(
        String token,
        String productAddedBy) {

    try {

        System.out.println("TOKEN : " + token);
        System.out.println("USERID : " + productAddedBy);

        Path imagePath =
                Paths.get(
                        "src/test/resources/testdata/images/shopping.jpg");

        System.out.println(
                "IMAGE EXISTS : "
                        + Files.exists(imagePath));

        System.out.println(
                "IMAGE PATH : "
                        + imagePath.toAbsolutePath());

        FilePayload image =
                new FilePayload(
                        "shopping.jpg",
                        "image/jpeg",
                        Files.readAllBytes(imagePath));

        FormData formData = FormData.create();

        formData.set("productName", "qwerty");
        formData.set("productAddedBy", productAddedBy);
        formData.set("productCategory", "fashion");
        formData.set("productSubCategory", "shirts");
        formData.set("productPrice", "11500");
        formData.set("productDescription", "Addias Originals");
        formData.set("productFor", "women");
        formData.set("productImage", image);

        APIResponse response =
                request.post(
                        "/api/ecom/product/add-product",

                        RequestOptions.create()
                                .setHeader(
                                        "Authorization",
                                        token)
                                .setMultipart(formData));

        System.out.println(
                "STATUS : "
                        + response.status());

        System.out.println(
                "RESPONSE : "
                        + response.text());

        return response;

    } catch (Exception e) {

        e.printStackTrace();

        throw new RuntimeException(
                "Failed while creating product",
                e);
    }
}

    public void close() {

        request.dispose();
        playwright.close();
    }
}
package utils;

public class SessionManager {

    private static String token;
    private static String userId;
    private static String productId;

    public static void setToken(String authToken) {
        token = authToken;
    }

    public static String getToken() {
        return token;
    }

    public static void setUserId(String id) {
        userId = id;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setProductId(String id) {
        productId = id;
    }

    public static String getProductId() {
        return productId;
    }
}
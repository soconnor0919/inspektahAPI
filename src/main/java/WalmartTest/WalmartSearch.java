package WalmartTest;

import org.json.JSONArray;
import org.json.JSONObject;
import okhttp3.*;

import java.util.Scanner;

/**
 * This class demonstrates how to perform a search using the Walmart API based on user input.
 */
public class WalmartSearch {

    private static final String WALMART_API_URL = "https://developer.api.walmart.com/api-proxy/service/affil/product/v2/search";

    /**
     * The main method that initiates the Walmart API search based on user input.
     *
     * @param args The command-line arguments (not used in this example).
     * @throws Exception If an error occurs during the API request or response processing.
     * @author sso005
     */
    public static void main(String[] args) throws Exception {
        HeaderGenerator generator = new HeaderGenerator();

        // Ask the user for a query
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a search query: ");
        String userQuery = scanner.nextLine();

        // Build the URL with the user's query
        String apiUrlWithQuery = WALMART_API_URL + "?query=" + userQuery;

        // Create the request
        Request request = new Request.Builder()
                .url(apiUrlWithQuery)
                .headers(Headers.of(generator.getHeaders()))
                .build();

        // Execute the request and get the response
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        // Parse the response JSON
        JSONObject json = new JSONObject(response.body().string());

        // Check if the response contains items
        if (json.has("items")) {
            JSONArray items = json.getJSONArray("items");

            // Print all items
            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                System.out.println(item.getString("name") + ": " + item.getDouble("salePrice"));
            }
        } else {
            System.out.println("No items found for the given query.");
        }
    }
}

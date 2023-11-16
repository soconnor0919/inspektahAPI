/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King
 *
 * Names: O'Connor, Sean
 *        Sanders, Alec
 *        Gaines, Geoffrey
 *        Finkler, Aidan
 *
 * Project: csci205_final_project
 * Package: WalmartAPI.logic
 * Class: WalmartSearchModel
 *
 * Description:
 * A class that represents the model for the Walmart
 * product search application.
 * ****************************************
 */

package WalmartAPI.logic;

import WalmartAPI.model.Item;
import WalmartAPI.model.SortType;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * A class that represents the model for the Walmart
 * product search application.
 */
public class WalmartSearchModel {
    // The header generator
    private HeaderGenerator headerGenerator;

    /**
     * Constructor.
     */
    public WalmartSearchModel() {
        try {
            this.headerGenerator = new HeaderGenerator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Perform a search based on user input.
     *
     * @param userQuery    The user's search query.
     * @param sortType     The sort type for the search.
     * @param itemsPerPage The number of items per page.
     * @return An array of Item objects representing the search results.
     * @throws IOException If an error occurs during the API request or response processing.
     */
    public Item[] search(String userQuery, SortType sortType, int itemsPerPage) throws IOException {
        String apiUrlWithQuery = "https://developer.api.walmart.com/api-proxy/service/affil/product/v2/search" +
                "?query=" + userQuery + "&sort=" + sortType.getSortType() + "&format=json" + "&numItems=" + itemsPerPage;

        // Create the request
        Request request = new Request.Builder()
                .url(apiUrlWithQuery)
                .headers(Headers.of(headerGenerator.getHeaders()))
                .build();

        // Execute the request and get the response
        try (Response response = new OkHttpClient().newCall(request).execute()) {
            // Parse the response JSON
            JSONObject json = new JSONObject(response.body().string());

            if (json.has("items")) {
                JSONArray items = json.getJSONArray("items");

                Item[] itemArray = new Item[items.length()];
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    itemArray[i] = new Item(
                            item.getString("name"),
                            item.getDouble("salePrice"),
                            item.getString("thumbnailImage"),
                            item.optDouble("customerRating", 0.0),
                            Integer.toString(item.getInt("itemId")),
                            item.getString("categoryPath"),
                            item.getString("shortDescription"));
                }

                return itemArray;
            } else {
                return new Item[0]; // Return an empty array if no items found
            }
        }
    }
}

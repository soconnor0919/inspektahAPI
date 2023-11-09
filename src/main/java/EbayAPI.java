/**This is Alec's attempt at accessing the Ebay Finding API
 * Oh lawdy here we go
*/

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EbaySearch {
    public static void main(String[] args) {
        String url = "https://svcs.ebay.com/services/search/FindingService/v1";
        String app_id = "YOUR_APP_ID_HERE";

        String query = "iphone";
        String responseFormat = "JSON";

        String requestUrl = url + "?OPERATION-NAME=findItemsByKeywords"
                + "&keywords=" + query
                + "&SECURITY-APPNAME=" + app_id
                + "&RESPONSE-DATA-FORMAT=" + responseFormat;

        try {
            URL urlObj = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                // Extract price information from 'content'
                // You can parse the JSON response here

            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



/*
*
*
* */
/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Geoffrey Gaines
 * Section: MWF 9 am
 * Date: 11/7/2023
 * Time: 1:03 PM
 *
 * Project: csci205_Inspektah_API
 * Package: org.ggaf
 * Class: AmazonProductFinder
 *
 * Description: dont forget 'load gradle changes' button
 * AWS Toolkit plugin recommended (?)
 *
 * ****************************************
 */


package AWSDraft;

import software.amazon.awssdk.services.pricing.PricingClient;
//import software.amazon.awssdk.services.pricing.model.*;
import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.pricing.model.Product;




import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonProductFinder {
    private final PricingClient pricingClient;

    public AmazonProductFinder(String region) {
        this.pricingClient = PricingClient.builder()
                .region(Region.of(region))
                .build();
    }

    public String getAsin(String itemName) {
        // Use the Product Advertising API to search for the item and get its ASIN
        // This is a simplified example and does not include error handling or pagination
        // You need to replace this with actual code to call the Amazon Product Advertising API
        return "B000000000";
    }

    /**
     *
     * @param asin
     * @return
     *
    public List<Product> getLowestPricedProducts(String asin) {
        // Use the Product Pricing API to retrieve pricing information for the item
        GetProductsRequest request = GetProductsRequest.builder()
                .serviceCode("AmazonEC2")
                .filters(Filter.builder()
                        .type("TERM_MATCH")
                        .field("ServiceCode")
                        .value("AmazonEC2")
                        .build())
                .build();
        GetProductsResponse result = pricingClient.getProducts(request);

        // Sort the products by price and return the ten with the lowest prices
        List<Product> products = result.priceList();
        Collections.sort(products, Comparator.comparing(Product::price));
        return products.subList(0, Math.min(10, products.size()));
    */
    }


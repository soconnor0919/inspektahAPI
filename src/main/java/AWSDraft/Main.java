/* *****************************************
 * CSCI 205 - Software Engineering and Design
 * Fall 2023
 * Instructor: Prof. Brian King / Prof. Joshua Stough
 *
 * Name: Geoffrey Gaines
 * Section: MWF 9 am
 * Date: 11/8/2023
 * Time: 9:53 AM
 *
 * Project: csci205_final_project
 * Package: AWSDraft
 * Class: Main
 *
 * Description:
 *
 * ****************************************
 */
package AWSDraft;


public class Main {

    public static void main(String[] args) {
        AmazonProductFinder finder = new AmazonProductFinder("us-east-1");
        String itemName = "Enter the name of the item: ";
        String asin = finder.getAsin(itemName);
        /**
        List<Product> lowestPricedProducts = finder.getLowestPricedProducts(asin);
        for (Product product : lowestPricedProducts) {
            System.out.println(product.productName() + ": " + product.price());
         */
        }
    }



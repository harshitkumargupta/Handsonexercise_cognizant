import java.util.Arrays;

public class SearchFunction {

    /*
     * Big O Notation Explanation:
     * Big O notation is a mathematical notation that describes the limiting behavior of a function 
     * when the argument tends towards a particular value or infinity. In computer science, it is used 
     * to classify algorithms according to how their run time or space requirements grow as the input size grows.
     * 
     * Linear Search Scenarios:
     * - Best Case: O(1) - The target element is at the very first index of the array.
     * - Average Case: O(n) - On average, the target element is somewhere in the middle.
     * - Worst Case: O(n) - The target element is at the very last index or not present in the array.
     * 
     * Binary Search Scenarios:
     * - Best Case: O(1) - The target element is exactly at the middle index on the first check.
     * - Average Case: O(log n) - The algorithm halves the search space at each step.
     * - Worst Case: O(log n) - The target element is found at the end of the search space halving or not found.
     * 
     * Suitability:
     * For an e-commerce platform where products are repeatedly searched, Binary Search is far more suitable 
     * due to its O(log n) time complexity, which handles large datasets much faster than Linear Search's O(n).
     * However, Binary Search requires the array to be sorted beforehand, which takes O(n log n) time.
     * If the array of products is relatively static (few inserts/deletes compared to searches), sorting once 
     * and binary searching many times is optimal.
     */

    // Linear Search Implementation
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product p : products) {
            if (p.getProductId().equals(targetId)) {
                return p;
            }
        }
        return null; // Not found
    }

    // Binary Search Implementation
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Laptop", "Electronics"),
            new Product("P001", "Smartphone", "Electronics"),
            new Product("P004", "Desk Chair", "Furniture"),
            new Product("P002", "Coffee Maker", "Home Appliances"),
            new Product("P005", "Running Shoes", "Apparel")
        };

        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(products, "P004");
        System.out.println("Linear Search for 'P004': " + (foundLinear != null ? foundLinear : "Not found"));

        System.out.println("\n--- Binary Search ---");
        // Binary search requires a sorted array
        Arrays.sort(products);
        Product foundBinary = binarySearch(products, "P004");
        System.out.println("Binary Search for 'P004': " + (foundBinary != null ? foundBinary : "Not found"));
    }
}
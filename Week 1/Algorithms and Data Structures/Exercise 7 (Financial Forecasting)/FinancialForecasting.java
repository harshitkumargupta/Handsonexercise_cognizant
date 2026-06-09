public class FinancialForecasting {

    /*
     * Concept of Recursion:
     * Recursion is a programming technique where a method calls itself to solve a smaller instance 
     * of the same problem. It simplifies certain problems by breaking them down into self-similar 
     * sub-problems until reaching a base case that can be solved directly without further recursion.
     * 
     * Time Complexity Analysis:
     * The time complexity of this simple recursive algorithm is O(n), where n is the number of periods (years) 
     * into the future we are forecasting. This is because the recursive function calls itself exactly n times, 
     * decrementing the periods by 1 each time until it reaches the base case (periods == 0).
     * 
     * Optimization to avoid excessive computation:
     * Since this specific recursion tree is linear (a single branch at each step), it doesn't suffer from 
     * overlapping subproblems like calculating Fibonacci sequences recursively (which would be O(2^n)).
     * However, each recursive call consumes stack space (O(n) space complexity).
     * To optimize for performance and avoid StackOverflowError for very large 'n', we can:
     * 1. Use an iterative approach (a simple loop), which reduces space complexity to O(1).
     * 2. Use memoization if we were calculating branches with overlapping subproblems.
     * 3. For this exact mathematical model (Future Value = Present Value * (1 + rate)^n), we can 
     *    compute it in O(1) time using Math.pow(1 + rate, periods).
     */

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: If 0 periods left, the future value is the present value
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive step: Calculate value for 1 period, and recursively call for remaining periods - 1
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial amount
        double growthRate = 0.05;     // 5% growth rate
        int periods = 10;             // 10 years into the future

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        
        System.out.printf("Present Value: $%.2f%n", presentValue);
        System.out.printf("Growth Rate: %.2f%%%n", growthRate * 100);
        System.out.printf("Periods: %d years%n", periods);
        System.out.printf("Forecasted Future Value: $%.2f%n", futureValue);
    }
}
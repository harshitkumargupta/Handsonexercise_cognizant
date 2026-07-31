public class ObserverTest {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket("TCS");

        Observer mobile = new MobileApp("Harshit");
        Observer web = new WebApp("Admin");

        stock.registerObserver(mobile);
        stock.registerObserver(web);

        stock.setPrice(3500.75);
        stock.setPrice(3550.25);
    }
}
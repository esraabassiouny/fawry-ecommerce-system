import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Test Case 1:
        Product cheese = new Product("Cheese", 100, 10, true, 200, true, LocalDate.now().plusDays(5));
        Product biscuits = new Product("Biscuits", 150, 5, true, 700, true, LocalDate.now().plusDays(5));
        Product scratchCard = new Product("ScratchCard", 50, 20, false, 0, false, null);

        ECommerceSystem.products = new ArrayList<>();
        ECommerceSystem.products.add(cheese);
        ECommerceSystem.products.add(biscuits);
        ECommerceSystem.products.add(scratchCard);

        Customer customer = new Customer();
        customer.setBalance(1000);
        Cart cart = new Cart();
        cart.addToCart(cheese, 2);
        cart.addToCart(biscuits, 1);
        cart.addToCart(scratchCard, 1);
        try {
            ECommerceSystem.checkout(customer, cart);
        } catch (RuntimeException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

//        //Test Case 2: Cart is Empty
//        Product cheese2 = new Product("Cheese", 100, 10, true, 200, true, LocalDate.now().plusDays(5));
//        ECommerceSystem.products = new ArrayList<>();
//        ECommerceSystem.products.add(cheese2);
//        Customer customer2 = new Customer();
//        customer2.setBalance(1000);
//        Cart cart2 = new Cart();
//        try {
//            ECommerceSystem.checkout(customer2, cart2);
//        } catch (RuntimeException e) {
//            System.out.println("Checkout failed: " + e.getMessage());
//        }

//        // --- Test Case 3: Insufficient Balance
//        Product cheese3 = new Product("Cheese", 500, 2, true, 1000, true, LocalDate.now().plusDays(5));
//        ECommerceSystem.products = new ArrayList<>();
//        ECommerceSystem.products.add(cheese3);
//        Customer customer3 = new Customer();
//        customer3.setBalance(100);
//        Cart cart3 = new Cart();
//        cart3.addToCart(cheese3, 1);
//        try {
//            ECommerceSystem.checkout(customer3, cart3);
//        } catch (RuntimeException e) {
//            System.out.println("Checkout failed: " + e.getMessage());
//        }

//        //  Test Case 4: Product is Expired
//        Product expiredCheese = new Product("Cheese", 100, 5, true, 200, true, LocalDate.now().minusDays(1));
//        ECommerceSystem.products = new ArrayList<>();
//        ECommerceSystem.products.add(expiredCheese);
//        Customer customer4 = new Customer();
//        customer4.setBalance(500);
//        Cart cart4 = new Cart();
//        cart4.addToCart(expiredCheese, 1);
//        try {
//            ECommerceSystem.checkout(customer4, cart4);
//        } catch (RuntimeException e) {
//            System.out.println("Checkout failed: " + e.getMessage());
//        }

//        // --- Test Case 5: Quantity Exceeds Stock ---
//        Product cheese5 = new Product("Cheese", 100, 2, true, 200, true, LocalDate.now().plusDays(5));
//        ECommerceSystem.products = new ArrayList<>();
//        ECommerceSystem.products.add(cheese5);
//        Customer customer5 = new Customer();
//        customer5.setBalance(1000);
//        Cart cart5 = new Cart();
//        cart5.addToCart(cheese5, 5);
//        try {
//            ECommerceSystem.checkout(customer5, cart5);
//        } catch (RuntimeException e) {
//            System.out.println("Checkout failed: " + e.getMessage());
//        }
    }
}

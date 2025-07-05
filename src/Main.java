import java.time.LocalDate;
import java.util.ArrayList;
import java.lang.System;


public class Main {
    public static void main(String[] args) {
        Product cheese = new Product(
                "Cheese", 100, 10,
                true, 200,
                true, LocalDate.now().plusDays(5)
        );

        Product biscuits = new Product(
                "Biscuits", 150, 5,
                true, 700,
                true, LocalDate.now().plusDays(5)
        );

        Product scratchCard = new Product(
                "ScratchCard", 50, 20,
                false, 0,
                false, null
        );

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
    }
}
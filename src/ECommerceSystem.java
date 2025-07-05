import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

abstract class ECommerceSystem
{
    public static List<Product> products = new ArrayList<>();;
    private static PrintWriter out = new PrintWriter(System.out, true);;

    static void addProduct(String name,double price, int quantity)
    {
        Product product = new Product(name,price,quantity);
        products.add(product);
    }

    static void updateProductQuantity(String name, int quantity)
    {
        for (Product product : products) {
            if (product.name.equals(name)) {
                if (quantity <= product.quantity) {
                    product.quantity -= quantity;
                } else {
                    String errorMessage;
                    if (product.quantity == 0)
                        errorMessage = product.name + " is out of stock\n";
                    else
                        errorMessage = product.name + " quantity is not available. Only " + product.quantity + " is in stock\n";

                    throw new RuntimeException(errorMessage);
                }
            }

        }
    }

    static void checkout(Customer customer,Cart cart)
    {
        if(cart.empty)
        {
            throw new RuntimeException("Cart is empty.\n");
        }
        double totalPrice = cart.calculateTotalPrice();
        if(totalPrice > customer.getBalance())
        {
            throw new RuntimeException("Your balance is insufficient.\n");
        }
        for(Product product: cart.products)
        {
            if(product.expirable != null && product.expirable.isExpired())
            {
                throw new RuntimeException(product.name + " is expired.\n");
            }
            ECommerceSystem.updateProductQuantity(product.name, product.quantity);
        }
        printCheckoutDetails(customer,cart,totalPrice);
    }

    static void printCheckoutDetails(Customer customer, Cart cart,double totalPrice) {
        double totalWeight = 0;
        List<Product> shippable = new ArrayList<Product>();
        ECommerceSystem.out.println("** Shipment notice **");

        for (Product product : cart.products) {
            int qty = product.quantity;

            if (product.shippable != null) {
                shippable.add(product);
                Shippable s = product.shippable;
                ECommerceSystem.out.println(qty + "x " + s.getName());
                for (int i = 0; i < qty; i++) {
                    ECommerceSystem.out.println((int)(s.getWeight() ) + "g");
                    totalWeight += s.getWeight();
                }
            }
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight/1000);

        System.out.println("** Checkout receipt **");

        for (Product product : cart.products) {
            int qty = product.quantity;
            double price = product.price * qty;
            System.out.println(qty + "x " + product.name);
            System.out.println(price);
        }

        System.out.println("----------------------");
        ShippingService shippingService = new ShippingService(shippable);

        double shipping = shippingService.calculateShippingPrice();
        double total = totalPrice + shipping;
        customer.setBalance(customer.getBalance() - total);

        System.out.println("Subtotal         ");
        System.out.println(totalPrice);
        System.out.println("Shipping         ");
        System.out.println(shipping);
        System.out.println("Amount           ");
        System.out.println(total);
    }

}


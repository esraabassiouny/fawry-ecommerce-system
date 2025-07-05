import java.util.ArrayList;
import java.util.List;

class Cart
{
    List<Product> products = new ArrayList<>();;
    boolean empty;
    void addToCart(Product product, int quantity)
    {
        Product cartItem = new Product(
                product.name,
                product.price,
                quantity,
                product.shippable != null,
                product.shippable != null ? product.shippable.getWeight() : 0,
                product.expirable != null,
                product.expirable != null ? product.expirable.getExpiryDate() : null
        );
        this.products.add(cartItem);
        empty = false;
    }

    void removeFromCart(String name)
    {
        for(Product product:products)
        {
            if(product.name.equals(name))
            {
                products.remove(product);
            }
        }
        if(products.isEmpty())
        {
            if(!empty)
                empty = true;
        }
    }
    double calculateTotalPrice()
    {
        double totalPrice = 0;
        for(Product product:products)
        {
            totalPrice += product.quantity * product.price;
        }
        return totalPrice;
    }

}

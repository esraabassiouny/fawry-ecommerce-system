import java.util.List;

class ShippingService
{
    static List<Product> shippableProducts;
    public ShippingService(List<Product> shippableProducts)
    {
        this.shippableProducts = shippableProducts;
    }
    static double calculateShippingPrice()
    {
        double totalWeight = 0;
        for(Product product:shippableProducts)
        {
            double weight = product.shippable.getWeight();
            totalWeight += weight * product.quantity;
        }
        return 0.075 * totalWeight;
    }
}
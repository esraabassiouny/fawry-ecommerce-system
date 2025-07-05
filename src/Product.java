import java.time.LocalDate;

public class Product
{
    String name;
    double price;
    int quantity;
    Shippable shippable;

    Expirable expirable;

    public Product(String name)
    {
        this.name = name;
    }
    public Product(String name,int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }
    public Product(String name,double price,int quantity)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public Product(String name, double price, int quantity, boolean isShippable, double weight, boolean isExpirable, LocalDate expiryDate)
    {
        this.name = name;
        this.quantity = quantity;
        this.price = price;

        if(isShippable)
        {
            Shippable shippable = new Shippable()
            {
                public double getWeight() { return weight; }
                public String getName() { return name; }
            };
            this.shippable = shippable;
        }

        if(isExpirable)
        {
            Expirable expirable = new Expirable()
            {
                public boolean isExpired() {
                    return LocalDate.now().isAfter(expiryDate);
                }

                public LocalDate getExpiryDate() {
                    return expiryDate;
                }
            };
            this.expirable = expirable;
        }
    }

}

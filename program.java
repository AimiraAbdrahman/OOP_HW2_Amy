import java.util.List;

public class program {

    public static void main(String[] args) {

        Human jack = new Human("Jack");
        Human mary = new Human("Mary");
        Human john = new Human("John");

        Market amazon = new Market();

        amazon.acceptToMarket(jack);
        amazon.acceptToMarket(mary);

        amazon.giveOrders(jack, List.of(EProduct.FRUIT, EProduct.VEGETABLE));
        amazon.giveOrders(mary, List.of(EProduct.BREAD, EProduct.DRINK));

        amazon.update();

        amazon.releaseFromMarket(jack); 
        amazon.releaseFromMarket(mary); 

        amazon.acceptToMarket(john);
        amazon.giveOrders(john, List.of(EProduct.FRUIT, EProduct.BREAD));

        amazon.update();

        amazon.releaseFromMarket(john);

        amazon.update();
        
    }
}
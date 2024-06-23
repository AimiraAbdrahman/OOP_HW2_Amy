import java.util.ArrayList;
import java.util.List;

public class Human extends Actor {

    public List<EProduct> order = new ArrayList<EProduct>();

    public Human(String name) {
        super(name);
        order = new ArrayList<>();
        setMakeOrder(false);
        setTakeOrder(false);
    }

    public Human(String name, List<EProduct> products) {
        super(name);
        order.addAll(products);
        setMakeOrder(true);
        setTakeOrder(false);
    }

    @Override
    public void setMakeOrder(boolean fag) {//флаг сделан ли заказ
        this.isMakeOrder = fag;
    }

    @Override
    public void setTakeOrder(boolean fag) {//флаг получен ли заказ
        this.isTakeOrder = fag;
    }

    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    @Override
    public String getName() {
        return name;
    }

    public void saveOrder(EProduct product){
        order.add(product);
        setMakeOrder(true);
    }

    public void saveOrder(List<EProduct> products){
        order.addAll(products);
        setMakeOrder(true);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, order);
    }

}

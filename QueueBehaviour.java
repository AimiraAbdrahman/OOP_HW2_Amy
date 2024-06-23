import java.util.List;

public interface QueueBehaviour {

    void takeInQueue(Human actor); //встать в очередь

    void takeOrders(); // принять заказ

    void giveOrders(Human actor, List<EProduct> products); // сделать заказ

    void releaseFromQueue(Human actor);// выйти из очереди

}
import java.util.ArrayList;
import java.util.List;

// Реализовать класс Market и
// все методы, которые он
// обязан реализовывать.
// Методы из интерфейса
// QueueBehaviour, имитируют
// работу очереди,
// MarketBehaviour – помещает и
// удаляет человека из очереди,
// метод update – обновляет
// состояние магазина
// (принимает и отдает заказы)

public class Market implements MarketBehaviour, QueueBehaviour {

    private List<Human> actors = new ArrayList<Human>();

    private List<Human> actorsinQueue = new ArrayList<Human>();

    public void acceptToMarket(Human actor) { // человек заходит в магазин
        if (!actors.contains(actor)) {
            actors.add(actor);
            System.out.printf("%s вошёл в магазин.\n", actor.getName());
        }else{
            System.out.printf("%s находится в магазине.\n", actor.getName());
        }
    }

    public void releaseFromMarket() { // человек выходит из магазина
        List<Human> humanLeave = new ArrayList<>();
        for (Human human : actors) {
            if (human.isTakeOrder()) {
                System.out.printf("%s вышёл из магазина, сделав заказ.\n", human.getName());
                humanLeave.add(human);
            } else if(!human.isMakeOrder()){
                System.out.printf("%s вышёл из магазина, не сделав заказ.\n", human.getName());
                humanLeave.add(human);
            }
        }
        actors.removeAll(humanLeave);
    }

    @Override
    public void update() {
        int i = 0;
        for (Human human : actors) {
            if (human.isMakeOrder() & !human.isTakeOrder()) {
                takeInQueue(human);
            }
        }
        while (actorsinQueue.size() > 0) {
                takeOrders();
                i++;
        }
        System.out.printf("STATUS: %d заказов выдано, в магазине осталось %d посетителей.\n", i, actors.size());
    }

    @Override
    public void giveOrders(Human actor, List<EProduct> products) { // сделать заказ/добавить список продуктов
        if (actor.isMakeOrder()) {
            System.out.printf("%s дополнил заказ.\n", actor.getName());
        }else{
            System.out.printf("%s сделал заказ.\n", actor.getName());
        }
        int namActor = actors.indexOf(actor);
        Human tempActor = actors.remove(namActor);
        tempActor.saveOrder(products);
        actors.add(tempActor);
    }

    @Override
    public void releaseFromQueue(Human actor) {// выход из очереди
        System.out.printf("%s вышел из очереди не получив заказ.\n", actor.getName());
        actorsinQueue.remove(actor);
    }

    @Override
    public void takeInQueue(Human actor) {// вход в очередь
        System.out.printf("%s встал в очередь за заказом.\n", actor.getName());
        if (actor.isMakeOrder()) {
            actorsinQueue.add(actor);
        }

    }

    @Override
    public void takeOrders() { // сделать заказ и выйти из очереди
        Human actorWithOrder = actorsinQueue.remove(0);
        System.out.printf("%s получил заказ и вышел из очереди.\n", actorWithOrder.getName());
        actorWithOrder.setTakeOrder(true);
    }

    public int countActors(){ // всего покупателей в магазине
        return actors.size();
    }

    @Override
    public void releaseFromMarket(Human actor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'releaseFromMarket'");
    }
}
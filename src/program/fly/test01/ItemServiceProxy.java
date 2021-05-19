package program.fly.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 丁星（镜月）
 */
public class ItemServiceProxy implements ItemService {
    private ItemService itemService = new ItemServiceImpl();

    @Override
    public void update(Item item) {
        // do some logic
        itemService.update(item);
        this.notifyAllObservers("update", item);
    }

    @Override
    public void create(Item item) {
        // do some logic
        itemService.create(item);
        this.notifyAllObservers("create", item);
    }

    private List<Observer> observers
            = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);
    }


    public void notifyAllObservers(String noticeType, Item item) {
        for (Observer observer : observers) {
            observer.notice(noticeType, item);
        }
    }
}

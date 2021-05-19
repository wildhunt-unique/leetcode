package program.fly.test01;

/**
 * @author 丁星（镜月）
 */
public class UserService {
    private ItemServiceProxy itemService;

    public UserService(ItemServiceProxy itemService) {
        this.itemService = itemService;
    }

    public void register(User user) {
        // do some logic
        UserObserver userObserver = new UserObserver(user);
        itemService.attach(userObserver);
    }
}

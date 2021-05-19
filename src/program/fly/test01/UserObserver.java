package program.fly.test01;

/**
 * @author 丁星（镜月）
 */
public class UserObserver extends Observer {
    private final User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void notice(String noticeType, Item item) {
        switch (noticeType) {
            case "update":
                System.out.println("通知用户:" + user.getUsername() + ", 商品:" + item.getName() + ", 发生了更新");
                break;
            case "create":
                System.out.println("通知用户:" + user.getUsername() + ", 商品:" + item.getName() + ", 新上架");
                break;
            default:
                System.out.println("通知用户:" + user.getUsername() + ", 商品:" + item.getName() + ", 发生了变化");
                break;
        }
    }
}

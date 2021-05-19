package program.fly.test01;

/**
 * @author 丁星（镜月）
 */
public class Test01 {
    public static void main(String[] args) {
        ItemServiceProxy itemService = new ItemServiceProxy();
        UserService userService = new UserService(itemService);

        userService.register(new User("张三"));
        userService.register(new User("李四"));

        Item item = new Item("MacBookPro 13寸");
        itemService.create(item);
        itemService.update(item);

        // 通知用户:张三, 商品:MacBookPro 13寸, 新上架
        // 通知用户:李四, 商品:MacBookPro 13寸, 新上架
        // 通知用户:张三, 商品:MacBookPro 13寸, 发生了更新
        // 通知用户:李四, 商品:MacBookPro 13寸, 发生了更新
    }
}

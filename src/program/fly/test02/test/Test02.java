package program.fly.test02.test;

/**
 * @author 丁星（镜月）
 */
public class Test02 {
    public static void main(String[] args) {
        MotorProvider motorProvider = new MotorProvider();
        motorProvider.getMotor("electirc").drive();
        motorProvider.getMotor("optical").drive();
        // 输出
        // 电驱动
        // 光驱动
    }
}

package program.fly.test02.test;

/**
 * @author 丁星（镜月）
 */
public class MotorProvider {
    private Motor electircAdapter;
    private Motor opticalAdapter;

    public MotorProvider() {
        electircAdapter = new ElectricMotorAdapter(new ElectricMotor());
        opticalAdapter = new OpticalMotorAdapter(new OpticalMotor());
    }

    public Motor getMotor(String motorType) {
        if (null == motorType || motorType.isEmpty()) {
            return null;
        }

        switch (motorType) {
            case "electirc":
                return electircAdapter;
            case "optical":
                return opticalAdapter;
            default:
                return null;
        }
    }
}

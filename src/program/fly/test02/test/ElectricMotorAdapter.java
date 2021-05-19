package program.fly.test02.test;

/**
 * @author 丁星（镜月）
 */
public class ElectricMotorAdapter implements Motor {
    public ElectricMotorAdapter(ElectricMotor electricMotor) {
        this.electricMotor = electricMotor;
    }

    private ElectricMotor electricMotor;

    @Override
    public void drive() {
        electricMotor.electricDrive();
    }
}

package program.fly.test02.test;

/**
 * @author 丁星（镜月）
 */
public class OpticalMotorAdapter implements Motor {
    private OpticalMotor opticalMotor;

    public OpticalMotorAdapter(OpticalMotor opticalMotor) {
        this.opticalMotor = opticalMotor;
    }

    @Override
    public void drive() {
        opticalMotor.opticalDrive();
    }
}

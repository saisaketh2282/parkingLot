public class MotorcycleFeeStrategy implements FeeStrategy {
    public double calculateFee(long durationInHours) {
        return durationInHours * 10;
    }
}
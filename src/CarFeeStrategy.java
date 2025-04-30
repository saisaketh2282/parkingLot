public class CarFeeStrategy implements FeeStrategy {
    public double calculateFee(long durationInHours) {
        return durationInHours * 20;
    }
}
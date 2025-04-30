public class BusFeeStrategy implements FeeStrategy {
    public double calculateFee(long durationInHours) {
        return durationInHours * 40;
    }
}
import java.time.Duration;
import java.time.LocalDateTime;

public class FeeCalculator {
    public double calculateFee(ParkingTicket ticket) {
        long hours = Duration.between(ticket.getCheckInTime(), LocalDateTime.now()).toHours();
        FeeStrategy strategy = getStrategy(ticket.getVehicle().getType());
        return strategy.calculateFee(hours);
    }

    private FeeStrategy getStrategy(VehicleType type) {
        return switch (type) {
            case MOTORCYCLE -> new MotorcycleFeeStrategy();
            case CAR -> new CarFeeStrategy();
            case BUS -> new BusFeeStrategy();
        };
    }
}
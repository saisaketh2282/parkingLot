import java.time.LocalDateTime;
import java.util.List;

public class ParkingLotService {
    private final ParkingLotRepository repository;
    private final FeeCalculator feeCalculator;

    public ParkingLotService(ParkingLotRepository repository, FeeCalculator feeCalculator) {
        this.repository = repository;
        this.feeCalculator = feeCalculator;
    }

    public ParkingTicket checkInVehicle(Vehicle vehicle) {
        var spotOpt = repository.findAvailableSpot(vehicle.getType());
        if (spotOpt.isEmpty()) throw new RuntimeException("No available spot for vehicle type");

        ParkingSpot spot = spotOpt.get();
        spot.setAvailable(false);
        ParkingTicket ticket = new ParkingTicket(vehicle, spot);
        repository.saveTicket(ticket);
        return ticket;
    }

    public double checkOutVehicle(long ticketId) {
        ParkingTicket ticket = repository.getTicket(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid ticket ID");

        double fee = feeCalculator.calculateFee(ticket);
        ticket.checkOut(LocalDateTime.now(), fee);
        ticket.getSpot().setAvailable(true);
        repository.removeTicket(ticketId);
        return fee;
    }

    public List<ParkingSpot> getAvailableSpots() {
        return repository.getAvailableSpots();
    }
}
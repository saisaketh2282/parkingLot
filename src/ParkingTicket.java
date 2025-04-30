import java.time.LocalDateTime;

public class ParkingTicket {
    private static long ticketCounter = 1;
    private final long ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private double feePaid;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketCounter++;
        this.vehicle = vehicle;
        this.spot = spot;
        this.checkInTime = LocalDateTime.now();
    }

    public long getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getSpot() { return spot; }
    public LocalDateTime getCheckInTime() { return checkInTime; }
    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public double getFeePaid() { return feePaid; }

    public void checkOut(LocalDateTime checkOutTime, double fee) {
        this.checkOutTime = checkOutTime;
        this.feePaid = fee;
    }
}
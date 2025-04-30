import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotRepository {
    private final Map<Long, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
    private final List<ParkingSpot> spots = new ArrayList<>();

    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public Optional<ParkingSpot> findAvailableSpot(VehicleType type) {
        return spots.stream()
                .filter(s -> s.isAvailable() && s.getSpotSize() == type)
                .findFirst();
    }

    public void saveTicket(ParkingTicket ticket) {
        activeTickets.put(ticket.getTicketId(), ticket);
    }

    public ParkingTicket getTicket(long ticketId) {
        return activeTickets.get(ticketId);
    }

    public void removeTicket(long ticketId) {
        activeTickets.remove(ticketId);
    }

    public List<ParkingSpot> getAvailableSpots() {
        List<ParkingSpot> available = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) available.add(spot);
        }
        return available;
    }
}
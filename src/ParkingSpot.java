public class ParkingSpot {
    private final long id;
    private final String spotNumber;
    private final int floorNumber;
    private final VehicleType spotSize;
    private boolean isAvailable;

    public ParkingSpot(long id, String spotNumber, int floorNumber, VehicleType spotSize) {
        this.id = id;
        this.spotNumber = spotNumber;
        this.floorNumber = floorNumber;
        this.spotSize = spotSize;
        this.isAvailable = true;
    }

    public long getId() { return id; }
    public String getSpotNumber() { return spotNumber; }
    public int getFloorNumber() { return floorNumber; }
    public VehicleType getSpotSize() { return spotSize; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}

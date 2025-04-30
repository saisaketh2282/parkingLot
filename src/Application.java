public class Application {
    public static void main(String[] args) {
        ParkingLotRepository repository = new ParkingLotRepository();
        FeeCalculator feeCalculator = new FeeCalculator();
        ParkingLotService service = new ParkingLotService(repository, feeCalculator);

        // Setup sample spots
        repository.addParkingSpot(new ParkingSpot(1, "M1", 0, VehicleType.MOTORCYCLE));
        repository.addParkingSpot(new ParkingSpot(2, "C1", 0, VehicleType.CAR));
        repository.addParkingSpot(new ParkingSpot(3, "B1", 0, VehicleType.BUS));

        // Simulate check-in
        Vehicle vehicle = new Vehicle.Builder()
                .licensePlate("ABC123")
                .type(VehicleType.CAR)
                .build();

        ParkingTicket ticket = service.checkInVehicle(vehicle);
        System.out.println("Checked in: " + ticket.getTicketId());

        // Simulate check-out after some time
        double fee = service.checkOutVehicle(ticket.getTicketId());
        System.out.println("Checked out. Fee: " + fee);

        // Check available spots
        System.out.println("Available spots: " + service.getAvailableSpots().size());
    }
}
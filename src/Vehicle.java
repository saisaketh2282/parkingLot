import java.util.concurrent.atomic.AtomicLong;

public class Vehicle {
    private static final AtomicLong idCounter = new AtomicLong();
    private final long id;
    private final String licensePlate;
    private final VehicleType type;

    private Vehicle(Builder builder) {
        this.id = idCounter.incrementAndGet();
        this.licensePlate = builder.licensePlate;
        this.type = builder.type;
    }

    public long getId() { return id; }
    public String getLicensePlate() { return licensePlate; }
    public VehicleType getType() { return type; }

    public static class Builder {
        private String licensePlate;
        private VehicleType type;

        public Builder licensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

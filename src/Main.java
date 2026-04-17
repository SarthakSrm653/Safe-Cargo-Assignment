// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Enum for Bogie Shape
enum BogieShape {
    RECTANGULAR,
    CYLINDRICAL
}

// Enum for Cargo Type
enum CargoType {
    COAL,
    GRAINS,
    PETROLEUM
}

// GoodsBogie Class
class GoodsBogie {
    private String bogieId;
    private BogieShape shape;
    private CargoType cargo;

    public GoodsBogie(String bogieId, BogieShape shape) {
        this.bogieId = bogieId;
        this.shape = shape;
    }

    public String getBogieId() {
        return bogieId;
    }

    public BogieShape getShape() {
        return shape;
    }

    public CargoType getCargo() {
        return cargo;
    }

    public void setCargo(CargoType cargo) {
        this.cargo = cargo;
    }
}

// Service Class
class CargoService {

    public void assignCargo(GoodsBogie bogie, CargoType cargo) {

        try {
            System.out.println("Assigning " + cargo + " to Bogie: " + bogie.getBogieId());

            // Unsafe condition
            if (bogie.getShape() == BogieShape.RECTANGULAR &&
                    cargo == CargoType.PETROLEUM) {

                throw new CargoSafetyException(
                        "Unsafe Assignment: Petroleum cannot be loaded in RECTANGULAR bogie!"
                );
            }

            // Safe assignment
            bogie.setCargo(cargo);
            System.out.println("Cargo assigned successfully.");

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            System.out.println("Validation completed for Bogie: " + bogie.getBogieId());
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        CargoService service = new CargoService();

        GoodsBogie bogie1 = new GoodsBogie("B1", BogieShape.CYLINDRICAL);
        GoodsBogie bogie2 = new GoodsBogie("B2", BogieShape.RECTANGULAR);

        // Safe assignment
        service.assignCargo(bogie1, CargoType.PETROLEUM);

        // Unsafe assignment (handled)
        service.assignCargo(bogie2, CargoType.PETROLEUM);

        // Program continues after exception
        service.assignCargo(bogie2, CargoType.COAL);

        System.out.println("Program continues without crashing...");
    }
}
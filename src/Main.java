public class Main {

    // Bubble Sort Service
    static class PassengerService {

        // Bubble Sort Method
        public void sortCapacities(int[] arr) {
            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr[j] > arr[j + 1]) {
                        // Swap
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        // Display Method
        public void display(int[] arr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // ---------- TEST METHODS ----------

    static void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        PassengerService service = new PassengerService();
        service.sortCapacities(arr);

        System.out.print("Basic Sorting: ");
        service.display(arr); // Expected: 24 56 60 70 72
    }

    static void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        PassengerService service = new PassengerService();
        service.sortCapacities(arr);

        System.out.print("Already Sorted: ");
        service.display(arr);
    }

    static void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        PassengerService service = new PassengerService();
        service.sortCapacities(arr);

        System.out.print("Duplicate Values: ");
        service.display(arr);
    }

    static void testSort_SingleElementArray() {
        int[] arr = {50};
        PassengerService service = new PassengerService();
        service.sortCapacities(arr);

        System.out.print("Single Element: ");
        service.display(arr);
    }

    static void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        PassengerService service = new PassengerService();
        service.sortCapacities(arr);

        System.out.print("All Equal Values: ");
        service.display(arr);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        PassengerService service = new PassengerService();

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting:");
        service.display(capacities);

        service.sortCapacities(capacities);

        System.out.println("After Sorting:");
        service.display(capacities);

        System.out.println("\n--- Running Test Cases ---");

        testSort_BasicSorting();
        testSort_AlreadySortedArray();
        testSort_DuplicateValues();
        testSort_SingleElementArray();
        testSort_AllEqualValues();
    }
}
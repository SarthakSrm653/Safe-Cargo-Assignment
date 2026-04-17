import java.util.Arrays;

public class Main {

    // Service Class
    static class BogieService {

        // Sort using Arrays.sort()
        public void sortBogieNames(String[] bogies) {
            Arrays.sort(bogies);
        }

        // Display method
        public void display(String[] bogies) {
            System.out.println(Arrays.toString(bogies));
        }
    }

    // ---------- TEST METHODS ----------

    static void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        BogieService service = new BogieService();

        service.sortBogieNames(arr);

        System.out.print("Basic Sorting: ");
        service.display(arr);
        // Expected: [AC Chair, First Class, General, Luxury, Sleeper]
    }

    static void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        BogieService service = new BogieService();

        service.sortBogieNames(arr);

        System.out.print("Unsorted Input: ");
        service.display(arr);
    }

    static void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        BogieService service = new BogieService();

        service.sortBogieNames(arr);

        System.out.print("Already Sorted: ");
        service.display(arr);
    }

    static void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        BogieService service = new BogieService();

        service.sortBogieNames(arr);

        System.out.print("Duplicate Values: ");
        service.display(arr);
    }

    static void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        BogieService service = new BogieService();

        service.sortBogieNames(arr);

        System.out.print("Single Element: ");
        service.display(arr);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        BogieService service = new BogieService();

        String[] bogies = {"Sleeper","AC Chair","First Class","General","Luxury"};

        System.out.println("Before Sorting:");
        service.display(bogies);

        service.sortBogieNames(bogies);

        System.out.println("After Sorting:");
        service.display(bogies);

        System.out.println("\n--- Running Test Cases ---");

        testSort_BasicAlphabeticalSorting();
        testSort_UnsortedInput();
        testSort_AlreadySortedArray();
        testSort_DuplicateBogieNames();
        testSort_SingleElementArray();
    }
}
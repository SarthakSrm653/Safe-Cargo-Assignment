public class Main {

    // Service Class
    static class BogieSearchService {

        // Search with validation (Fail-Fast)
        public boolean searchBogie(String[] bogies, String key) {

            // 🔴 Validation: check empty
            if (bogies == null || bogies.length == 0) {
                throw new IllegalStateException("No bogies available. Cannot perform search.");
            }

            // Linear Search
            for (int i = 0; i < bogies.length; i++) {
                if (bogies[i].equals(key)) {
                    return true;
                }
            }

            return false;
        }
    }

    // ---------- TEST METHODS ----------

    static void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};
        BogieSearchService service = new BogieSearchService();

        try {
            service.searchBogie(arr, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Exception Test Passed: " + e.getMessage());
        }
    }

    static void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG101");
        System.out.println("Search Allowed: " + result); // true
    }

    static void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG205");
        System.out.println("Bogie Found: " + result); // true
    }

    static void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        BogieSearchService service = new BogieSearchService();

   import java.util.Arrays;

        public class Main {

            // Service Class
            static class BogieBinarySearchService {

                // Binary Search Method
                public boolean binarySearch(String[] bogies, String key) {

                    // Handle empty array
                    if (bogies == null || bogies.length == 0) {
                        return false;
                    }

                    // Ensure sorted (important precondition)
                    Arrays.sort(bogies);

                    int low = 0;
                    int high = bogies.length - 1;

                    while (low <= high) {

                        int mid = (low + high) / 2;

                        int cmp = key.compareTo(bogies[mid]);

                        if (cmp == 0) {
                            return true; // found
                        }
                        else if (cmp < 0) {
                            high = mid - 1; // search left
                        }
                        else {
                            low = mid + 1; // search right
                        }
                    }

                    return false; // not found
                }

                // Display array
                public void display(String[] bogies) {
                    System.out.println(Arrays.toString(bogies));
                }
            }

            // ---------- TEST METHODS ----------

            static void testBinarySearch_BogieFound() {
                String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
                boolean result = new BogieBinarySearchService().binarySearch(arr, "BG309");
                System.out.println("Found Test: " + result); // true
            }

            static void testBinarySearch_BogieNotFound() {
                String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
                boolean result = new BogieBinarySearchService().binarySearch(arr, "BG999");
                System.out.println("Not Found Test: " + result); // false
            }

            static void testBinarySearch_FirstElementMatch() {
                String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
                boolean result = new BogieBinarySearchService().binarySearch(arr, "BG101");
                System.out.println("First Element: " + result); // true
            }

            static void testBinarySearch_LastElementMatch() {
                String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
                boolean result = new BogieBinarySearchService().binarySearch(arr, "BG550");
                System.out.println("Last Element: " + result); // true
            }

            static void testBinarySearch_SingleElementArray() {
                String[] arr = {"BG101"};
                boolean result = new BogieBinarySearchService().binarySearch(arr, "BG101");
                System.out.println("Single Element: " + result); // true
            }

            static void testBinarySearch_EmptyArray() {
                String[] arr = {};
                boolean result = new BogieBinarySearchService().binarySearch(arr, "BG101");
                System.out.println("Empty Array: " + result); // false
            }

            static void testBinarySearch_UnsortedInputHandled() {
                String[] arr = {"BG309","BG101","BG550","BG205","BG412"};
                boolean result = new BogieBinarySearchService().binarySearch(arr, "BG205");
                System.out.println("Unsorted Input: " + result); // true
            }

            // ---------- MAIN METHOD ----------
            public static void main(String[] args) {

                BogieBinarySearchService service = new BogieBinarySearchService();

                String[] bogies = {"BG309","BG101","BG550","BG205","BG412"};
                String key = "BG205";

                System.out.println("Before Sorting:");
                service.display(bogies);

                boolean found = service.binarySearch(bogies, key);

                System.out.println("After Sorting:");
                service.display(bogies);

                if (found) {
                    System.out.println("Bogie Found!");
                } else {
                    System.out.println("Bogie Not Found!");
                }

                System.out.println("\n--- Running Test Cases ---");

                testBinarySearch_BogieFound();
                testBinarySearch_BogieNotFound();
                testBinarySearch_FirstElementMatch();
                testBinarySearch_LastElementMatch();
                testBinarySearch_SingleElementArray();
                testBinarySearch_EmptyArray();
                testBinarySearch_UnsortedInputHandled();
            }
        }
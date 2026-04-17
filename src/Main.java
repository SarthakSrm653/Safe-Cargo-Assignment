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

        boolean result = service.searchBogie(arr, "BG999");
        System.out.println("Bogie Not Found: " + result); // false
    }

    static void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG101");
        System.out.println("Single Element Search: " + result); // true
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        BogieSearchService service = new BogieSearchService();

        String[] bogies = {"BG101","BG205","BG309"};

        String searchKey = "BG205";

        try {
            boolean found = service.searchBogie(bogies, searchKey);

            if (found) {
                System.out.println("Bogie Found!");
            } else {
                System.out.println("Bogie Not Found!");
            }

        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Running Test Cases ---");

        testSearch_ThrowsExceptionWhenEmpty();
        testSearch_AllowsSearchWhenDataExists();
        testSearch_BogieFoundAfterValidation();
        testSearch_BogieNotFoundAfterValidation();
        testSearch_SingleElementValidCase();
    }
}
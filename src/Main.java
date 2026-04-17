public class Main {

    // Service Class
    static class BogieSearchService {

        // Linear Search Method
        public boolean searchBogie(String[] bogies, String key) {

            for (int i = 0; i < bogies.length; i++) {

                if (bogies[i].equals(key)) {
                    return true; // found
                }
            }

            return false; // not found
        }
    }

    // ---------- TEST METHODS ----------

    static void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG309");

        System.out.println("Bogie Found Test: " + result); // true
    }

    static void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG999");

        System.out.println("Bogie Not Found Test: " + result); // false
    }

    static void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG101");

        System.out.println("First Element Match: " + result); // true
    }

    static void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG550");

        System.out.println("Last Element Match: " + result); // true
    }

    static void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        BogieSearchService service = new BogieSearchService();

        boolean result = service.searchBogie(arr, "BG101");

        System.out.println("Single Element Test: " + result); // true
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        BogieSearchService service = new BogieSearchService();

        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        System.out.println("Searching for: " + searchKey);

        boolean found = service.searchBogie(bogies, searchKey);

        if (found) {
            System.out.println("Bogie Found!");
        } else {
            System.out.println("Bogie Not Found!");
        }

        System.out.println("\n--- Running Test Cases ---");

        testSearch_BogieFound();
        testSearch_BogieNotFound();
        testSearch_FirstElementMatch();
        testSearch_LastElementMatch();
        testSearch_SingleElementArray();
    }
}
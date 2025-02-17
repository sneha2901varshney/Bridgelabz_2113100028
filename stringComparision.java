package AssignmentRuntimeAnalysis;
public class stringComparision {

    public static void main(String[] args) {
        int n = 1000000;

        long startTime = System.currentTimeMillis();
        testStringConcatenation(n);
        long endTime = System.currentTimeMillis();
        System.out.println("String concatenation time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        testStringBuilderConcatenation(n);
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder concatenation time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        testStringBufferConcatenation(n);
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer concatenation time: " + (endTime - startTime) + "ms");
    }

    public static void testStringConcatenation(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a";
        }
    }

    public static void testStringBuilderConcatenation(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }

    public static void testStringBufferConcatenation(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }
}

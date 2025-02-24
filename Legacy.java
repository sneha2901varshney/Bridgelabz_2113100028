package AssignmentAnnotations;

class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("Warning: This feature is deprecated and should not be used.");
    }

    void newFeature() {
        System.out.println("This is the new feature.");
    }
}

public class Legacy {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}


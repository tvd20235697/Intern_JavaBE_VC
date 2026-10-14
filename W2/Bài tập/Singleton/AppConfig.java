public class AppConfig {
    private static AppConfig instance;
    private AppConfig() {
        System.out.println("AppConfig created");
    }
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
}

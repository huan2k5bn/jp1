public class TooColdException extends TemperatureException {
    public TooColdException(int temperature) {
        super("Coffee is too cold! Temperature: " + temperature + "°C");
    }
}

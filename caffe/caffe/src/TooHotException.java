public class TooHotException extends TemperatureException {
    public TooHotException(int temperature) {
        super("Coffee is too hot! Temperature: " + temperature + "°C");
    }
}

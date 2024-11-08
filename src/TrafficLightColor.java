public enum TrafficLightColor {
    RED,
    YELLOW,
    GREEN;

    public String getAction() {
        switch (this) {
            case RED:
                return "STOP";
            case YELLOW:
                return "GET READY";
            case GREEN:
                return "GO";
            default:
                return "";
        }
    }
}

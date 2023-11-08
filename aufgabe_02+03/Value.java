public final class Value extends Trip {
    private final String value;

    public Value(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.value;
    }
}
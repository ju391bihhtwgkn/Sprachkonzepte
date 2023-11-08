public final class Line extends Trip {
    public final String value;
    public final Trip right;

    public Line(String value, Trip right) {
        this.value = value;
        this.right = right;
    }



    @Override
    public String toString() {
        return this.value + this.right;
    }
}
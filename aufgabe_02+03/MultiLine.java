public final class MultiLine extends Trip {
    public final String newline;
    public final Trip value;
    public final Trip right;

    //next multiline
    public MultiLine(String newline, Trip value, Trip right) {
        this.newline = newline;
        this.value = value;
        this.right = right;
    }

    //last multiline
    public MultiLine(String newline, Trip value) {
        this.newline = newline;
        this.value = value;
        this.right = null;
    }

    @Override
    public String toString() {
        if (right == null) {
            return this.newline + this.value;
        } else {
            return this.newline + this.value + this.right;
        }
    }
}
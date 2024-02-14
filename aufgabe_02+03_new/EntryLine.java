class EntryLine implements Line {
    private final String title;
    private final String entry;

    public String getTitle() {
        return title;
    }

    public String getEntry() {
        return entry;
    }

    public EntryLine(String title, String entry) {
        this.title = title;
        this.entry = entry;
    }

    @Override
    public boolean check() {
        return entry.length() < 51;
    }
}
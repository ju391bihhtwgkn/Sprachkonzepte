import java.time.LocalDate;
import java.util.List;

class Trip {
    private final List<Line> lines;

    public Trip(List<Line> lines) {
        this.lines = lines;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trip:\n");
        for (Line line : lines) {
            sb.append("  ").append(line).append("\n");
        }

        // Simplified tree printing with line types
        sb.append("\nParse Tree:\n");
        for (Line line : lines) {
            if (line instanceof DateLine dateLine) {
                sb.append("  DateLine: ").append(dateLine.getTitle()).append(" (").append(dateLine.getDate()).append(")\n");
            } else if (line instanceof EntryLine entryLine) {
                sb.append("  EntryLine: ").append(entryLine.getTitle()).append(" (").append(entryLine.getEntry()).append(")\n");
            }
        }

        return sb.toString();
    }


    public LocalDate findTripStartDate() {
        LocalDate smallestDate = null;

        for (Line line : lines) {
            if (line instanceof DateLine dateLine) {
                LocalDate date = dateLine.getDateAsLocalDate();

                if (smallestDate == null || date.isBefore(smallestDate)) {
                    smallestDate = date;
                }
            }
        }

        return smallestDate;
    }

}

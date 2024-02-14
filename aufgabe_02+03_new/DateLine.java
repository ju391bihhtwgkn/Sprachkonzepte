
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class DateLine implements Line {
    private final String title;
    private final String date;

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public DateLine(String title, String date) {
        this.title = title;
        this.date = date;
    }

    @Override
    public boolean check() {
        return true;
    }

    DateTimeFormatter dayMonthYearFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter dayMonthYearShortYearFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    DateTimeFormatter dayMonthShortYearFormatter2 = DateTimeFormatter.ofPattern("d/M/yyyy");
    DateTimeFormatter dayMonthShortYearFormatter3 = DateTimeFormatter.ofPattern("d/M/yy");

    public LocalDate getDateAsLocalDate() {
        DateTimeFormatter formatter = null;
        if (date.matches("^\\d{2}/\\d{2}/\\d{4}$")) { //dd/MM/yyyy
            formatter = dayMonthYearFormatter;
        } else if (date.matches("^\\d{2}/\\d{2}/\\d{2}$")) { //  dd/MM/yy
            formatter = dayMonthYearShortYearFormatter;
        } else if (date.matches("^\\d{1,2}/\\d{1,2}/\\d{4}$")) { // d/M/yyyy
            formatter = dayMonthShortYearFormatter2;
        } else if (date.matches("^\\d{1,2}/\\d{1,2}/\\d{2}$")) { //  d/M/yy
            formatter = dayMonthShortYearFormatter3;
        } else {
            throw new InvalidDateFormatException("Invalides Datumsformat: " + date);
        }

        return LocalDate.parse(date, formatter);
    }

}

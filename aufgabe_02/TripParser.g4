parser grammar TripParser;

options {
    tokenVocab = TripLexer;
}

trip: tripTitle travelDates destination purpose;

tripTitle: TRIP_TITLE ENTRY;
travelDates: TRAVEL_DATES departureDate returnDate;
destination: DESTINATION city country;
purpose: PURPOSE_TITLE ENTRY;

date: DAY MONTH YEAR;
departureDate: DEPARTURE_DATE date;
returnDate: RETURN_DATE date;

city: CITY ENTRY;
country: COUNTRY ENTRY;

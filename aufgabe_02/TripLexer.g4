lexer grammar TripLexer;

TRIP_TITLE: 'Trip Title:' ;
TRAVEL_DATES: 'Travel Dates:' ;
DEPARTURE_DATE: 'Departure Date:' ;
RETURN_DATE: 'Return Date:' ;
DESTINATION: 'Destination:' ;
CITY: 'City:' ;
COUNTRY: 'Country:' ;
PURPOSE_TITLE: 'Purpose of Trip:' ;

ENTRY: [ \t]* '[' ~[\r\n]* ']';

DAY: '0'[1-9] | [1-2][0-9] | '3'[0-1];
MONTH: MINUS '0'[1-9] MINUS | MINUS '1'[0-2] MINUS;
YEAR: '20'[0-9][0-9];
MINUS: '-' ;

NEWLINE: ( '\r'? '\n' | '\r' ) -> skip;

WS: [ \t]+ -> skip;

OTHER: . -> skip;

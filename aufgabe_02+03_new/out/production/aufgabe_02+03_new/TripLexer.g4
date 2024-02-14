lexer grammar TripLexer;

TITLE: [a-zA-Z]+ ':';
ENTRY: '[' [a-zA-Z ]+ '.'?']';
DATE: [0-9]+ '/' [0-9]+ '/' [0-9]+;
WS: [ \t\r]+ -> channel(HIDDEN);
NEWLINE: [\n]+;
OTHER: . -> skip;
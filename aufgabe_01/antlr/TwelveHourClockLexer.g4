// ExprLexer.g4
lexer grammar TwelveHourClockLexer;


Clock: Normal | Noon | Midnight ;

fragment Normal: Hour ':' Minute ' ' Meridiem ;
fragment Noon: 'Noon' | '12 noon' ;
fragment Midnight: 'Midnight' | '12 midnight' ;

fragment Hour: '1'[0-2]|'0'[1-9] ;
fragment Minute: [0-5][0-9] ;
fragment Meridiem: 'p.m.' | 'a.m.' ;

WS: [ \t\r\n]+ -> channel(HIDDEN);


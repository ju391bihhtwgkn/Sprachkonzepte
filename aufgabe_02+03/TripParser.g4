parser grammar TripParser;

options {
    tokenVocab = TripLexer;
}

start: line EOF;
line: value multiline;
multiline: NEWLINE value multiline | NEWLINE value;
value: (TITLE ( DATE | ENTRY ));
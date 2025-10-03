grammar DiceNotation;


/**
 * Rules.
 */

input_
    : operation EOF
    ;

operation
    : value (OPERATOR value)?
    | operation OPERATOR value
    ;

value
    : staticVal
    | dice
    ;

dice
    : nrdice? DSEPARATOR faceAndModifier
    ;

staticVal
    : NUMB+
    ;

nrdice
    : NUMB+
    ;

faceAndModifier
    : (DSEPARATOR+|LETTER+|COMP+|NUMB+)+
    ;

/**
 * Tokens.
 */

// Dice markers

DSEPARATOR: ( 'd' | 'D');

NUMB: ('0' ..'9');

LETTER: ('a'..'c'|'e'..'z'|'A'..'C'|'E'..'Z');
COMP: ('>'|'<'|'=');

// Operation tokens

OPERATOR: ('+'|'-'|'*'|'/');

LPAREN: '(';

RPAREN: ')';

// Skippable tokens

WS: [\t\r\n]+ -> skip;
WSPACE: ' ' -> skip;


lexer grammar PocketLexer;

LEFT_PAREN              : '(' ;
RIGHT_PAREN             : ')' ;
LEFT_BRACKET            : '[' ;
RIGHT_BRACKET           : ']' ;
LEFT_BRACE              : '{' ;
RIGHT_BRACE             : '}' ;

COLON                   : ':' ;
COMMA                   : ',' ;
SEMICOLON               : ';' ;
EQUALS                  : '=' ;
ARROW                   : '->' ;
FAT_ARROW               : '=>' ;

PLUS                    : '+' ;
MINUS                   : '-' ;
ASTERISK                : '*' ;
SLASH                   : '/' ;
PERCENT                 : '%' ;
NOT                     : '!' ;
AND                     : '&&' ;
OR                      : '||' ;
CARET                   : '^' ;
TILDE                   : '~'  ;
AMPERSAND               : '&' ;
BAR                     : '|' ;
EQUAL_EQUALS            : '==' ;
NOT_EQUALS              : '!=' ;
LESS_THAN               : '<' ;
LESS_THAN_EQUALS        : '<=' ;
GREATER_THAN            : '>' ;
GREATER_THAN_EQUALS     : '>=' ;

DOT : '.' ;

// Keywords
VAL                     : 'val' ;
LET                     : 'let' ;
IF                      : 'if' ;
ELSE                    : 'else' ;
LOOP                    : 'loop' ;
TRADE                   : 'trade' ;
IMPORT                  : 'import' ;
EXPORT                  : 'export' ;
BREAK                   : 'break' ;
YIELD                   : 'yield' ;
NATIVE                  : 'native' ;

TRUE                    : 'true' ;
FALSE                   : 'false' ;

None                    : 'none' ;

// Literals
INT_LITERAL             : '0' | [1-9] [0-9]* ;
FLOAT_LITERAL           : [0-9]+ '.' [0-9]* ([eE] [+-]? [0-9]+)?
                        | '.' [0-9]+ ([eE] [+-]? [0-9]+)?
                        | [0-9]+ [eE] [+-]? [0-9]+
                        ;
STRING_LITERAL          : '"' (~["\\] | '\\' .)* '"' ;

// Identifiers
ID                      : [a-zA-Z_][a-zA-Z0-9_]* ;

// Whitespace & Comments
WHITE_SPACE             : [ \t\r\n]+ -> skip ;
LINE_COMMENT            : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT           : '/*' .*? '*/' -> skip ;

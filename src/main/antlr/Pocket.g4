grammar Pocket;

program             : (stmt)* (expr)? EOF;

// Operators
equalityOp          : EQUAL_EQUALS | NOT_EQUALS ;
relationalOp        : LESS_THAN | GREATER_THAN | LESS_THAN_EQUALS | GREATER_THAN_EQUALS ;
additiveOp          : PLUS | MINUS ;
multiplicativeOp    : ASTERISK | SLASH | PERCENT ;
unaryOp             : NOT | MINUS ;

// Statements
stmt                : expr SEMICOLON                                          # ExprStmt
                    | ( VAL | LET ) ID ( COLON type )? EQUALS expr SEMICOLON  # DeclStmt
                    ;

// Unary/Binary operations
expr                : pipeExpr ;
pipeExpr            : logicOrExpr ( ARROW logicOrExpr )*;
logicOrExpr         : logicAndExpr ( OR logicAndExpr )* ;
logicAndExpr        : equalityExpr ( AND equalityExpr )* ;
equalityExpr        : relationalExpr ( equalityOp relationalExpr )* ;
relationalExpr      : additiveExpr ( relationalOp additiveExpr )* ;
additiveExpr        : multiplicativeExpr ( additiveOp multiplicativeExpr )* ;
multiplicativeExpr  : unaryExpr ( multiplicativeOp unaryExpr )* ;
unaryExpr           : unaryOp unaryExpr | postfixExpr;

// Primary Expression
primaryExpr         : ID                                # idExpr
                    | INT_LITERAL                       # intLiteralExpr
                    | FLOAT_LITERAL                     # floatLiteralExpr
                    | STRING_LITERAL                    # stringLiteralExpr
                    | fn                                # fnExpr
                    | if                                # ifExpr
                    | LOOP expr                         # loopExpr
                    | IMPORT STRING_LITERAL             # importExpr
                    | LEFT_PAREN expr RIGHT_PAREN       # parenExpr
                    ;

// Call expression
postfixExpr     : primaryExpr (LEFT_PAREN argList? RIGHT_PAREN)* ;
argList         : expr (COMMA expr)* ;

// Type (maybe expand in the future)
type            : ID ;

// Function declaration expression
param           : ID (COLON type)? ;
paramList       : param (COMMA param)*;
fn              : (TRADE)? LEFT_BRACE (paramList FAT_ARROW)? (stmt)* expr RIGHT_BRACE;

// If-else expression
if              : IF LEFT_PAREN expr RIGHT_PAREN expr (ELSE expr)? ;

// Lexer Rules
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

DECREMENT               : '--' ;
INCREMENT               : '++' ;
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
NOT_EQUALS              : '!=' ;
EQUAL_EQUALS            : '==' ;
LESS_THAN               : '<' ;
LESS_THAN_EQUALS        : '<=' ;
GREATER_THAN            : '>' ;
GREATER_THAN_EQUALS     : '>=' ;

VAL                     : 'val' ;
LET                     : 'let' ;
IF                      : 'if' ;
ELSE                    : 'else' ;
LOOP                    : 'loop' ;
TRADE                   : 'trade' ;
IMPORT                  : 'import';
EXPORT                  : 'export' ;

// Literals
INT_LITERAL             : [0-9]+ ;
FLOAT_LITERAL           : [0-9]+ '.' [0-9]+ ;
STRING_LITERAL          : '"' (~["\\] | '\\' .)* '"' ;

// Identifiers
ID                      : [a-zA-Z_][a-zA-Z0-9_]* ;

// Whitespace & Comments
WHITE_SPACE             : [ \t\r\n]+ -> skip ;
LINE_COMMENT            : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT           : '/*' .*? '*/' -> skip ;

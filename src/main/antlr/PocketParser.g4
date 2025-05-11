parser grammar PocketParser;

options {
    tokenVocab=PocketLexer;
}

moduleFn            : (stmt)* (expr)? EOF;

// Operators
equalityOp          : EQUAL_EQUALS | NOT_EQUALS ;
relationalOp        : LESS_THAN | GREATER_THAN | LESS_THAN_EQUALS | GREATER_THAN_EQUALS ;
additiveOp          : PLUS | MINUS ;
multiplicativeOp    : ASTERISK | SLASH | PERCENT ;
unaryOp             : NOT | MINUS ;

// Declaration keyword
decl                : VAL | LET ;

// Destructing list
destructuringList   : LEFT_BRACKET (ID (COMMA ID)*)? RIGHT_BRACKET ;

// Statements
stmt                : expr SEMICOLON                                           # ExprStmt
                    | (EXPORT)? decl ID ( COLON type )? EQUALS expr SEMICOLON  # DeclStmt
                    | (EXPORT)? decl destructuringList EQUALS expr SEMICOLON   # DestructingStmt
                    | ID EQUALS expr SEMICOLON                                 # AssgnStmt
                    | BREAK IF expr SEMICOLON                                  # BreakStmt
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
primaryExpr         : ID                                                    # idExpr
                    | INT_LITERAL                                           # intLiteralExpr
                    | FLOAT_LITERAL                                         # floatLiteralExpr
                    | STRING_LITERAL                                        # stringLiteralExpr
                    | lambda                                                # fnExpr
                    | IF LEFT_PAREN expr RIGHT_PAREN expr (ELSE expr)?      # ifExpr
                    | LOOP expr                                             # loopExpr
                    | IMPORT STRING_LITERAL                                 # importExpr
                    | LEFT_PAREN expr RIGHT_PAREN                           # parenExpr
                    ;

// Call expression
postfixExpr     : primaryExpr (LEFT_PAREN argList? RIGHT_PAREN)* ;
argList         : expr (COMMA expr)* ;

// Type (maybe expand in the future)
type            : ID ;

// Lambda expression
param           : ID (COLON type)? ;
paramList       : param (COMMA param)*;
lambda          : (TRADE)? LEFT_BRACE (paramList FAT_ARROW)? (stmt)* (expr)? RIGHT_BRACE;

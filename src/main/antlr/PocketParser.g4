parser grammar PocketParser;

options {
    tokenVocab=PocketLexer;
}

moduleFn            : (stmt)* (expr)? EOF;

// Operators
pipeOp              : ARROW ;
logicOrOp           : OR ;
logicAndOp          : AND ;
equalityOp          : EQUAL_EQUALS | NOT_EQUALS ;
relationalOp        : LESS_THAN | GREATER_THAN | LESS_THAN_EQUALS
                    | GREATER_THAN_EQUALS
                    ;
additiveOp          : PLUS | MINUS ;
multiplicativeOp    : ASTERISK | SLASH | PERCENT ;
unaryOp             : NOT | MINUS ;

// Declaration keyword
decl                : VAL | LET ;

// Destructing list
destructuringList   : LEFT_BRACKET (ID (COMMA ID)*)? RIGHT_BRACKET ;

// Statements
stmt                : expr SEMICOLON                                             # ExprStmt
                    | (EXPORT)? decl ID ( COLON type )? EQUALS expr SEMICOLON    # DeclStmt
                    | (EXPORT)? decl destructuringList EQUALS expr SEMICOLON     # DestructingStmt
                    | ID EQUALS expr SEMICOLON                                   # AssgnStmt
                    | BREAK IF expr SEMICOLON                                    # BreakStmt
                    | NATIVE VAL ID (COLON type)? SEMICOLON                      # NativeStmt
                    ;

// Unary/Binary operations
expr                : pipeExpr ;
pipeExpr            : logicOrExpr ( pipeOp logicOrExpr )*;
logicOrExpr         : logicAndExpr ( logicOrOp logicAndExpr )* ;
logicAndExpr        : equalityExpr ( logicAndOp equalityExpr )* ;
equalityExpr        : relationalExpr ( equalityOp relationalExpr )* ;
relationalExpr      : additiveExpr ( relationalOp additiveExpr )* ;
additiveExpr        : multiplicativeExpr ( additiveOp multiplicativeExpr )* ;
multiplicativeExpr  : unaryExpr ( multiplicativeOp unaryExpr )* ;
unaryExpr           : unaryOp unaryExpr | postfixExpr;

// List and object elements
listElementList     : expr (COMMA expr)* COMMA?;
objectElementList   : ID COLON expr (COMMA ID COLON expr)* COMMA?;

// Primary Expression
primaryExpr         : INT_LITERAL                                                # intLiteralExpr
                    | FLOAT_LITERAL                                              # floatLiteralExpr
                    | (TRUE | FALSE)                                             # boolExpr
                    | STRING_LITERAL                                             # stringLiteralExpr
                    | ID                                                         # idExpr
                    | LEFT_BRACKET RIGHT_BRACKET                                 # emptyListExpr
                    | LEFT_BRACKET objectElementList RIGHT_BRACKET               # objectExpr
                    | LEFT_BRACKET listElementList RIGHT_BRACKET                 # listExpr
                    | lambda                                                     # lambdaExpr
                    | IF LEFT_PAREN expr RIGHT_PAREN expr (ELSE expr)?           # ifExpr
                    | LOOP expr                                                  # loopExpr
                    | YIELD expr expr expr expr                                  # yieldExpr
                    | IMPORT LESS_THAN targetPath GREATER_THAN                   # importExpr
                    | LEFT_PAREN expr RIGHT_PAREN                                # parenExpr
                    ;

// Postfix expression
postfixExpr         : (AMPERSAND)? primaryExpr postfixPart* (lambda)? ;
postfixPart         : DOT ID                                                     # postfixMemberAccess
                    | LEFT_PAREN argList RIGHT_PAREN                             # postfixCall
                    ;
argList             : expr (COMMA expr)* ;

// Type (maybe expand in the future)
// typeParamList   : type (COMMA type)* ;
type            : ID;
//type            : ID                                                                # idTypeExpr
//                | LEFT_PAREN (typeParamList)? RIGHT_PAREN FAT_ARROW (type | VOID)   # lambdaTypeExpr
//                ;

// Lambda expression
param               : ID (COLON type)? ;
paramList           : param (COMMA param)*;
lambda              : (TRADE)? LEFT_BRACE (paramList FAT_ARROW)?
                      (stmt)* (expr)? RIGHT_BRACE;

targetPath          : ID ((SLASH | DOT) ID)* ;
grammar CalculatorExpression;

INT      : [0-9]+;
DECIMAL  : [0-9]+'.'[0-9]+;
IMAGINARY: [0-9]+'i';
BOOLEAN  : '0' '1';

PLUS : '+';
MINUS: '-';
MULT : '×';
DIV  : '/';
LOGICAL_NOT: 'NOT';
LOGICAL_OR: 'OR';
LOGICAL_AND: 'AND';
LOGICAL_XOR: 'XOR';
LOGICAL_IMPLICATION:'==>';
LOGICAL_EQUIVALENCE:'<==>';


expression: term;

parenthesed_expression: '(' expression ')';

term: factor
    | term PLUS factor
    | term MINUS factor
    | term LOGICAL_OR factor
    | term LOGICAL_AND factor
    | term LOGICAL_IMPLICATION factor
    | term LOGICAL_EQUIVALENCE factor
    | term LOGICAL_XOR factor
    | LOGICAL_NOT term
    ;

factor: value
      | factor MULT value
      | factor DIV value
      ;

value: number boolean
     | parenthesed_expression
     ;


number: MINUS?(INT|DECIMAL|IMAGINARY);
boolean: BOOLEAN;

WS : [ \t\r\n]+ -> skip; // ignore whitespaces
grammar CalculatorExpression;

INT      : [0-9]+;
DECIMAL  : [0-9]+'.'[0-9]+;
IMAGINARY: [0-9]+'i';

PLUS : '+';
MINUS: '-';
MULT : '*';
DIV  : '/';

expression: term;

parenthesed_expression: '(' expression ')';

term: factor
    | term PLUS factor
    | term MINUS factor
    ;

factor: value
      | factor MULT value
      | factor DIV value
      ;

value: number
     | parenthesed_expression
     ;

number: MINUS?(INT|DECIMAL|IMAGINARY);

WS : [ \t\r\n]+ -> skip; // ignore whitespaces
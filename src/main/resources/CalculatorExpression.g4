grammar CalculatorExpression;

INT : '-'?[0-9]+;

PLUS : '+';
MINUS: '-';
MULT : '*';
DIV  : '/';

expression: term;

term: factor;

factor: value;

value : INT;
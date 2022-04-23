grammar CalculatorExpression;

INT      : [0-9]+;
DECIMAL  : [0-9]+'.'[0-9]+;
IMAGINARY: [0-9]+'i';
BOOLEAN  : '0' '1';

PLUS : '+';
MINUS: '-';
MULT : '×';
DIV  : '/';
POW  : '^';

LOGICAL_NOT: 'NOT';
LOGICAL_OR: 'OR';
LOGICAL_AND: 'AND';
LOGICAL_XOR: 'XOR';
LOGICAL_IMPLICATION:'==>';
LOGICAL_EQUIVALENCE:'<==>';

FUNCTION_IDENTIFIER : [a-z]+;


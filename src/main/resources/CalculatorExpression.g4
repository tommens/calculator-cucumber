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


FUNCTION_IDENTIFIER : [a-z]+;

expression: term | function_defintion;

parenthesed_expression: '(' expression ')';

function_call: FUNCTION_IDENTIFIER '(' term ')';

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




function_defintion: FUNCTION_IDENTIFIER ':=' function_term;

function_function_call: FUNCTION_IDENTIFIER '(' function_term ')';

function_parenthesed_expression: '(' function_term ')';

function_term: function_factor
    | function_term PLUS function_factor
    | function_term MINUS function_factor
    ;

function_factor: function_value
      | function_factor MULT function_value
      | function_factor DIV function_value
      ;

function_value: number
     | variable
     | function_function_call
     | function_parenthesed_expression
     ;

variable: 'x';


WS : [ \t\r\n]+ -> skip; // ignore whitespaces
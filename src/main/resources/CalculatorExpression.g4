grammar CalculatorExpression;

INT      : [0-9]+;
DECIMAL  : [0-9]+'.'[0-9]+;
IMAGINARY: [0-9]*'i';

PLUS : '+';
MINUS: '-';
MULT : '×';
DIV  : '/';
POW  : '^';

FUNCTION_IDENTIFIER : [a-z]+;

expression: term | function_defintion;

parenthesed_expression: '(' expression ')';

function_call: FUNCTION_IDENTIFIER '(' term ')';

term: factor
    | term PLUS factor
    | term MINUS factor
    ;

factor: pow
      | factor MULT pow
      | factor DIV pow
      ;

pow: value
   | pow POW value
   ;

value: number
     | function_call
     | parenthesed_expression
     ;

number: MINUS?(INT|DECIMAL|IMAGINARY);

function_defintion: FUNCTION_IDENTIFIER ':=' function_term;

function_function_call: FUNCTION_IDENTIFIER '(' function_term ')';

function_parenthesed_expression: '(' function_term ')';

function_term: function_factor
             | function_term PLUS function_factor
             | function_term MINUS function_factor
             ;

function_factor: function_pow
               | function_factor MULT function_pow
               | function_factor DIV function_pow
               ;

function_pow: function_value
            | function_pow POW function_value
            ;

function_value: number
               | variable
               | function_function_call
               | function_parenthesed_expression
               ;

variable: 'x';


WS : [ \t\r\n]+ -> skip; // ignore whitespaces
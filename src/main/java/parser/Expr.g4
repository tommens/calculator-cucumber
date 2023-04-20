grammar Expr;

input : expr EOF;
expr  : prefixOperation
      | infixOperation
      | postfixOperation
      | num
      ;

prefixOperation : operator values;
infixOperation : values operator values
               | values operator infixOperation;
postfixOperation : values operator;

values : num
       | OPENBRACKET values CLOSEBRACKET
       | OPENBRACKET expr CLOSEBRACKET
       | values SEPARATOR values
       ;


operator: ('+')     #Plus
        | ('-')     #Minus
        | ('*')     #Times
        | ('/')     #Divides
        ;

num   : INT     #Integer
      | REAL    #Real
      | FRAC    #Fraction
      ;


OPENBRACKET : '(';
CLOSEBRACKET : ')';
SEPARATOR : ',';
INT : [0-9]+;
REAL  : [0-9]+[.][0-9]+('E'[+|-]?[0-9]+)?;
FRAC  : [0-9]+[_][0-9]+;
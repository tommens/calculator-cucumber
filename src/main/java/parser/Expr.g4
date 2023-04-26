grammar Expr;

input : expr EOF;
expr  : prefixOperation
      | infixOperation
      | postfixOperation
      | num
      ;

prefixOperation : operator values;
postfixOperation : values operator;

values : num
       | '(' values ')'
       | '(' expr ')'
       | values SEPARATOR values
       ;


operator: ('+')     #Plus
        | ('-')     #Minus
        | ('*')     #Times
        | ('/')     #Divides
        | ('%')     #Modulo
        | ('^')     #Power
        | ('gcd')   #GCD
        | ('lcm')   #LCM
        ;


/* Infix operation
   Grammar from the compilation course
*/
infixOperation : e;
e : t e2 #StartValueInfix;
e2 : '+' t e2       #InfixPlus
   | '-' t e2       #InfixMinus
   | /* epsilon */  #Void
   ;
t : f t2    #SecondValueInfix;
t2 : '*' f t2       #InfixTimes
   | '/' f t2       #InfixDivides
   | /* epsilon */  #Void2
   ;
f : num
  | '(' expr ')'
  ;

num   : INT     #Integer
      | REAL    #Real
      | FRAC    #Fraction
      ;

SEPARATOR : ',';
INT : [0-9]+;
REAL  : [0-9]+[.][0-9]+('E'[+|-]?[0-9]+)?;
FRAC  : [0-9]+[_][0-9]+;
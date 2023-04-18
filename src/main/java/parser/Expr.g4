grammar Expr;

input : expr EOF;
expr  : expr ('+') expr     #Addition
      | expr ('-') expr     #Subtraction
      | expr ('*') expr     #Multiplication
      | expr ('/') expr     #Division
      | num                 #Number
      ;

num   : INT     #Integer
      | REAL    #Real
      | FRAC    #Fraction
      ;

INT : [0-9]+;
REAL  : [0-9]+[.][0-9]+;
FRAC  : [0-9]+[_][0-9]+;
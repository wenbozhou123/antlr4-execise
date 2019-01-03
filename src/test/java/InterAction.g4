grammar InterAction;

@header{
    package test.antl4;
}

expression
    :     expr EOF   ;

expr:  expr (AND|OR) expr       # logicOperate
      | '(' expr ')'            # parents
      | STR (OPERATE) STR       # str
      ;


STR          : [ .a-zA-Z0-9]+ ;
AND         : WS'&&'WS;
OR          : WS'||'WS ;
OPERATE     : ('=='|'!=') ;

WS: [ \t\r\n]* -> skip;
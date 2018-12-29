grammar InterAction;

@header{
    package com.interActionInbox;
}


expr: expr OPERATE expr         # assignOperate
      | expr (AND|OR) expr      # logicOperate
      | '(' expr ')'            # parents
      | STR                     # str
      ;

STR          : [ a-zA-Z0-9]|[ .a-zA-Z0-9]+ ;
AND         : WS'&&'WS;
OR          : WS'||'WS ;
OPERATE     : ('=='|'!=') ;

WS: [ \t\r\n]* -> skip;
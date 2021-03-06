grammar InterAction;

@header{
    package com.antlr4.interAction;
}


expr:  expr LogicOperation expr                    # logicOperate
      | LeftBracket expr RightBracket              # parents
      | STR AssignOperation STR                    # assignOperate
      ;

STR                : [ \.a-zA-Z0-9]+ ;
LogicOperation     : WS[|&]+WS;
AssignOperation    : WS[=!]+WS;
LeftBracket        : WS'(';
RightBracket       : ')'WS ;

WS: [ \t\r\n]* -> skip;
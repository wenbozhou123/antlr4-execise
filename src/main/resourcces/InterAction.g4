grammar InterAction;

@header{
    package com.interActionInbox;
}


expr:  expr LogicOperation expr                    # logicOperate
      |'(' expr ')'                                # parents
      | STR AssignOperation STR                    # assignOperate
      ;

STR                : [ a-zA-Z0-9]|[ .a-zA-Z0-9]+ ;
LogicOperation     : WS[|&]+WS;
AssignOperation    : WS[=!><^&%?]+WS;

WS: [ \t\r\n]* -> skip;
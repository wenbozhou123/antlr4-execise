// Generated from C:/maas/testCode/src/main/resourcces\InterAction.g4 by ANTLR 4.7

    package com.hp.ess.smgateway.antlr4.grammar.interActionInbox;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InterActionParser}.
 */
public interface InterActionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code str}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStr(InterActionParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code str}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStr(InterActionParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOperate}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicOperate(InterActionParser.LogicOperateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOperate}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicOperate(InterActionParser.LogicOperateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignOperate}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignOperate(InterActionParser.AssignOperateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignOperate}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignOperate(InterActionParser.AssignOperateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parents}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParents(InterActionParser.ParentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parents}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParents(InterActionParser.ParentsContext ctx);
}
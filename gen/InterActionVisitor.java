// Generated from C:/maas/testCode/src/main/resourcces\InterAction.g4 by ANTLR 4.7

    package com.hp.ess.smgateway.antlr4.grammar.interActionInbox;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InterActionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InterActionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code str}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(InterActionParser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicOperate}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOperate(InterActionParser.LogicOperateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignOperate}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignOperate(InterActionParser.AssignOperateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parents}
	 * labeled alternative in {@link InterActionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParents(InterActionParser.ParentsContext ctx);
}
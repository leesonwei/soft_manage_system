package com.dao;
import java.util.List;

import com.common.Assist;
import com.entity.TweiApiPara;

import org.apache.ibatis.annotations.Param;
/**
 * @Classname TweiApiPara
 * @Date FreeMarker template error (DEBUG mode; use RETHROW in production!):
The following has evaluated to null or missing:
==> Date  [in template "Dao.ftl" at line 10, column 12]

----
Tip: If the failing expression is known to be legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, or use <#if myOptionalVar??>when-present<#else>when-missing</#if>. (These only cover the last step of the expression; to cover the whole expression, use parenthesis: (myOptionalVar.foo)!myDefault, (myOptionalVar.foo)??
----

----
FTL stack trace ("~" means nesting-related):
	- Failed at: ${Date}  [in template "Dao.ftl" at line 10, column 10]
----

Java stack trace (for programmers):
----
freemarker.core.InvalidReferenceException: [... Exception message was already printed; see it above ...]
	at freemarker.core.InvalidReferenceException.getInstance(InvalidReferenceException.java:131)
	at freemarker.core.EvalUtil.coerceModelToString(EvalUtil.java:355)
	at freemarker.core.Expression.evalAndCoerceToString(Expression.java:82)
	at freemarker.core.DollarVariable.accept(DollarVariable.java:41)
	at freemarker.core.Environment.visit(Environment.java:324)
	at freemarker.core.MixedContent.accept(MixedContent.java:54)
	at freemarker.core.Environment.visit(Environment.java:324)
	at freemarker.core.Environment.process(Environment.java:302)
	at freemarker.template.Template.process(Template.java:325)
	at com.szmirren.common.CreateFileUtil.createFile(CreateFileUtil.java:69)
	at com.szmirren.controller.IndexController$2.call(IndexController.java:1115)
	at com.szmirren.controller.IndexController$2.call(IndexController.java:1059)
	at javafx.concurrent.Task$TaskCallable.call(Task.java:1423)
	at java.util.concurrent.FutureTask.run(Unknown Source)
	at java.lang.Thread.run(Unknown Source)

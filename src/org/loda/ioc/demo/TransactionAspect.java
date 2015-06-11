package org.loda.ioc.demo;

import java.lang.reflect.Method;

import org.loda.aop.advice.Before;
import org.loda.aop.advice.End;
import org.loda.aop.advice.Error;
import org.loda.ioc.annotation.Aspect;
import org.loda.ioc.annotation.Component;
import org.loda.ioc.annotation.Match;

/**
 * 
 * @ClassName: TransactionAspect
 * @Description: 事务处理的切面类
 * @author minjun
 * @date 2015年6月11日 上午9:52:23
 * 
 */
@Component
@Aspect
public class TransactionAspect implements Before, End, Error {

	@Match(classFilter = "org.loda.ioc.demo.AopDemo", methodMatch = "doSomething")
	@Override
	public void error(Method method, Object[] args, Exception e) {
		System.out.println("回滚事务");
	}

	@Match(classFilter = "org.loda.ioc.demo.AopDemo", methodMatch = "doSomething")
	@Override
	public void before(Method method, Object[] args) {
		System.out.println("开启事务");
	}

	@Match(classFilter = "org.loda.ioc.demo.AopDemo", methodMatch = "hehe")
	@Override
	public void end(Method method, Object[] args, Object retVal) {
		System.out.println("关闭事务");
	}

}

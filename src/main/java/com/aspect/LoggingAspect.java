package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect 
{
	//Only method can have advice
	
	
	//applied to only circle getName
	//@Before("execution(public String com.model.Circle.getName())")
	
	//this would applied to all the getName()
	//@Before("execution(public String getName())")
	
	//applied to all getter with this are called as wildcard the return type is also a wildcard
	//@Before("execution(public * get*())")
	
	//or
	@Before("allGetters()")
	
	//We can also do Logical operation
	//@Before("allGetters() && allCircleMethods()")
	
	//@Before("execution(* get*(*))")
	//function takes one or more arguments
	
	
	//@Before("execution(* get*(..))")
	//funtion takes zero or more arguments
	
	//joinpoint : means all the places in the code where we can apply advices
	public void loggingAdvice(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.toString());
		//System.out.println(joinPoint.getTarget());
	}
	
	//Pointcuts : All the points in the execution of our code
	//where we want any advice method
	//example : execution(public * get*())
	@Before("execution(public * get*())")
	public void secondAdvice()
	{
		System.out.println("Second Advice run");
	}
	
	//execution takes method names
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	
	//within takes class names
	/*pointcut only with a class that is circle class*/
	@Pointcut("within(com.model.Circle)")
	public void allCircleMethods()
	{
		
	}
	
	/*pointcut to all the class within a package*/
	@Pointcut("within(com.model.*)")
	public void allMethods()
	{
		
	}
	
	/* args*/
	//@Pointcut(args())
	
	@Before("args(name)")
	public void stringArgumentMethods(String name)
	{
		System.out.println("A method that takes string argument has been called.The value is " + name);
	}

}

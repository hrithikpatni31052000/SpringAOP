package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.ShapeService;

public class AppMain 
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("beans.xml file loaded");
		
	
		ShapeService shapeService = context.getBean("shapeService" , ShapeService.class);
		shapeService.getCircle().setName("TriangleABC");
		System.out.println(shapeService.getTriangle().getName());
	}

}

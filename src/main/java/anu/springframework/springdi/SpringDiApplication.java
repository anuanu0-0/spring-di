package anu.springframework.springdi;

import anu.springframework.springdi.controllers.ConstructorInjectedController;
import anu.springframework.springdi.controllers.MyController;
import anu.springframework.springdi.controllers.PropertyInjectedController;
import anu.springframework.springdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		/*
		* The Spring IoC container is responsible for managing the objects of an application.
		* It uses dependency injection to achieve inversion of control.
		* The interfaces BeanFactory and ApplicationContext represent the Spring IoC container.
		* Here, BeanFactory is the root interface for accessing the Spring container.
		* It provides basic functionalities for managing beans.
		* On the other hand, the ApplicationContext is a sub-interface of the BeanFactory.
		* Therefore, it offers all the functionalities of BeanFactory.
		* */
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println("-------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("--------- Property DI ");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter DI");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------- Constructor DI");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}

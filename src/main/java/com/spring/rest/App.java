package com.spring.rest;


import com.spring.rest.configuration.Config;
import com.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Communication communication = (Communication) context.getBean("communication");

        //All Emps
        List<Employee> allEmps = communication.getAllEmps();
        //Emp by Id
        Employee empById = communication.getEmployee(2);


        System.out.println(allEmps);
        System.out.println("--------------------------");
        System.out.println("Emp by Id " + empById);
        System.out.println("--------------------------");
        Employee newEmp = new Employee("TestUpdate","Chmeu","Finance",5000);
        communication.saveEmp(newEmp);
        System.out.println("--------------------------");
        Employee updEmp = new Employee("TestUpdate","Chmeu","Finance",5000);
        updEmp.setId(1);
        communication.saveEmp(updEmp);
        System.out.println("--------------------------");
        communication.deleteEmp(12);
        communication.deleteEmp(13);




    }

}

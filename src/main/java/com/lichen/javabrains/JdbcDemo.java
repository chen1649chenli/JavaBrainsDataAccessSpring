package com.lichen.javabrains;

import com.lichen.javabrains.dao.JdbcDaoImpl;
import com.lichen.javabrains.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
    public static void main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);

        System.out.println(dao.getCircleCount());
        System.out.println(dao.getCircleName(1));
        System.out.println(dao.getCircle(1).getName());
        System.out.println(dao.getALlCircle().size());
        dao.insertCircle(new Circle(3, "third circle"));
        System.out.println(dao.getALlCircle().size());
        //dao.createTriangleTable();
    }
}

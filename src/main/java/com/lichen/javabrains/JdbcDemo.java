package com.lichen.javabrains;

import com.lichen.javabrains.dao.JdbcDaoImpl;
import com.lichen.javabrains.model.Circle;

public class JdbcDemo {
    public static void main(String[] args){
        Circle circle = new JdbcDaoImpl().getCircle(1);
        System.out.println(circle.getName());
    }
}

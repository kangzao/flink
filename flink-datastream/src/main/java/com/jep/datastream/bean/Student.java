package com.jep.datastream.bean;

import lombok.Data;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/9 下午12:27
 */
@Data
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

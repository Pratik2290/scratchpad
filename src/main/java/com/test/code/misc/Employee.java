package com.test.code.misc;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    String name;
    int age;

    public Employee(String name,int age)
    {
        this.name=name;
        this.age=age;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Employee emp1=new Employee("Martin",27);
        Map<Employee,String> hm=new HashMap<Employee,String>();
        hm.put(emp1, "Verified");

        System.out.println(hm);


        emp1.setName("John");

        System.out.println(emp1);
        System.out.println(hm.get(emp1));

        System.out.println(hm);
    }
}

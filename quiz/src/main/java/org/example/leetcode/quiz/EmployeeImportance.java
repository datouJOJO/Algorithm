package org.example.leetcode.quiz;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: DiDi
 * @Description: something
 * @Data: 2024-04-24-15:45
 */
public class EmployeeImportance {

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(it -> it.id, it -> it));
        int res = 0;
        if (employeeMap.containsKey(id)) {
            Stack<Integer> stack = new Stack<>();
            stack.push(id);
            while(!stack.isEmpty()) {
                Employee employee = employeeMap.get(stack.pop());
                res += employee.importance;
                if (!employee.subordinates.isEmpty()) {
                    for (Integer subordinate : employee.subordinates) {
                        stack.push(subordinate);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Employee> employees;
        Employee employee1 = new Employee(1, 5);
        List<Integer> subordinates = new ArrayList<>();
        subordinates.add(2);
        subordinates.add(3);
        employee1.setSubordinates(subordinates);
        Employee employee2 = new Employee(2, 3);
        Employee employee3 = new Employee(3, 3);
        employees = Arrays.asList(employee1, employee2, employee3);
        System.out.println(getImportance(employees, 1));
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates = new ArrayList<>();

    public Employee(int id, int importance) {
        this.id = id;
        this.importance = importance;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
};
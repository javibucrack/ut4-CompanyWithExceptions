package org.iesfm;

import org.iesfm.exceptions.DepartmentNotFoundException;
import org.iesfm.exceptions.EmployeeNotFoundException;

public class Main {
    public static void main(String[] args) {
        Employee[] employees1 = {
                new Employee("12345678A", "Javier", "Peña", "Jefe"),
                new Employee("87654321B", "Paco", "Sanz", "EStf"),
                new Employee("12345678B", "Gomez", "Andrada", "Empleado")
        };
        Employee[] employees2 = {
                new Employee("12345678C", "Lorenzo", "Lopez", "Becario"),
                new Employee("87654321D", "Maria", "Sanchez", "Directora"),
                new Employee("12345678E", "Nerea", "Perez", "Empleada")
        };

        Department[] department1 = {
                new Department("Mercado", employees1),
                new Department("Comunicaciones", employees2)
        };


        Company company = new Company("Kompany", "34h6jb3h6b3", department1);

        try {
            Employee[] employees = company.getEmployeesByDepartment("Mercado");
            for (Employee employee : employees) {
                employee.showEmployee();
            }
        } catch (DepartmentNotFoundException e) {
            System.out.println("No se ha encontrado el departamento " + e.getDepartmentName());
        }
        System.out.println(" ");

        try {
            Department department = company.getDepartmentInfo("A");
            department.showDepartment();
        } catch (DepartmentNotFoundException e) {
            System.out.println("No se ha encontrado el departamento " + e.getDepartmentName());
        }
        System.out.println(" ");
        try {
            Employee employee = company.getEmployeeByNif("1234567A");
            employee.showEmployee();
        } catch (EmployeeNotFoundException e) {
            System.out.println("No se ha encontrado el empleado con el NIF: "+e.getNif());
        }
    }

}

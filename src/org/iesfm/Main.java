package org.iesfm;

import org.iesfm.exceptions.DepartmentNotFoundException;

public class Main {
    public static void main(String[] args) {
        Employee[] employees1 = {
                new Employee("12345678A", "Javier", "Peña", "Jefe"),
                new Employee("87654321B", "Xocas", "mmhvso", "esto no es un juego"),
                new Employee("12345678B", "Bicho", "Jr", "Extremo izquierdo")
        };
        Employee[] employees2 = {
                new Employee("12345678C", "Vini", "Ofisial", "carrito"),
                new Employee("87654321D", "Lio", "Messi", "pexofrio"),
                new Employee("12345678E", "Nerea", "Perez", "Romper todo")
        };

        Department[] department1 = {
                new Department("Mercado", employees1),
                new Department("sisissi", employees2)
        };


        Company company = new Company("AAAAAAAAAA", "34h6jb3h6b3", department1);

        try {
            Employee[] employees = company.getEmployeesByDepartment("Mercado");
            for (Employee employee : employees) {
                System.out.println(employee.getName());
            }
        } catch (DepartmentNotFoundException e) {

        }

        try {
            Department departments = company.getDepartmentInfo("sisissi");
        } catch (DepartmentNotFoundException e) {

        }
    }

}

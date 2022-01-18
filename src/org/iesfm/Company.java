package org.iesfm;

import org.iesfm.exceptions.DepartmentNotFoundException;
import org.iesfm.exceptions.EmployeeNotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class Company {
    private String name;
    private String cif;
    private Department[] departments;

    public Company(String name, String cif, Department[] departments) {
        this.name = name;
        this.cif = cif;
        this.departments = departments;
    }

    public Employee[] getEmployeesByDepartment(String departmentName) throws DepartmentNotFoundException {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department.getEmployees();
            }
        }
        throw new DepartmentNotFoundException();
    }

    public Department getDepartmentInfo(String departmentName) throws DepartmentNotFoundException {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        throw new DepartmentNotFoundException();
    }

    public Employee getEmployeeByNif(String nif) throws EmployeeNotFoundException {
        for (Department department : departments) {
            for (Employee employee:department.getEmployees()){
                if (employee.getNif().equals(nif)){
                    return employee;
                }
            }
        }
        throw new EmployeeNotFoundException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(cif, company.cif) && Arrays.equals(departments, company.departments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, cif);
        result = 31 * result + Arrays.hashCode(departments);
        return result;
    }
}

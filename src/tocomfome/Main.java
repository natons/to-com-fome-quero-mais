
package tocomfome;


import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import tocomfome.models.Employee;
import tocomfome.parsers.EmployeeParser;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeParser employeeParser = new EmployeeParser();

            List<Employee> employees = employeeParser.getEmployees();

            Iterator<Employee> employeeIterator = employees.iterator();

            while (employeeIterator.hasNext()) {
                Employee employee = employeeIterator.next();

                System.out.println("NAME    : " + employee.getName());
                System.out.println("LOGIN   : " + employee.getLogin());
                System.out.println("PASSWORD: " + employee.getPassword());
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

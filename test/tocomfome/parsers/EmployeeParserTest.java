/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tocomfome.parsers;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tocomfome.models.Employee;

public class EmployeeParserTest {
    private EmployeeParser employeeParser;

    @Before
    public void setUp() throws Exception {
        this.employeeParser = new EmployeeParser();
    }

    @Test
    public void shouldGiveAListOfEmployees() {
        List<Employee> employees = this.employeeParser.getEmployees();

        assertNotNull(employees);
        assertNotEquals(0, employees.size());
    }
}

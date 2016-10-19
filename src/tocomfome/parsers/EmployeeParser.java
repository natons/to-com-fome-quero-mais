package tocomfome.parsers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import tocomfome.models.Employee;


public class EmployeeParser extends DocumentParser {
    public EmployeeParser() throws ParserConfigurationException, IOException, FileNotFoundException, SAXException {
        super("employees_data");
    }


    public List<Employee> getEmployees() {
        final NodeList nodeList = super.getElements("employees");
        final List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); ++i) {
            final Element employeeElement = (Element) nodeList.item(i);

            final String name = employeeElement.getElementsByTagName("name").item(0).getTextContent();
            final String login = employeeElement.getElementsByTagName("login").item(0).getTextContent();
            final String password = employeeElement.getElementsByTagName("password").item(0).getTextContent();

            final Employee employee = new Employee(name, login, password);
            employees.add(employee);
        }

        return employees;
    }
}

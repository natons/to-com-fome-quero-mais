package test;

import controller.ControllerEmployee;
import junit.framework.TestCase;

public class Emoployee extends TestCase{
     public void testAuthenticate(){
        String login = "teste";
        String password = "123";
        boolean result = true;
        
        boolean resultMethod = new ControllerEmployee().authenticate(login, password);
        
        assertEquals(result, resultMethod);
    }
}

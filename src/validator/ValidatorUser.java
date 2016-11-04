package validator;

import model.User;

/*
    Classe responsável por validar campos referentes ao usuário
*/

public class ValidatorUser {
    
    //retorna true se o usuario existe, caso contrario retorna false
    public static boolean validatorUserLogin(User user){
        if(user.getLogin().equals("teste") && user.getPassword().equals("123"))
            return true;
        
        return false;
    }
}

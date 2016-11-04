package validator;

/*
    Classe responsável por validar campos de forma ampla
*/
public class Validator {
    //retorna false quando o campo está vazio, caso contrário retorna false;
    public static boolean validatorString(String string){
        if(string.trim().isEmpty())
            return false;
        
        return true;
    }
}

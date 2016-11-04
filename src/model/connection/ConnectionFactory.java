package model.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
    Classe de conexão com o Banco de Dados
*/
public class ConnectionFactory {

    /*
    retorna uma conexão com o banco de dados se bem sucedida
    caso não, retorna null
    */
    public EntityManagerFactory getConnection() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("toComFome");
        return factory;
    }
}

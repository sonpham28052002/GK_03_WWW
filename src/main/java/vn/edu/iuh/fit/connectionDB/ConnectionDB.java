package vn.edu.iuh.fit.connectionDB;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionDB {
    private EntityManagerFactory managerFactory;
    private static ConnectionDB connectionDB;

    public ConnectionDB() {
        managerFactory = Persistence.createEntityManagerFactory("default");
    }

    public static ConnectionDB getConnectionDB() {
        if (connectionDB == null)
            connectionDB = new ConnectionDB();
        return connectionDB;
    }

    public EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }
}

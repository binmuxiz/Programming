package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NConnectionMaker implements SimpleConnectionMaker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}

package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface SimpleConnectionMaker {

    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}

package com.example.springboot.Base;

import java.sql.*;
import java.util.Arrays;
import java.util.Vector;

public class FonctionBase {
    static int i=0,j=0;
    public static Connection connect() throws Exception {
        String url="jdbc:postgresql://mouse.db.elephantsql.com:5432/cegiqteg";
        String user="cegiqteg";
        String passWord="g2SFuVcUQh6JwCPJtPSFzEUODGF0l3HT";
        Connection connection;
        connection= DriverManager.getConnection(url,user,passWord);
        connection.setAutoCommit(true);
        return connection;
    }
    public static void modifBase(String sql) throws Exception{
        try (Connection connection = connect(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }
    public static Vector<Object>[]select(String sql) throws Exception{
        try (Connection connection = connect (); Statement statement = connection.createStatement (); ResultSet resultSet = statement.executeQuery (sql)) {
            return getAll (resultSet);
        }
    }
    public static void insert(Connection connection,String sql) throws SQLException {
        Statement statement=connection.createStatement ();
        statement.executeUpdate (sql);
        statement.close ();
    }
    public static Vector<Object>[] all(Connection connection,String sql) throws SQLException {
        try ( Statement statement = connection.createStatement (); ResultSet resultSet = statement.executeQuery (sql)) {
            return getAll (resultSet);
        }
    }

    private static Vector<Object>[] getAll (ResultSet resultSet) throws SQLException {
        int e = 0;
        int size = resultSet.getMetaData ().getColumnCount ();
        Vector<Object>[] valiny = new Vector[size];
        for (i = 0; i < size; i++) {
            valiny[i] = new Vector<Object> (10000);
        }
        while (resultSet.next ()) {
            for (i = 0; i < size; i++) {
                valiny[i].add (e, resultSet.getObject (i + 1));
            }
            e++;
        }
        return valiny;
    }

    public static void main(String[] args) throws Exception {
        String sql="select now()";
        System.out.println(Arrays.deepToString(select(sql)));
    }
}


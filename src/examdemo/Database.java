/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author roman
 */
public class Database {
    private static String user = "demo";
    private static String password = "Vm7BPGzP6yA2J9z6";
    private static String host = "test.digitalmikhail.ru";
    private static String databaseName = "app";
    
    private static boolean connected = false;
    
    private static Statement stmt;
    
    static public void connect() {
        String url = "jdbc:mysql://" + host + ":3306/" + databaseName;
        
        Properties properties = new Properties();
        
        // Свойства учетных данных
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        // Свойтсва локали/языка при работе с БД
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "cp1251");
        
        try {
            Connection connection = DriverManager.getConnection(url, properties);
            
            stmt = connection.createStatement();
            connected = true;
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка подключения к базе данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static boolean execute(String sql) {
        if(!connected)
            throw new NullPointerException("No connection");
        
        try {
            stmt.execute(sql);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static ArrayList<ArrayList<String>> query(String sql) {
        if(!connected)
            throw new NullPointerException("No connection");
        
        ArrayList<ArrayList<String>> returnValue = new ArrayList<>();
        
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            int columnCount = resultSet.getMetaData().getColumnCount();
            
            while(resultSet.next()) {
                ArrayList<String> row = new ArrayList<>();    
                
                for(int i = 0; i < columnCount; i++) {
                    row.add(resultSet.getString(i + 1));
                }
                
                returnValue.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnValue;
    }
}

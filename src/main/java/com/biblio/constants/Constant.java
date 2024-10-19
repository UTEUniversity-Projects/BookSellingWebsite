package com.biblio.constants;

public class Constant {
    private static String HOST_NAME = "localhost";
    private static String PORT = "3306";
    private static String DB_NAME = "bsw-biblio";
    public static final String DB_URL = "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DB_NAME;
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_MIN_CONNECTIONS = "2";
    public static final String DB_MAX_CONNECTIONS = "10";
    public static final String CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DB_NAME;

}

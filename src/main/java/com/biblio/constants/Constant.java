package com.biblio.constants;

public class Constant {
    private static String HOST_NAME = "mysql-11037dad-mysql-connection-pool.l.aivencloud.com";
    private static String PORT = "11334";
    private static String DB_NAME = "bsw-biblio";
    public static final String DB_URL = "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DB_NAME;
    public static final String USERNAME = "avnadmin";
    public static final String PASSWORD = "AVNS_81UTUxDOaC8KhVjDM9L";

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_MIN_CONNECTIONS = "2";
    public static final String DB_MAX_CONNECTIONS = "10";
    public static final String CONNECTION_URL = "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DB_NAME;

}

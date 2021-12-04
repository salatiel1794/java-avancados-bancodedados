
package DataBase;

public class MySQLDatabaseConnector implements DatabaseConnector {
    
    private String host;
    private String username;
    private String password;
    private String driver;
    
    //<editor-fold desc="singleton">
    private static MySQLDatabaseConnector instance = null;
    
    public static MySQLDatabaseConnector getInstance() {
        if (instance == null) {
            instance = new MySQLDatabaseConnector();
        }
        
        return instance;
    }

    /**
     * @param aInstance the instance to set
     */
    public static void setInstance(MySQLDatabaseConnector aInstance) {
        instance = aInstance;
    }

    @Override
    public void setCreadentials(String host, String username, String passsword, String driver) {
        this.driver = driver;
        this.host = host;
        this.password = password;
        this.username = username;
    }

    @Override
    public void connect() {
   }

    @Override
    public void disconnect() {
   }
    
}

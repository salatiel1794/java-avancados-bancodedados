
package DataBase;

public interface DatabaseConnector {
    
    public void setCreadentials(String host, String username, String passsword, String driver);
    
    public void connect();
    
    public void disconnect();
    
    
    
}

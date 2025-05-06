import java.rmi.*;

public interface AuthenticationServicesAI extends java.rmi.Remote {

    boolean authenticate(String username, String password) throws RemoteException;;
    boolean register(String username, String password) throws RemoteException;;

}

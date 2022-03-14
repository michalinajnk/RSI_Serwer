
import org.apache.xmlrpc.WebServer;

public class SerwerRPC {
    public static void main(String [] args){
       try{
           MyData.info();
           System.out.println("Startuje serwer XML-RPC...");
           int port= 10004;
           WebServer server= new WebServer(port);

           server.addHandler("MojSerwer", new SerwerRPC());
           server.start();
           System.out.println("Serwer wystartowal pomyslnie.");
           System.out.println("Nasluchuje na porcie: " + port);
           System.out.println("Aby zatrzymac serwer nacisnij ctrl+c");



       } catch(Exception exception){
           System.err.println("Serwer XML-RPC: " + exception);
       }

    }

    public int execAsy(int x){
        System.out.println("...wywolano asy -odliczam");
        try{
            Thread.sleep(x);
        } catch(InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("...asy - koniec odliczania");
        return(123);

    }
    public Integer echo(int x, int y){
        return Integer.valueOf(x+y);
    }


}


import org.apache.xmlrpc.WebServer;

import java.util.ArrayList;
import java.util.LinkedList;

public class SerwerRPC {
    private static int EARTH_RADIUS = 6371;

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

           testOfMethods();


       } catch(Exception exception){
           System.err.println("Serwer XML-RPC: " + exception);
       }

    }

    public static void testOfMethods(){

        System.out.println("Odległość między Krakowem a Wrocławiem");
        System.out.println(distance( 51.1,17.03, 50.0,19.9 )); //SZEROKOSC, DŁUGOSC

        System.out.println("Odległość między Kapsztadem a Warszawą");
        System.out.println(distance( -33.9,18.4, 52.2,21.0 )); //SZEROKOSC, DŁUGOSC

        System.out.println("Liczby pierwsze z przedziału: 1 9");
        //ArrayList pr = myPrimes(100,300);
        //System.out.println("ilosc: "+pr.get(0)+" najwieksza: "+pr.get(1));
        System.out.println(myPrimes(100,4000));

    }

    public static String myPrimes(int min, int max){
        LinkedList<Integer> primes = new LinkedList<>();
        if(max>=2) primes.add(2);
        int count = min>2?0:1;
        for(int ii=3;ii<=max;ii+=2){
            boolean isPrime = true;
            for(Integer prime:primes){
                if(ii%prime==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.add(ii);
                if(ii>=min) count++;
            }
        }
        /*System.out.println(count);
        System.out.println(primes.getLast());*/
        /*ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(primes.getLast());
        return result;*/
        return count+","+primes.getLast();
        //sieve algorithm fails to address higher values
        /*max++;
        boolean[] bool = new boolean[max+1];
        int count = min>2?0:1;
        bool[2] = true;
        for(int ii = 3; ii <= max; ii+=2) {
            bool[ii] = true;
        }
        for(int ii = 3; ii <= max; ii+=2) {
            if(bool[ii]) {
                if(ii >= min) count++;
                for(int jj = ii*ii; jj <= max; jj += ii) {
                    bool[jj] = false;
                }
            }
        }
        int highest = 0;
        for (int ii = max;highest==0 && ii>=min;ii--){
            if(bool[ii]){
                highest = ii;
                break;
            }
        }
        return new int[]{count,highest};*/
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2){
        return 2*EARTH_RADIUS * Math.asin(Math.sqrt(sinsqhd(deg2rad(lat1),deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * sinsqhd(deg2rad(lon1),deg2rad(lon2))));
    }

    public String show() {
        return "myPrimes(int,int) - int[]\n" +
                "calculates the number of primes in the given range (min, max) and the highest of them (returns 0 if none)\n" +
                "distance(double,double,double,double) - double\n" +
                "given the latitudes and longitudes for two points on Earth (lat1,lon1, lat2,lon2) calculates the distance between them\n" +
                "handleTask(String, String, double, int) - String\n" +
                "returns the information about the task, its priority, status and number\n" +
                "info() - String\n" +
                "returns this text";
    }
    
    public String handleTask(String sign, String status, double priority, int numberOfTask) {
        return  numberOfTask + ". The task: " + sign + "'  has the priority of " + priority + " and " + status;
    }



    /**
     * Calculates square of sine of half of difference between arguments
     */
    private static double sinsqhd(double v1,double v2){
        double r = Math.sin((v1-v2)/2);
        return r*r;
    }

    /* The function to convert decimal into radians */
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    /* The function to convert radians into decimal */
    private static  double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}

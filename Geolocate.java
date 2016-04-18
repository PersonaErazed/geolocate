import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Geolocate {

  public static void main(String[] args) throws Exception {
    String pattern = "yyyy:MM:dd HH:mm:ss";
    BufferedReader buffer = null;
    String line = null;
    ArrayList<LocalDateTime> timestamps = new ArrayList<LocalDateTime>();
    try {
      buffer = new BufferedReader(new FileReader("timestamps.dat"));
      while ((line=buffer.readLine()) != null) {
        timestamps.add(LocalDateTime.parse(line, DateTimeFormatter.ofPattern(pattern)));
      }
    } 
    catch(Exception e) { e.printStackTrace(); }
    finally { if (buffer != null) { buffer.close(); } }

    //ArrayList<> tuple?? location and time maybe a string +34.6273-084.1935/2015-04-01T08:04:20
    // make a new class GeoCoordinate or find one on github
    ArrayList<Double> latitudes = new ArrayList<Double>();
    ArrayList<Double> longitudes = new ArrayList<Double>();
    ArrayList<LocalDateTime> times = new ArrayList<LocalDateTime>();
    try{
      buffer = new BufferedReader(new FileReader("coords.dat"));
      while ((line=buffer.readLine()) != null) {
        System.out.println("Latitude:"+line.substring(0,8));
        System.out.println("Longitude:"+line.substring(8,17));
        System.out.println("DateTime:"+line.substring(18));
      }
    }
    catch(Exception e) { e.printStackTrace(); }
    finally { if (buffer != null) { buffer.close(); } }
    
//    for(LocalDateTime t:timestamps){System.out.println(t.toString());}
  }
}

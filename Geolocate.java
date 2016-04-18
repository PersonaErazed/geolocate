import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Geolocate {

  public static void main(String[] args) throws Exception {
    BufferedReader buffer = null;
    String line = null;

    List<Double> latitudes = new ArrayList<Double>();
    List<Double> longitudes = new ArrayList<Double>();
    List<LocalDateTime> times = new ArrayList<LocalDateTime>();
    int numKnownCoordinates = 0;
    try{
      buffer = new BufferedReader(new FileReader("coords.dat"));
      while ((line=buffer.readLine()) != null) {
        latitudes.add( Double.parseDouble(line.substring(0,8)) );
        longitudes.add( Double.parseDouble(line.substring(8,17)) );
        times.add( LocalDateTime.parse(line.substring(18)) );
        numKnownCoordinates++;
      }
    }
    catch(Exception e) { e.printStackTrace(); }
    finally { if (buffer != null) { buffer.close(); } }

    List<Double> LAT = Collections.unmodifiableList(latitudes);
    List<Double> LONG = Collections.unmodifiableList(longitudes);
    List<LocalDateTime> TIME = Collections.unmodifiableList(times);

    String pattern = "yyyy:MM:dd HH:mm:ss";
    LocalDateTime timestamp;
    ArrayList<String> result = new ArrayList<String>();
    try {
      buffer = new BufferedReader(new FileReader("timestamps.dat"));
      while ((line=buffer.readLine()) != null) {
        timestamp = LocalDateTime.parse(line, DateTimeFormatter.ofPattern(pattern));
        result.add("/"+timestamp.toString());
      }
    } 
    catch(Exception e) { e.printStackTrace(); }
    finally { if (buffer != null) { buffer.close(); } }
  }
}

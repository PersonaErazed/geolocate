import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Geolocate {

  private static LocalDateTime getDateTime(String coord) {
    return LocalDateTime.parse(coord.substring(18));
  }
  private static Double getLat(String coord) {
    return Double.parseDouble(coord.substring(0,8));
  }
  private static Double getLong(String coord) {
    return Double.parseDouble(coord.substring(8,17));
  }

  private static String getCoordinate(LocalDateTime timestamp, ArrayList<String> knownCoordinates) {
    int i = 0;
    while(i<=knownCoordinates.size() &&
      timestamp.compareTo( getDateTime(knownCoordinates.get(i)) ) >= 0) 
    { i++; }
    Double lat1 = getLat(knownCoordinates.get(i-1));
    Double long1 = getLong(knownCoordinates.get(i-1));
    long time1 = getDateTime(knownCoordinates.get(i-1)).toEpochSecond(ZoneOffset.ofHours(5));
    Double lat2 = getLat(knownCoordinates.get(i));
    Double long2 = getLong(knownCoordinates.get(i));
    long time2 = getDateTime(knownCoordinates.get(i)).toEpochSecond(ZoneOffset.ofHours(5));
    return null;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader buffer = null;
    String line = null;

    ArrayList<String> coords = new ArrayList<String>();
    int numKnownCoordinates = 0;
    try{
      buffer = new BufferedReader(new FileReader("coords.dat"));
      while ((line=buffer.readLine()) != null) {
        coords.add(line);
      }
    }
    catch(Exception e) { e.printStackTrace(); }
    finally { if (buffer != null) { buffer.close(); } }

    String pattern = "yyyy:MM:dd HH:mm:ss";
    LocalDateTime timestamp;
    ArrayList<String> result = new ArrayList<String>();
    try {
      buffer = new BufferedReader(new FileReader("timestamps.dat"));
      while ((line=buffer.readLine()) != null) {
        timestamp = LocalDateTime.parse(line, DateTimeFormatter.ofPattern(pattern));
        System.out.println(getCoordinate(timestamp, coords));
        result.add("/"+timestamp.toString());
      }
    } 
    catch(Exception e) { e.printStackTrace(); }
    finally { if (buffer != null) { buffer.close(); } }
  }
}

package softwaredesign.GPXParser;
import com.hs.gpxparser.GPXParser;
import com.hs.gpxparser.modal.GPX;
import com.hs.gpxparser.modal.Waypoint;

import java.io.FileInputStream;
import java.util.HashSet;


public class ParseGpxFile {

    private int distance;
    private int time;
    private int speed;


    public static ParseGpxFile parse(String path) throws Exception {

        GPXParser parser = new GPXParser();
        FileInputStream in = new FileInputStream(path);
        GPX file = parser.parseGPX(in);

        ParseGpxFile parseGpxFile = new ParseGpxFile();

//        parseGpxFile.distance = calculateDistance(file);
//        parseGpxFile.time = calculateTime(file);
//        parseGpxFile.speed = calculateSpeed(file);

        printGPX(file);

        return parseGpxFile;
    }


    public static void printGPX(GPX file){
        HashSet<Waypoint> wp = file.getWaypoints();

        for (Waypoint p : wp){
            System.out.println("Latitute: "+p.getLatitude()+" | Longtitute: " + p.getLongitude() + " | Time: " + p.getTime());
        }

    }

//    private int calculateTime(File file){
//        return 0;
//    }




    public static void main(String[] Args) throws Exception {

    }

}

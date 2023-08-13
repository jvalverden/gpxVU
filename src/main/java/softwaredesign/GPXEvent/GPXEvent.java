package softwaredesign.GPXEvent;

import lombok.Getter;
import lombok.Setter;
import softwaredesign.GPXParser.ParseGpxFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Scanner;


@Getter
public class GPXEvent {

    private String name;
    private String gpxFilePath;
    private String sport;
    private LocalDateTime createdAt;

    public static void create(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to GPX event creator wizard!");
        System.out.println("Please enter the information in asked order, press Q to quit from wizard");

        GPXEvent gpxEvent = new GPXEvent();

        if(gpxEvent.setName(sc) &&
                gpxEvent.setSport(sc) &&
                gpxEvent.setFile(sc)){

            gpxEvent.createdAt = LocalDateTime.now();
            ParseGpxFile parseGpxFile;

            try {
                parseGpxFile = ParseGpxFile.parse(gpxEvent.getGpxFilePath());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // DataObject dataObject = new DataObject(gpxEvent, parseGPXFile);

            System.out.println("Created");
        }else{
            // do nothing
        }


    }

    private boolean setName(Scanner sc){

        //should support blank names ???

        System.out.println("PLease enter the event name: ");
        String name = sc.nextLine();
        if (name.equals("q") || name.equals("Q")){
            return false;
        }
        this.name = name;
        return true;
    }

    private boolean setSport(Scanner sc){

        //should support blank names ???

        System.out.println("PLease enter the sport type: ");
        String sport = sc.nextLine();
        if (sport.equals("q") || sport.equals("Q")){
            return false;
        }
        this.sport = sport;
        return true;

    }

    private boolean setFile(Scanner sc){

        while(true) {
            System.out.println("PLease enter the path of GPX file: ");
            String path = sc.next();

            if (path.equals("q") || path.equals("Q")){
                return false;
            }

            File gpxFile = new File(path);

            if (!gpxFile.exists()) {
                System.out.println("The given path is not exist!");
            }else{
                this.gpxFilePath = path;
                return true;
            }

        }

    }

}

package softwaredesign.menu;

import lombok.RequiredArgsConstructor;
import softwaredesign.GPXEvent.GPXEvent;

import java.util.Scanner;

public class Menu {

    public static void displayMenu(){

        Scanner sc = new Scanner(System.in);

        boolean isOpen = true;

        while(isOpen){

            System.out.println("Welcome to GPX Manager - PLease press the number");
            System.out.println("1-Create a GPX event\n2-View GPX event history\n3-Exit");

            int userInput = sc.nextInt();

            switch (userInput){

                case 1:
                    createGPXEvent();
                    break;
                case 2:
                    //View GPX history
                    isOpen = false; //temporary break loop
                    break;
                case 3:
                    isOpen = false;
                    break;
                default:
                    System.out.println("Wrong Input.. Please enter again:");
            }
        }
    }

    private static void createGPXEvent(){
        GPXEvent.create();
    }


    public static void main(String[] Args){

    }

}

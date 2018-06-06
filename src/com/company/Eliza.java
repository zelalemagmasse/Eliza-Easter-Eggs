package com.company;
import java.util.HashMap;
import java.util.Scanner;

public class Eliza {
    private static HashMap responseToTherGame=new HashMap ();
    public static void main(String[] args) {
        // write your code here

        responseToTherGame.put("welcome", "WELCOME TO Zola'S TINY ADVENTURE! " +
                " You are in a creepy house!  Would you like to go 'upstairs' or into the 'kitchen'?'");
        responseToTherGame.put("kitchen", "There is a long countertop with dirty dishes everywhere.  Off to one side" +
                "                    \"there is, as you'd expect, a refrigerator. You may open the 'refrigerator'" +
                "                    \"or look in a 'cabinet'.");
        responseToTherGame.put("cabinet", "what you see in there is all yours");
        responseToTherGame.put("upstairs", "Upstairs you see a hallway.  At the end of the hallway is the master\n" +
                        "\"bedroom\".  There is also a 'bathroom' off the hallway.  Where would you like" +
                        "to go?");
        responseToTherGame.put("refrigerator", "Inside the refrigerator you see food and stuff.  It looks pretty nasty." +
                "                        \"Would you like to eat some of the food? ('yes' or 'no')");
        responseToTherGame.put("no", "You die of starvation... eventually.");
        responseToTherGame.put("yes", "Enjoy your meal");
        responseToTherGame.put("bedroom", "You are in a plush bedroom, with expensive-looking hardwood furniture.  The " +
                "                        \"bed is unmade.  In the back of the room, the closet door is ajar.  Would you" +
                "                        \"like to open the door? ('yep' or 'nop'");
        responseToTherGame.put("yap", "welcome boy");
        responseToTherGame.put("nop", "Well, then I guess you'll never know what was in there.  Thanks for playing" +
                "                            \"I'm tired of making nested if statements.");


        Scanner input = new Scanner(System.in);
        System.out.println("Good day. What is your problem? Enter your response here or Q to quit");

        String respo1 = input.nextLine();
        int theraphyCounter=1;
        ElizaSupport collector=new ElizaSupport();
        while (!(respo1.equalsIgnoreCase("q"))) {

             collector.LogHistory("User:" + respo1);
            if(respo1.equalsIgnoreCase("pig")){
               // System.out.println("this is a test");
                // easterEggsPig(respo1);
                ElizaSupport pigPointer=new ElizaSupport();
                System.out.println(pigPointer.easterEggsPig(respo1));
                collector.LogHistory("Eliza:" + pigPointer.easterEggsPig(respo1));
            }
            else if(respo1.equalsIgnoreCase("caps")){

                ElizaSupport capsPointer=new ElizaSupport();
                System.out.println(capsPointer.easterEggsCaps(respo1));

                collector.LogHistory("Eliza:" +capsPointer.easterEggsCaps(respo1));

            }
            else if(respo1.equalsIgnoreCase("red")){

                ElizaSupport colorPointer=new ElizaSupport();
                System.out.println(colorPointer.easterEggsColor(respo1));

                collector.LogHistory("Eliza:" +colorPointer.easterEggsColor(respo1));

            }
            else if(respo1.equalsIgnoreCase("play game")){

                EasterEggsPlayGame gamePointer=new EasterEggsPlayGame();
                gamePointer.easterEggsPlayGame();


            }
            else {
                ElizaSupport defulPointer=new ElizaSupport();
                System.out.println(defulPointer.response(respo1));

                collector.LogHistory("Eliza:" +defulPointer.response(respo1));

            }

            respo1 = input.nextLine();
            theraphyCounter++;
            if(theraphyCounter==8) {
                System.out.println("I think we have had a nice therapy session. you may see me next time soon bye");
                respo1 = "q";

            }

        }

        ElizaSupport printHist=new ElizaSupport();
        System.out.println(printHist.LogHistoryRecord().toString());
    }

    public void gameHashMapResponse(String gamePlayer){
        ElizaSupport collector=new ElizaSupport();
        if(responseToTherGame.containsKey(gamePlayer)) {

            System.out.println(responseToTherGame.get(gamePlayer).toString());
            collector.LogHistory("Eliza:" +responseToTherGame.get(gamePlayer).toString());

        }
        else
            System.out.println("typo Error");
             collector.LogHistory("Eliza:" +"typo Error");


    }

}

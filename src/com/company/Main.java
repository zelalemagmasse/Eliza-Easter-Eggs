package com.company;
import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.org.jvnet.fastinfoset.sax.FastInfosetReader;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static ArrayList<String> sampleHeges=new ArrayList<>();
    private static ArrayList<String> sampleQualifier=new ArrayList<>();
    private static HashMap replacement=new HashMap ();

    private static ArrayList<String> changedWordsHolder = new ArrayList<>();
    private static ArrayList<String> lastConcatword = new ArrayList<>();
    public static void main(String[] args) {
        // write your code here
        sampleHeges.add("please tell me more");
        sampleHeges.add("Many of my patients tell me the same thing");
        sampleHeges.add("It is getting late, maybe we had better quit");

        sampleQualifier.add("Why do you say that");
        sampleQualifier.add("You seem to think that");
        sampleQualifier.add("So, you are concerned that");

        replacement.put("i", "you");
        replacement.put("me", "you");
        replacement.put("my", "your");
        replacement.put("am", "are");

        Scanner input = new Scanner(System.in);
        System.out.println("Good day. What is your problem? Enter your response here or Q to quit");

        String respo1 = input.nextLine();
        int theraphyCounter=1;
        while (!(respo1.equalsIgnoreCase("q"))) {
            if(respo1.equalsIgnoreCase("pig")){
               // System.out.println("this is a test");
                // easterEggsPig(respo1);
                System.out.println(easterEggsPig(respo1));
            }
            else if(respo1.equalsIgnoreCase("caps")){
                System.out.println(easterEggsCaps(respo1));

            }
            else if(respo1.equalsIgnoreCase("red")){
                System.out.println(easterEggsColor(respo1));

            }
            else if(respo1.equalsIgnoreCase("play game")){
                easterEggsPlayGame();

            }
            else {
               System.out.println(response(respo1));
            }

            respo1 = input.nextLine();
            theraphyCounter++;
            if(theraphyCounter==8) {
                System.out.println("I think we have had a nice therapy session. you may see me next time soon bye");
                respo1 = "q";
            }
        }
    }
    public static String response(String respon) {
        Random rand = new Random();
        int indexList =  rand.nextInt(2);
        if (indexList==1){
            Random ranndomgenerator = new Random();
            int indexHedge = ranndomgenerator.nextInt(sampleHeges.size());
            return (sampleHeges.get(indexHedge));
        }
        else {
            String combined = replaceReply(respon);
            return (combined);
        }
    }

    private static String replaceReply(String respon) {
        Random ranndomgenerator = new Random();
        int indexQualif = ranndomgenerator.nextInt(sampleQualifier.size());
        sampleQualifier.get(indexQualif);

        String [] splittedFomat=stringSplitter(respon);

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < splittedFomat.length; i++) {
            result.append( wordSwapper(splittedFomat[i] )+ " ");
            //result.append( optional separator );
        }
        //System.out.print(result.toString());

        return sampleQualifier.get(indexQualif) + " " + result.toString()  ;
    }


    public static String wordSwapper(String userWord){
        String fixedWord=null;
        if(replacement.containsKey(userWord)){

            fixedWord=replacement.get(userWord).toString();
        }
        else {
            fixedWord = userWord;
        }
        return fixedWord;
    }

    public static String[] stringSplitter (String respo){
        int i = 0;

        String[] splitted = respo.split(" ");

        return splitted;
    }


    public static int qualifRndom () {
        Random rand = new Random();
        int indexList = rand.nextInt(sampleQualifier.size());//does this method know the sampleQualifier size
        return indexList;
    }

    public static String easterEggsPig(String userInput){
        String beforePig=response(userInput);
        //System.out.println(response(userInput) );
        String[]splittedBeforePig= stringSplitter(beforePig);
        String []piglatino=new String[splittedBeforePig.length];
        for(int i=0;i<splittedBeforePig.length;i++){
            //System.out.println(splittedBeforePig[i]);
            piglatino[i]=pigSwapper(splittedBeforePig[i]) ;
            //System.out.println(piglatino[i]);

        }
        StringBuffer resultLatino = new StringBuffer();
        for (int i = 0; i < piglatino.length; i++) {
            resultLatino.append(( piglatino[i] )+ " ");
            //result.append( optional separator );

        }

        return resultLatino.toString();
    }
    public static String easterEggsCaps(String userInput){
        String beforeCaps=response(userInput);
        //System.out.println(response(userInput) );

        return beforeCaps.toUpperCase().toString();
    }

    public static String easterEggsColor(String userInput){
        String beforeColor=response(userInput);
        //System.out.println(response(userInput) );
        String startColor="\033[31;1m";
        String endColor="\033[0m";
        return startColor.concat(beforeColor.toString()).concat(endColor);
    }



    public static String pigSwapper(String nonPig){
       char startLetter=nonPig.charAt(0);
       String latinPig=null;
       if(startLetter == 'a' || startLetter == 'e' || startLetter == 'i' || startLetter == 'o'
               || startLetter == 'u'){
           String vowelpig = nonPig.concat("ay");
           latinPig=vowelpig;

       }
       else
        {
            String firtLetter = nonPig.substring(0, 1);
            String convertedPig = nonPig.substring(1, nonPig.length()).concat(firtLetter).concat("ay");
            latinPig=convertedPig;
        }
        return latinPig;
    }
    public static void easterEggsPlayGame() {
        // write your code her
        Scanner input = new Scanner(System.in);
        String userChoice =null;
        System.out.println("WELCOME TO Zola'S TINY ADVENTURE!");
        System.out.println("You are in a creepy house!  Would you like to go \"upstairs\" or into the \"kitchen\"?");
        userChoice = input.nextLine();
        if(userChoice.equalsIgnoreCase("kitchen")){
            System.out.println("There is a long countertop with dirty dishes everywhere.  Off to one side\n" +
                    "there is, as you'd expect, a refrigerator. You may open the \"refrigerator\"\n" +
                    "or look in a \"cabinet\".");
            userChoice = input.nextLine();
            if(userChoice.equalsIgnoreCase("refrigerator")){
                System.out.println("Inside the refrigerator you see food and stuff.  It looks pretty nasty.\n" +
                        "Would you like to eat some of the food? (\"yes\" or \"no\")");
                userChoice = input.nextLine();
                if(userChoice.equalsIgnoreCase("no")){
                    System.out.println("You die of starvation... eventually.");
                }else {
                    System.out.println("Enjoy your meal");

                }
            }else if (userChoice.equalsIgnoreCase("cabinet")){
                System.out.println("what you see in there is all yours");
            }
        }else if(userChoice.equalsIgnoreCase("upstairs")){
            System.out.println("Upstairs you see a hallway.  At the end of the hallway is the master\n" +
                    "\"bedroom\".  There is also a \"bathroom\" off the hallway.  Where would you like\n" +
                    "to go?");
            userChoice = input.nextLine();
            if(userChoice.equalsIgnoreCase("bedroom")){
                System.out.println("You are in a plush bedroom, with expensive-looking hardwood furniture.  The\n" +
                        "bed is unmade.  In the back of the room, the closet door is ajar.  Would you\n" +
                        "like to open the door? (\"yes\" or \"no\")");
                userChoice = input.nextLine();
                if(userChoice.equalsIgnoreCase("yes")){
                    System.out.println("welcome boy");
                }
                else if (userChoice.equalsIgnoreCase("no")){
                    System.out.println("Well, then I guess you'll never know what was in there.  Thanks for playing,\n" +
                            "I'm tired of making nested if statements.");
                }
            }
        }
    }

}

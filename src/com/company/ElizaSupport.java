package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ElizaSupport {
    private static ArrayList<String> sampleHeges=new ArrayList<>();
    private static ArrayList<String> sampleQualifier=new ArrayList<>();
    private static HashMap replacement=new HashMap ();
    public static String response(String respon) {

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

}

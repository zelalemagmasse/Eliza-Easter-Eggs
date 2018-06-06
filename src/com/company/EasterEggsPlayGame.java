package com.company;

import java.util.Scanner;

public class EasterEggsPlayGame {
    public static void easterEggsPlayGame() {
        // write your code her
        Eliza elizaPointer=new Eliza();
        Scanner input = new Scanner(System.in);
        String userChoice =null;
        elizaPointer.gameHashMapResponse("welcome");
        userChoice = input.nextLine();
        if(userChoice.equalsIgnoreCase("kitchen")){
            elizaPointer.gameHashMapResponse("kitchen");

            userChoice = input.nextLine();
            if(userChoice.equalsIgnoreCase("refrigerator")){
                elizaPointer.gameHashMapResponse("refrigerator");

                userChoice = input.nextLine();
                if(userChoice.equalsIgnoreCase("no")){
                    elizaPointer.gameHashMapResponse("no");
                    System.out.println("You die of starvation... eventually.");
                }else {
                    elizaPointer.gameHashMapResponse("yes");

                }
            }else if (userChoice.equalsIgnoreCase("cabinet")){
                elizaPointer.gameHashMapResponse("cabinet");

            }
        }else if(userChoice.equalsIgnoreCase("upstairs")){
            elizaPointer.gameHashMapResponse("upstairs");

            userChoice = input.nextLine();
            if(userChoice.equalsIgnoreCase("bedroom")){
                elizaPointer.gameHashMapResponse("bedroom");

                userChoice = input.nextLine();
                if(userChoice.equalsIgnoreCase("yep")){
                    elizaPointer.gameHashMapResponse("yep");

                }
                else if (userChoice.equalsIgnoreCase("nop")){
                    elizaPointer.gameHashMapResponse("nop");

                }
            }
        }
    }
}

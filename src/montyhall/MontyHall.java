/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montyhall;

import java.util.Random;

/**
 *
 * @author nick
 */
public class MontyHall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int winningDoor;
        int selectedDoor;
        int openDoor = -1;
        int switchCount = 0;
        int switchWins = 0;
        int stickCount = 0;
        int stickWins = 0;
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            winningDoor = random.nextInt(3);
            selectedDoor = random.nextInt(3);
            for (int j = 0; j < 3; j++) {
                if (j != winningDoor && j != selectedDoor) {
                    openDoor = j;
                    break;
                }
            }
            boolean switched = false;
            if (random.nextBoolean()) {
                //switch
                for (int j = 0; j < 3; j++) {
                    if (j != openDoor && j != selectedDoor) {
                        selectedDoor = j;
                        switched = true;
                        break;
                    }
                }
            }

            if (switched) {
                switchCount++;
                if (selectedDoor == winningDoor) {
                    switchWins++;
                }
            } else {
                stickCount++;
                if (selectedDoor == winningDoor) {
                    stickWins++;
                }
            }

            if (i % 100000 == 0) {
                System.out.println(String.format("%d\t\tSwitching Wins: %.2f \t\t Sticking Wins: %.2f", i,((float) switchWins / (float) switchCount) * 100.0f, ((float) stickWins / (float) stickCount) * 100.0f));
            }
        }

    }

}

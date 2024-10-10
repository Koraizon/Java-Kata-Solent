package org.solent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.solent.actions.Advance;
import org.solent.actions.Left;
import org.solent.actions.Right;
import org.solent.enums.Instruction;
import org.solent.enums.Orientation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Execute the program with the test file")
    void Execute() {
        //On créer une liste des tondeuses afin de récupérer leurs positions finales
        List<Mower> mowers = new ArrayList<Mower>();
        try {
            //On récupère le fichier de test et on créé le buffer qui va le lire
            String file ="src/test/java/org/solent/testfile.txt";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            //On lit la première ligne afin de déterminer les dimensions de la pelouse
            String currentLine = reader.readLine();
            String[] dimensions = currentLine.split(" ");
            Coordinate coordinate = new Coordinate(Integer.parseInt(dimensions[0]) + 1, Integer.parseInt(dimensions[1]) +1);
            Lawn lawn = new Lawn(coordinate);

            //Pour chaque tondeuse, on va regarder sa position initiale et effectuer la suite d'instructions voulu
            while ((currentLine = reader.readLine()) != null) {

                //On initialise la tondeuse avec ses coordonnées et son orientation initiale
                String[] initialPosition = currentLine.split(" ");
                Coordinate initialCoordinate = new Coordinate(Integer.parseInt(initialPosition[0]), Integer.parseInt(initialPosition[1]));
                Orientation initialOrientation = Orientation.valueOf(initialPosition[2]);
                Mower mower = new Mower(initialCoordinate, initialOrientation, lawn);

                //On ajoute la tondeuse à notre liste de tondeuse
                mowers.add(mower);

                //On récupère la liste d'instruction de la tondeuse
                currentLine = reader.readLine();
                String[] instructions = currentLine.split("");

                //Pour chaque instruction, on va effectuer l'action adéquat
                for (String instruction : instructions) {
                    if(Instruction.valueOf(instruction) == Instruction.A){
                        mower.setAction(new Advance());
                    }
                    else if(Instruction.valueOf(instruction) == Instruction.D){
                        mower.setAction(new Right());
                    }
                    else if(Instruction.valueOf(instruction) == Instruction.G){
                        mower.setAction(new Left());
                    }
                    mower.executeAction();
                }
                System.out.println("Position finale de la tondeuse " + mowers.indexOf(mower) + " : " + mower.getPosition());
            }
            //On ferme le buffer
            reader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //On récupère la position de chaque tondeuse et on les join en un seul string pour avoir le format voulu
        String results = mowers.stream().map(Mower::getPosition).collect(Collectors.joining(" "));
        System.out.println("résultat final : " + results);

        assertEquals("1 3 N 5 1 E", results);
    }
}
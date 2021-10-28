package org.com.simian.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class SimianService {

    private final static Set<String> specificCharacter = Set.of("A", "T", "C", "G");

    public Boolean isSimian(String[] dna) throws Exception {
        validateDnaInput(dna);

        List<String> dnaList = Arrays.asList(dna);

        if(validateHori(dnaList)){
            return Boolean.TRUE;
        } else if(validateVerti(dnaList)){
            return Boolean.TRUE;
        } else if(validateDiag(dnaList)){
            return Boolean.TRUE;
        } else if(validateDiagInv(dnaList)){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public void validateDnaInput(String[] dna) throws Exception {
        for (String sequence : dna){
            char[] letter = sequence.toCharArray();

            for (char character : letter){
                if(!specificCharacter.contains(Character.toString(character))){
                    throw new Exception("Invalid DNA");
                }
            }
        }
    }

    public Boolean validateHori(List<String> dnaList){
        Boolean isSimian = Boolean.FALSE;

        // Iterate the list
        for(String dna : dnaList) {

            //Array of dna line
            char[] lineArray = dna.toCharArray();
            // Initialize the count per line
            int countElements = 1;

            // Remove the last element
            int arrayLengthLessLastElement = lineArray.length - 1;

            for (int i = 0; i < arrayLengthLessLastElement; i++) {
                char prevElement = lineArray[i];
                char nextElement = lineArray[i + 1];

                if (prevElement == nextElement) {
                    countElements++;
                }

                if(countElements == 4){
                    isSimian = Boolean.TRUE;
                    break;
                }
            }
        }
        return isSimian;
    }

    public Boolean validateVerti(List<String> dnaList){
        Boolean isSimian = Boolean.FALSE;

        // Remove the iteration the last tree elements
        int dnaListSize = dnaList.size() - 3;
        for (int i = 0; i < dnaListSize; i++) {
            // Previous line
            char[] firstLineArray = dnaList.get(i).toCharArray();
            char[] secondLineArray = dnaList.get(i+1).toCharArray();
            char[] thirdLineArray = dnaList.get(i+2).toCharArray();
            char[] fourthLineArray = dnaList.get(i+3).toCharArray();

            // Lenght of the line to compare down elements
            int lineSize = firstLineArray.length;

            for (int j = 0; j < lineSize; j++) {
                char elementLineOne = firstLineArray[j];
                char elementLineTwo = secondLineArray[j];
                char elementLineTree = thirdLineArray[j];
                char elementLineFour = fourthLineArray[j];

                if(elementLineOne == elementLineTwo && elementLineOne == elementLineTree && elementLineOne == elementLineFour){
                    isSimian = Boolean.TRUE;
                    break;
                }
            }
        }

        return isSimian;
    }

    public Boolean validateDiag(List<String> dnaList){
        Boolean isSimian = Boolean.FALSE;

        // Remove the iteration the last tree elements
        int dnaListSize = dnaList.size() - 3;
        for (int i = 0; i < dnaListSize; i++) {
            // Previous line
            char[] firstLineArray = dnaList.get(i).toCharArray();
            char[] secondLineArray = dnaList.get(i+1).toCharArray();
            char[] thirdLineArray = dnaList.get(i+2).toCharArray();
            char[] fourthLineArray = dnaList.get(i+3).toCharArray();

            // Lenght of the line to compare down elements less 3 elements
            int lineSize = firstLineArray.length;

            for (int j = 0; j < lineSize - 3; j++) {
                char elementLineOne = firstLineArray[j];

                int diagonalTwo = j + 1;
                char elementLineTwo = secondLineArray[diagonalTwo];

                int diagonalTree = diagonalTwo + 1;
                char elementLineTree = thirdLineArray[diagonalTree];

                int diagonalFour = diagonalTree + 1;
                char elementLineFour = fourthLineArray[diagonalFour];

                if(elementLineOne == elementLineTwo && elementLineOne == elementLineTree && elementLineOne == elementLineFour){
                    isSimian = Boolean.TRUE;
                    break;
                }
            }
        }

        return isSimian;
    }

    public Boolean validateDiagInv(List<String> dnaList){
        Boolean isSimian = Boolean.FALSE;

        int dnaListSize = dnaList.size() - 3;
        for (int i = 0; i < dnaListSize; i++) {
            char[] firstLineArray = dnaList.get(i).toCharArray();
            char[] secondLineArray = dnaList.get(i+1).toCharArray();
            char[] thirdLineArray = dnaList.get(i+2).toCharArray();
            char[] fourthLineArray = dnaList.get(i+3).toCharArray();


            int lineSize = firstLineArray.length;

            // Start from last element of the line, limiting the first tree elements
            for (int j = lineSize - 1; j >= lineSize - 3; j--) {
                char elementLineOne = firstLineArray[j];

                int diagonalTwo = j - 1;
                char elementLineTwo = secondLineArray[diagonalTwo];

                int diagonalTree = diagonalTwo - 1;
                char elementLineTree = thirdLineArray[diagonalTree];

                int diagonalFour = diagonalTree - 1;
                char elementLineFour = fourthLineArray[diagonalFour];

                if(elementLineOne == elementLineTwo && elementLineOne == elementLineTree && elementLineOne == elementLineFour){
                    isSimian = Boolean.TRUE;
                    break;
                }
            }
        }

        return isSimian;
    }


}

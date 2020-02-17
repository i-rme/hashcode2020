package com.hashcode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Hello world
        System.out.println("Starting file parsing");


        //Stopwatch Start
        long startTime = System.currentTimeMillis();


        //Initial file parsing into lines
        List<String> list = new ArrayList<>();
        File file = new File("./src/c_medium.in");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }


        //print out the list
        System.out.println(list);
        System.out.println();

        //Parameter reading
        String firstLine = list.get(0);
        String[] firstLineParameters = firstLine.split(" ");

        int maxPizzaSlices = Integer.parseInt( firstLineParameters[0] );
        int pizzaTypes = Integer.parseInt( firstLineParameters[1] );

        System.out.println("maxPizzaSlices: " + maxPizzaSlices);
        System.out.println("pizzaTypes: " + pizzaTypes);
        System.out.println();


        //Data reading
        String secondLine = list.get(1);
        int numElements = (int)secondLine.chars().filter(Character::isWhitespace).count() + 1;
        int[] secondLineData = new int[ numElements ];
        List<Integer> secondLineDataList = new ArrayList<Integer>(numElements);


        int numElementsIterated = 0;

        for (String s : secondLine.split(" ")) {
            secondLineData[numElementsIterated++] = Integer.parseInt(s);
            secondLineDataList.add( Integer.parseInt(s) );
            //System.out.println(Integer.parseInt(s));
        }

        System.out.println("Number of data elements expected: " + numElements);
        System.out.println("Number of data elements iterated: " + numElementsIterated);
        System.out.println( Arrays.toString(secondLineData) );


        //Stopwatch stop parsing
        long stopTimeParsing = System.currentTimeMillis();
        System.out.println("Time consumed in parsing: " + (stopTimeParsing - startTime) + " milliseconds");
        System.out.println();


        //Algorithm
        int sum = 0;
        for(int i:secondLineData){
            sum += i;
            //System.out.println(i);
        }

        System.out.println("There is a total of " + sum + " slides if we order all types of pizza.");


        //Option 1: Get 95% of elements randomly and process the rest
        System.out.println(secondLineDataList);

        for(int i = 0; i < numElements; i++){
            secondLineDataList.remove(0);
        }

        System.out.println(secondLineDataList);


        //Stopwatch stop algorithm
        long stopTimeAlgorithm = System.currentTimeMillis();
        System.out.println("Time consumed in algorithm: " + (stopTimeAlgorithm - stopTimeParsing) + " milliseconds");
        System.out.println();

        //Submission Output
        int outputNumPizzaTypes;
        String outputPizzaTypes;
    }
}

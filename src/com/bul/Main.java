package com.bul;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        // write your code here
    
        //define arrays
        Integer[] aArray = {180, 10, 96, 146};
        Integer[] bArray = {138, 28, 166, 172};
        Integer[] cArray = {114, 186, 4, 158};
        Integer[] dArray = {14, 154, 150, 46};
        
        Scanner input = new Scanner(System.in);
        int iter;
        System.out.println("Iterasyon sayisi girin :");
        iter = input.nextInt();
        String[] startResult = {"D", "C", "B", "A"};
        Integer startValue = dArray[0] + cArray[1] + bArray[2] + aArray[3];
        Integer bestValue = startValue;
        System.out.println("Baslangic en iyi deger: " + bestValue);
        System.out.println("Baslangic dizi: " + Arrays.asList(startResult));
        Integer geciciValue;
        List<String> tabuList = new ArrayList<>(3);
        Integer bestValueArray = null;
    
        for (int z = 0; z < 4; z++) {
            for(int y = 0; y<4; y++) {
                String[] fakeList = startResult;
                fakeList[0] = startResult[y];
                fakeList[y] = startResult[0];
                geciciValue = aArray[Arrays.asList(fakeList).indexOf("A")] + bArray[Arrays.asList(fakeList).indexOf("B")] + cArray[Arrays.asList(fakeList).indexOf("C")] + dArray[Arrays.asList(fakeList).indexOf("D")];
                if (geciciValue < bestValue) {
                    bestValue = geciciValue;
                    bestValueArray = geciciValue;
                    if (tabuList.size() > 3) {
                        tabuList.remove(0);
                        if (!tabuList.contains("(" + startResult[y] + "," + startResult[0] + ")")) {
                            tabuList.add("(" + startResult[y] + "," + startResult[0] + ")");
                        }
                    } else {
                        if (!tabuList.contains("(" + startResult[y] + "," + startResult[0] + ")")) {
                            tabuList.add("(" + startResult[y] + "," + startResult[0] + ")");
                        }
            
                    }
                }
            }
    
            if (tabuList.isEmpty()) {
                int i = 0;
                while (i < iter - 1) {
                    int i1 = ThreadLocalRandom.current().nextInt(1, 3);
                    int i2 = ThreadLocalRandom.current().nextInt(1, 3);
                    Collections.swap(Arrays.asList(startResult), i1, i2);
                    geciciValue = aArray[Arrays.asList(startResult).indexOf("A")] + bArray[Arrays.asList(startResult).indexOf("B")] + cArray[Arrays.asList(startResult).indexOf("C")] + dArray[Arrays.asList(startResult).indexOf("D")];
                    if (geciciValue < bestValue) {
                        bestValue = geciciValue;
                        bestValueArray = geciciValue;
                        if (tabuList.size() > 3) {
                            tabuList.remove(0);
                            if (!tabuList.contains("(" + startResult[i1] + "," + startResult[i2] + ")")) {
                                tabuList.add("(" + startResult[i1] + "," + startResult[i2] + ")");
                            }
                        } else {
                            if (!tabuList.contains("(" + startResult[i1] + "," + startResult[i2] + ")")) {
                                tabuList.add("(" + startResult[i1] + "," + startResult[i2] + ")");
                            }
                        }
                    }
                    i++;
                }
            }
            System.out.println("En iyi degisimler : " + Arrays.asList(tabuList));
            System.out.println("En iyi dizi : " + Arrays.asList(startResult));
            System.out.println("En iyi deger : " + bestValueArray);
        }
    }
    }

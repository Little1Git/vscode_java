package example.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runnable_Exe {
    public static void main(String[] args) {
        ArrayList<String> istock_List = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            istock_List.add("Element " + i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        
        Runnable task = () -> {
            HashMap<String, Integer> result = processList(istock_List);
            System.out.println("Finish");
        };

        executorService.submit(task);
        executorService.submit(task);
        executorService.submit(task);
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(100, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static HashMap<String, Integer> processList(ArrayList<String> istock_List) {
        HashMap<String, Integer> iStockSumm = new HashMap<>();
        for (String obj : istock_List) {
            if (!iStockSumm.containsKey(obj)) {
                iStockSumm.put(obj, 0);
            }
            iStockSumm.put(obj, iStockSumm.get(obj) + 1);
        }
        return iStockSumm;
    }
    
}

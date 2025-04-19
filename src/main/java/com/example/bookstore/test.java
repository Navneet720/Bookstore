package com.example.bookstore;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5, 6};
        for (int n : number) {
            System.out.println(n);
        }

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> reversed = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }

        System.out.println(reversed);


        HashMap<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("d", "c");

        System.out.println(map);
//        map.remove(11);
        System.out.println(map);

        for (String i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }

        for (Map.Entry<String, String> entry : map.entrySet()
        ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}


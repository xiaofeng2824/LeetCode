package myArray;

import utils.ArrayUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinSetSize {

    public static void main(String[] args) {

        String str = "[3,3,3,3,5,5,5,2,2,7]";
        int[] ints = ArrayUtils.stringToArray(str);

        System.out.println(minSetSize(ints));
    }

    public static int minSetSize(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            Integer value = map.getOrDefault(arr[i], 0);
            map.put(arr[i],value + 1);
        }

        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());

        int count = 0;
        int sum = 0;
        int halfLength = arr.length /2;
        for (int i= collect.size() -1; i>=0;i--) {
            int value = collect.get(i);
            sum += value;
            count++;
            if (sum >= halfLength){
                break;
            }
        }
        return count;
    }
}

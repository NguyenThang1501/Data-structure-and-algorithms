import java.util.*;
import java.lang.*;

public class ADAFRIEN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int k = sc.nextInt();
        Map<String, Long> friends = new HashMap<>();
        for (int i = 0; i < q; i++) {
            String name = sc.next();
            long e = sc.nextLong();
            if (friends.containsKey(name)) {
                friends.replace(name, friends.get(name) + e);
            } else {
                friends.put(name, e);
            }
        }
        Set<String> set = friends.keySet();
        int index = 0;
        long[] arr = new long[friends.size()];
        for (String key : set){
            arr[index] = friends.get(key);
            index++;
        }
        Arrays.sort(arr);
        long result =0;
        for (int i=arr.length-1; i>arr.length-1 -k && i>=0;i--){
            result+= arr[i];
        }
        System.out.println(result);

//        long max = 0;
//        long result = 0;
//        String temp = "";
//        while (k > 0 && !friends.isEmpty()) {
//            for (String key : set) {
//                if (friends.get(key) > max) {
//                    max = friends.get(key);
//                    temp = key;
//                }
//            }
//            result += max;
//            friends.remove(temp);
//            max = 0;
//            k--;
//
//        }
  //      System.out.println(result);
    }
}

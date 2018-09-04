package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupShiftedStrings_249 {
    public static List<List<String>> groupStrings(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap();

        for (String s : strs) {
            System.out.println(s);
            StringBuilder key = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                key.append("#");
                key.append((s.charAt(i) - s.charAt(i-1) + 26) % 26);
            }
            System.out.println(key);

            String keyStr = key.toString();
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList());
            map.get(keyStr).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }

    // Functional Programming Style
    public static List<List<String>> groupStrings2(String[] strings) {
        return new ArrayList(Stream.of(strings).collect(
                Collectors.groupingBy(
                    s -> s.chars().mapToObj(c -> (c - s.charAt(0) + 26) % 26)
                        .collect(Collectors.toList())
        )).values());
    }

    public static void main(String[] args) {
        String[] input = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupStrings(input));
    }
}

package Graph;

import util.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Asked in Facebook, Google
public class EvaluateDivision_399 {
    public Double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<Pair>> map = new HashMap(); // "a", [Pair("b", 2.0), Pair("b", 2.0)]
        HashSet<String> ss = new HashSet();

        for(int i=0; i<equations.length; i++){
            String den = equations[i][0];
            String num = equations[i][1];
            double val = values[i];

            ss.add(den);
            ss.add(num);

            if(!map.containsKey(den))
                map.put(den, new ArrayList<Pair>());
            map.get(den).add(new Pair(num, val));

            if(!map.containsKey(num))
                map.put(num, new ArrayList<Pair>());
            map.get(num).add(new Pair(den, 1.0/val));
        }

        Double[] result = new Double[queries.length];
        for(int i=0; i<queries.length; i++){
            if(!ss.contains(queries[i][0]) || !ss.contains(queries[i][1])){
                result[i] = -1.0;
                continue;
            }
            result[i] = findResult(queries[i][0], queries[i][1], map, new HashSet<String>(), 1.0);
            if(result[i] == 0.0)
                result[i] = -1.0;
        }

        return result;
    }

    public double findResult(String den, String num, HashMap<String, List<Pair>> map, HashSet<String> ss, double result){
        if(ss.contains(den))
            return 0.0;
        if(den.equals(num))
            return result;


        ss.add(den);
        List<Pair> pairs = map.get(den);

        double current = 0.0;
        for(Pair p : pairs){
            current = findResult(p.key, num, map, ss, result * p.val);
            if(current != 0.0)
                break;
        }
        ss.remove(den);
        return current;
    }

    // a/b = 2.0, b/c = 3.0
    public static void main(String[] args) {
        EvaluateDivision_399 t = new EvaluateDivision_399();
        String[][] equations = {{"a","b"},{"b","c"}};
        double[] values      = {2.0,3.0};
        String[][] queries   = {{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};
        Double[] result = t.calcEquation(equations, values, queries);
        Printer.printArray(result);
    }
}

class Pair {
    String key;
    double val;
    public Pair(String k, double v){
        this.key = k;
        this.val = v;
    }
}

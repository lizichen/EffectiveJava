package InterviewQuiz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bloomberg_KillProcess582 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        HashMap<Integer, LinkedList<Integer>> map = new HashMap();

        for(int i=0; i<pid.size(); i++){
            int ppidVal = ppid.get(i);
            int pidVal  = pid.get(i);
            if(map.containsKey(ppidVal)){
                LinkedList<Integer> tmp = map.get(ppidVal);
                tmp.add(pidVal);
                map.put(ppidVal, tmp);
            }else{
                LinkedList<Integer> tmpList = new LinkedList();
                tmpList.add(pidVal);
                map.put(ppidVal, tmpList);
            }
        }

        List<Integer> result = new LinkedList();
        if(map.get(kill) == null) // this is empty
            return result;

        result.add(kill);

        Queue<List<Integer>> q = new LinkedList();
        List<Integer> killList = new LinkedList();
        killList.add(kill);
        q.add(killList);

        while(q.size() != 0){
            List<Integer> qHead = q.poll();
            for(Integer i : qHead){
                if(map.containsKey(i)){
                    q.add(map.get(i));
                }
                result.add(i);
            }
        }

        return result;
    }
}

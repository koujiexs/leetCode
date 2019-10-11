package com.company.test752;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadSet=new HashSet<>(deadends.length);
        for (String s:deadends)
            deadSet.add(s);
        if (deadSet.contains(target))
            return -1;
        if (deadSet.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;
        //BFS
        Queue<String> queue=new LinkedList<>();
        HashMap<String,Integer> visited=new HashMap<>();
        queue.add("0000");
        visited.put("0000",0);
        while (!queue.isEmpty()){
            String curS=queue.remove();
            char[] curArray = curS.toCharArray();
            ArrayList<String> nextS=new ArrayList<>(8);
            for (int i = 0; i < 4; i++) {
                char o=curArray[i];
                curArray[i]=Character.forDigit((curArray[i]-'0'+1)%10,10);
                nextS.add(new String(curArray));
                curArray[i]=o;
                curArray[i]=Character.forDigit((curArray[i]-'0'+9)%10,10);
                nextS.add(new String(curArray));
                curArray[i]=o;
            }
            for (String next:nextS){
                if (!deadSet.contains(next)&&!visited.containsKey(next)){
                    queue.add(next);
                    visited.put(next,visited.get(curS)+1);
                    if (next.equals(target))
                        return visited.get(next);
                }
            }
        }
        return -1;
    }
}

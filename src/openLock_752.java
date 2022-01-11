import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class openLock_752 {
    public static void main(String[] args) {
        System.out.println(openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
    }
    public static int openLock(String[] deadends, String target) {
        Queue<String> q=new LinkedList<>();
        Set<String> visted=new HashSet<>();
        q.offer("0000");
        visted.add("0000");
        int step=0;     //转动的步数

        Set<String> dead=new HashSet<>();
        for(String str:deadends){
            dead.add(str);
        }

        while(!q.isEmpty()){
            int size=q.size();
            //将当前队列所有节点进行扩散
            for(int i=0;i<size;i++){
                String cur=q.poll();
                //判断是否需要跳过
                if(dead.contains(cur)) continue;
                //判断是否到达终点
                if(cur.equals(target)) return step;

                for(int j=0;j<4;j++){

                    String up=up(cur,j);
                    if(!visted.contains(up)){
                        q.offer(up);
                        visted.add(up);
                    }

                    String down=down(cur,j);
                    if(!visted.contains(down)){
                        q.offer(down);
                        visted.add(down);
                    }
                }

            }
            step++;
        }
        return -1;

    }

    //密码锁向上转一次，数字增大
    public static String up(String cur,int j){
        char[] ch=cur.toCharArray();
        if(ch[j]=='9') ch[j]='0';
        else ch[j]++;
        String cur1=new String(ch);
        return cur1;
    }

    //密码锁向下转一次，数字减小
    public static String down(String cur,int j){
        char[] ch=cur.toCharArray();
        if(ch[j]=='0') ch[j]='9';
        else ch[j]--;
        String cur2=new String(ch);
        return cur2;
    }
}

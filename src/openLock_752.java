import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class openLock_752 {
    public static void main(String[] args) {
        System.out.println(openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
    }

    //打开转盘锁
    //你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
    //
    //锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
    //
    //列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
    //
    //字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/open-the-lock
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

import java.util.HashMap;

public class minWindow_76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
    //最小覆盖子串
    //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

    //注意：
    //对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    //如果 s 中存在这样的子串，我们保证它是唯一的答案。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/minimum-window-substring
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String minWindow(String s, String t){
        int start=0,left=0,right=0;
        int len=Integer.MAX_VALUE;
        int success=0;
        HashMap<Character,Integer> target=new HashMap<>();
        for(char cur:t.toCharArray()){
            target.put(cur,target.getOrDefault(cur,0)+1);
        }

        HashMap<Character,Integer> window =new HashMap<>();
        while(right<s.length()){
            char c=s.charAt(right);
            if(target.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(target.get(c))){
                    success++;
                }
            }
            right++;

            while(success==target.size()){
                if(right-left<len){
                    start=left;
                    len=right-left;
                }
                char x=s.charAt(left);
                if(target.containsKey(x)){
                    if(window.get(x).equals(target.get(x))){
                        success--;
                    }
                    window.put(x,window.get(x)-1);
                }
                left++;
            }

        }

        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }

//    public static String minWindow(String s, String t) {
//        // 统计字符串t的词频
//        HashMap<Character, Integer> target = new HashMap<>();
//        for(int i = 0; i < t.length(); i++){
//            char cur = t.charAt(i);
//            int curNum = target.getOrDefault(t.charAt(i), 0);   //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
//            target.put(cur, curNum + 1);
//        }
//        // 记录滑动窗口中的词频
//        HashMap<Character, Integer> window = new HashMap<>();
//        // 当前窗口中满足要求的字符个数
//        int success = 0;
//        // 记录最小覆盖子串的起始位置和长度
//        int start = 0;
//        int len = Integer.MAX_VALUE;
//
//        // 开始滑动窗口(左闭右开)
//        int left = 0,right = 0;
//        while(right < s.length()){
//            char c = s.charAt(right);
//            if(target.containsKey(c)){
//                // 把 s[right] 加入窗口
//                window.put(c, window.getOrDefault(c, 0) + 1);
//                // 判断窗口中字符 c 的数量是否达到要求
//                if(target.get(c).equals(window.get(c))){
//                    success++;  //达到要求的字符个数加一
//                }
//            }
//            // 窗口向右扩大
//            right++;
//
//            // 判断窗口是否涵盖了 t 中所有字符
//            while(success == target.size()){
//                // 更新结果
//                if(right - left < len){
//                    start = left;
//                    len = right - left;
//                }
//
//                // 缩小窗口范围
//                char x = s.charAt(left);
//                if(target.containsKey(x)){
//                    if(window.get(x).equals(target.get(x))){
//                        success--;
//                    }
//                    window.put(x, window.get(x) - 1);
//                }
//                left++;
//            }
//        }
//        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
//    }

}

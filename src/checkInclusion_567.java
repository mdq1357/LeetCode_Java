import java.util.HashMap;

public class checkInclusion_567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }
//字符串的排列
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
//换句话说，s1 的排列之一是 s2 的 子串 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/permutation-in-string
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char cur : s1.toCharArray()) {
            target.put(cur, target.getOrDefault(cur, 0) + 1);
        }

        int left = 0, right = 0, success = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    success++;
                }
            }


            right++;

            while (right - left >= s1.length()) {
                char x = s2.charAt(left);
                if (success == target.size()) {
                    return true;
                }
                left++;
                if (target.containsKey(x)) {
                    if (window.get(x).equals(target.get(x))) {
                        success--;
                    }
                    window.put(x, window.get(x) - 1);
                }

                // left++;
            }
        }

        return false;
    }
}

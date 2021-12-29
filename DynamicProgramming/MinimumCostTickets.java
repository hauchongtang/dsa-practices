import java.util.HashMap;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] incr = new int[]{1, 7, 30};
        int[] dp = new int[days.length];

        for (int i = days.length - 1; i >= 0; i--) {
            map.put(i, Integer.MAX_VALUE);
            for (int k = 0; k < costs.length; k++) {
                int j = i;
                while (j < days.length && days[j] < days[i] + incr[k]) {
                    j++;
                }
                if (!map.containsKey(j)) {
                    map.put(j, 0);
                }
                map.put(i, Math.min(map.get(i), costs[k] + map.get(j)));
            }
        }
        return map.get(0);
    }
}

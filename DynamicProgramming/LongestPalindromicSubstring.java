class Solution {
    /*
     * Two Pointer approach (L and R pointer)
     * iterate through whole char array and search s[left] == s[right]
     * Time: O(N^2)
     * Space: O(N) 
     */
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l > max) {
                left = l + 1;
                right = r;
                max = r - l;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l > max) {
                left = l + 1;
                right = r;
                max = r - l;
            }
        }
        
        String result = s.substring(left, right);
        return result.equals("") ? s.substring(0,1) : result;
    }
}

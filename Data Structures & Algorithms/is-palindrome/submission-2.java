class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while(left < right) {
            while(left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }
            while(left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isAlphaNumeric(char c) {
        if(c >= 'A' && c <= 'Z') {
            return true;
        }
        if(c >= 'a' && c <= 'z') {
            return true;
        }
        if(c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}

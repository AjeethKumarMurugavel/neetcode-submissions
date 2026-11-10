class Solution {

    public String encode(List<String> strs) {
        StringBuilder strB = new StringBuilder();
        for(String str : strs) {
            strB.append(str.length());
            strB.append("#");
            strB.append(str);
        }
        return strB.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < str.length()) {
            j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String part = str.substring(j+1, j+1+len);
            result.add(part);
            i = j+1+len;
        }
        return result;
    }
}

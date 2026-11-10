class Solution {

    public String encode(List<String> strs) {
        StringBuilder strB = new StringBuilder();
        for(String s : strs) {
            String encoded = Base64.getEncoder().encodeToString(s.getBytes());
            System.out.println(encoded);
            strB.append(encoded);
            strB.append(",");
        }
        System.out.println(strB);
        return strB.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(str.isEmpty()) {
            return result;
        }
        String[] arr = str.split(",", -1);
        for(int i=0; i<arr.length-1; i++) {
            byte[] bytes = Base64.getDecoder().decode(arr[i]);
            result.add(new String(bytes));
        }
        return result;
    }
}

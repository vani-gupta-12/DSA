class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String e : emails){
            String[] parts = e.split("@");
            String local = parts[0];
            String domain = parts[1];
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<local.length();i++){
                char ch = e.charAt(i);
                if(ch=='+') break;
                if(ch=='.') continue;
                sb.append(ch);
            }
            String normal = sb.toString()+ "@" + domain;
            set.add(normal);
        }
        return set.size();
    }
}
class Solution {
    public String defangIPaddr(String address) {
        String change = address.replace(".","[.]");
        return change;
    }
}
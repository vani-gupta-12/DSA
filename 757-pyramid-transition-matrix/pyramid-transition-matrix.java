class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();

        // Build mapping: "AB" -> ['C','D']
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }

        return dfs(bottom, map, new HashMap<>());
    }

    private boolean dfs(String bottom, Map<String, List<Character>> map, Map<String, Boolean> memo) {
        if (bottom.length() == 1) return true;
        if (memo.containsKey(bottom)) return memo.get(bottom);

        List<String> nextLevels = new ArrayList<>();
        buildNext(bottom, 0, new StringBuilder(), map, nextLevels);

        for (String next : nextLevels) {
            if (dfs(next, map, memo)) {
                memo.put(bottom, true);
                return true;
            }
        }

        memo.put(bottom, false);
        return false;
    }

    private void buildNext(String bottom, int idx, StringBuilder curr,
                           Map<String, List<Character>> map, List<String> res) {
        if (idx == bottom.length() - 1) {
            res.add(curr.toString());
            return;
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            curr.append(c);
            buildNext(bottom, idx + 1, curr, map, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class _20_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> openers = new Stack<>();

        // Map Openings -> Endings
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // Iterate
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);

            // If it's Opening -> Store
            if (!map.containsKey(current)) { // Opener
                openers.push(current);
            } else { // Closer
                if (openers.size() == 0) {
                    return false;
                }

                // Is what expected?
                Character lastOpener = openers.pop();
                if (lastOpener != map.get(current)) {
                    return false;
                }
            }
        }

        // Stack should be empty to be a valid program
        return openers.size() == 0;
    }
}
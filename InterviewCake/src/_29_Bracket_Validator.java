import java.util.*;

class _29_Bracket_Validator {
    public static boolean isValid(String code) {
        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());

        Stack<Character> openersStack = new Stack<>();

        for (char c : code.toCharArray()) {
            if (openers.contains(c)) {
                openersStack.push(c);
            } else if (closers.contains(c)) {
                if (openersStack.empty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();

                    // If this closer doesn't correspond to the most recently
                    // seen unclosed opener, short-circuit, returning false
                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }

        return openersStack.empty();
    }
}
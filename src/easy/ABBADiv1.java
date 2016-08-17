package easy;

/**
 * Created by kekai on 16/8/17.
 */
public class ABBADiv1 {

    public String canObtain(String initial, String target) {
        return previous(initial, target) ? "Possible" : "Impossible";
    }

    private boolean previous(String initial, String target) {
        if(target.length() < initial.length()) {
            return false;
        }
        if(target.equals(initial)) {
            return true;
        }
        boolean flagA = false;
        boolean flagB = false;
        if(target.endsWith("A")){
            String previousA = previousA(target);
            if(previousA.equals(initial)) {
                return true;
            } else {
                flagA = previous(initial, previousA);
            }
        }

        if(target.startsWith("B")) {
            String previousB = previousB(target);
            if(previousB.equals(initial)) {
                return true;
            } else {
                flagB = previous(initial, previousB);
            }
        }

        return flagA | flagB;
    }

    private String previousA(String target) {
        int len = target.length();
        return target.substring(0, len - 1);
    }

    private String previousB(String target) {
        char[] reverseBuf = reverse(target);
        String previousTarget = new String(reverseBuf, 0, reverseBuf.length - 1);
        return previousTarget;
    }

    private char[] reverse(String str) {
        int size = str.length();

        char[] buffer = new char[size];
        str.getChars(0, size, buffer, 0);

        int half = size / 2;
        char[] buf = buffer;
        for (int leftIdx = 0, rightIdx = size - 1; leftIdx < half; leftIdx++,rightIdx--) {
            char swap = buf[leftIdx];
            buf[leftIdx] = buf[rightIdx];
            buf[rightIdx] = swap;
        }
        return buf;
    }
}


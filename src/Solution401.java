import java.util.LinkedList;
import java.util.List;

class Solution401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new LinkedList<>();
        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + ((m < 10) ? "0" : "") + m);
                }
            }
        }
        return res;
    }
}
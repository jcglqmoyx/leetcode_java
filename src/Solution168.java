public class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--;
            builder.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        builder.reverse();
        return builder.toString();
    }
}
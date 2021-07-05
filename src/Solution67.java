public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0 && j >= 0) {
                int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
                builder.append((char) sum % 2);
                carry = sum / 2;
            } else if (i >= 0) {
                int sum = a.charAt(i) - '0' + carry;
                builder.append((char) sum % 2);
                carry = sum / 2;
            } else {
                int sum = b.charAt(j) - '0' + carry;
                builder.append((char) sum % 2);
                carry = sum / 2;
            }
        }
        if (carry > 0) builder.append(carry);
        return builder.reverse().toString();
    }
}

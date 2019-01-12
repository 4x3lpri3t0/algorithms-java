package LinkedLists;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/130005
public class AddIntegers {
    static Node addIntegers(Node integer1, Node integer2) {
        Node result = null;
        Node last = null;
        int carry = 0;

        while (integer1 != null || integer2 != null || carry > 0) {
            int first = (integer1 == null ? 0 : integer1.data);
            int second = (integer2 == null ? 0 : integer2.data);
            int sum = first + second + carry;
            Node pNew = new Node(sum % 10);
            carry = sum / 10;
            if (result == null) {
                result = pNew;
            } else {
                last.next = pNew;
            }

            last = pNew;
            if (integer1 != null) {
                integer1 = integer1.next;
            }
            if (integer2 != null) {
                integer2 = integer2.next;
            }
        }

        return result;
    }
}
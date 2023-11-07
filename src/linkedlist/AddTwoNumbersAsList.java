package linkedlist;

public class AddTwoNumbersAsList {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode C = new ListNode();
        ListNode D = C;
        int carryForward = 0;
        while(A != null && B != null) {
            int digitSum = carryForward + A.val + B.val;
            if(digitSum >= 10) {
                carryForward = digitSum/10;
                digitSum = digitSum%10;
            }
            else {
                carryForward = 0;
            }
            C.next = new ListNode(digitSum);
            A = A.next;
            B = B.next;
            C = C.next;
        }
        if(A !=null ) {
            while(A!=null) {
                int digitSum = carryForward + A.val;
                if(digitSum >= 10) {
                    carryForward = digitSum/10;
                    digitSum = digitSum%10;
                }
                else {
                    carryForward = 0;
                }
                C.next = new ListNode(digitSum);
                A = A.next;
                C = C.next;
            }
        }
        if(B !=null ) {
            while(B!=null) {
                int digitSum = carryForward + B.val;
                if(digitSum >= 10) {
                    carryForward = digitSum/10;
                    digitSum = digitSum%10;
                }
                else {
                    carryForward = 0;
                }
                C.next = new ListNode(digitSum);
                B = B.next;
                C = C.next;
            }
        }
        if(carryForward != 0) {
            C.next = new ListNode(carryForward);
        }

        return D.next;



    }
}

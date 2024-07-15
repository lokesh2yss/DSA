package designgurus;

public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "xz#z";
        String str2 = "xzz#";
        System.out.println(compare(str1, str2));
    }
    public static boolean compare(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int left=n-1, right=m-1;
        while(left >=0 && right >=0) {
            int backspaceCount = 0;
            while(left >=0 && str1.charAt(left) =='#') {
                backspaceCount++;
                left--;
            }
            left -= backspaceCount;
            backspaceCount = 0;
            while(right >=0 && str2.charAt(right) =='#') {
                backspaceCount++;
                right--;
            }
            right -= backspaceCount;
            System.out.println(left+" "+right);
            if(str1.charAt(left) == str2.charAt(right)) {
                left--;
                right--;
            }
            else {
                System.out.println("returning false");
                return false;
            }
        }
        if(left <=0 && right <=0)
            return true;
        return false;
    }
}

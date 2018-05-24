package practise;

/**
 * @author Ritesh Dalvi
 **/
public class StringValidator {

    public static boolean isValid(String str) {

        int length = str.length();
        if (length == 0) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            int j = i;

            if (i == 0 && !Character.isUpperCase(str.charAt(i))) {
                return false;
            }
            if (str.charAt(i) == '"') {
                count++;
            }
            if (str.charAt(i) == '.' && i != length - 1) {
                return false;
            }
            if ((int) str.charAt(i) >= 48 && (int) str.charAt(i) <= 57 && str.charAt(j++) == ' ') {
                return false;
            }
            if ((int) str.charAt(i) == 49 && (int) str.charAt(j++) <= 50) {
                return false;
            }
        }

        if (count % 2 != 0) {
            return false;
        }
        return true;
    }

    public static boolean isValidRecursion(String str) {

        String[] values = str.split(" ");

        String firstValue = values[0];

        if(!Character.isUpperCase(firstValue.charAt(0))) {
            return false;
        }

        String lastValue = values[values.length-1];

        if(lastValue.charAt(lastValue.length()-1) != '.') {
            return false;
        }

        Counter count = new Counter();

        boolean isValid = find(values, 0, values.length - 1, count);

        if(count.getCounter()%2 != 0) {
            return false;
        }

        return isValid;
    }

    private static boolean find(String[] values, int low, int high, Counter count) {

        if(high < low) {
            return true;
        }

        int mid = (low + high)/2;

        boolean isValid = isValid(values[mid],count);

        if(!isValid) {
            return false;
        }

        return find(values,low,mid-1,count) && find(values,mid+1,high,count);
    }

    private static boolean isValid(String str, Counter count) {
        int length = str.length();
        if(length == 0){
            return true;
        }
        for(int i=0; i<length; i++) {
            int j=i;

            if(str.charAt(i) == '"') {
                count.incrementCounter();
            }

            if((int)str.charAt(i) >= 48 && (int)str.charAt(i) <= 57 && str.charAt(j++) == ' ') {
                return false;
            }
            if ((int)str.charAt(i) == 49 && (int)str.charAt(j++) <= 50) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        long start = System.nanoTime();

        System.out.println("String is valid "+isValid("The quick brown fox said “hello Mr lazy dog”."));
        System.out.println("String is valid "+isValid("The quick brown fox said hello Mr lazy dog."));
        System.out.println("String is valid "+isValid("One lazy dog is too few, 13 is too many."));
        System.out.println("String is valid "+isValid("One lazy dog is too few, thirteen is too many."));

        System.out.println("String is valid "+isValid("The quick brown fox said \"hello Mr. lazy dog\"."));
        System.out.println("String is valid "+isValid("the quick brown fox said “hello Mr lazy dog\"."));
        System.out.println("String is valid "+isValid("\"The quick brown fox said “hello Mr lazy dog.\""));
        System.out.println("String is valid "+isValid("One lazy dog is too few, 12 is too many."));
        System.out.println("String is valid "+isValid("One lazy dog is too few, 22 is too many."));

        long end = System.nanoTime();

        System.out.println("Time Taken: " + (end-start));

        System.out.println("****-----***********");

        long newstart = System.nanoTime();

        System.out.println("String is valid "+isValidRecursion("The quick brown fox said “hello Mr lazy dog”."));
        System.out.println("String is valid "+isValidRecursion("The quick brown fox said hello Mr lazy dog."));
        System.out.println("String is valid "+isValidRecursion("One lazy dog is too few, 13 is too many."));
        System.out.println("String is valid "+isValidRecursion("One lazy dog is too few, thirteen is too many."));

        System.out.println("String is valid "+isValidRecursion("The quick brown fox said \"hello Mr. lazy dog\"."));
        System.out.println("String is valid "+isValidRecursion("the quick brown fox said “hello Mr lazy dog\"."));
        System.out.println("String is valid "+isValidRecursion("\"The quick brown fox said “hello Mr lazy dog.\""));
        System.out.println("String is valid "+isValidRecursion("One lazy dog is too few, 12 is too many."));
        System.out.println("String is valid "+isValidRecursion("One lazy dog is too few, 22 is too many."));

        long newend = System.nanoTime();

        System.out.println("Time Taken: " + (newend-newstart));

    }


   static class Counter {
        private int counter = 0;

        public void incrementCounter() {
            counter = counter + 1;
        }

        public int getCounter() {
            return counter;
        }
    }
}

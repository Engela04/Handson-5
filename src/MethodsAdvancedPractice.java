import java.util.Arrays;

public class MethodsAdvancedPractice {

    // Static variable untuk demonstrasi
    private static int counter = 0;

    // Instance variable untuk demonstrasi
    private String instanceName;

    // Constructor
    public MethodsAdvancedPractice(String name) {
        this.instanceName = name;
        counter++;
    }

    public static void main(String[] args) {
        System.out.println("=== METHOD SIGNATURE DAN DECLARATION ===");
        System.out.println("calculate(2, 3) = " + calculate(2, 3));
        System.out.println("calculate(2.5, 3.5) = " + calculate(2.5, 3.5));
        System.out.println("calculate(1, 2, 3) = " + calculate(1, 2, 3));
        System.out.println("calculate(\"Hello\", \" World\") = " + calculate("Hello", " World"));

        System.out.println("\n=== METHOD OVERLOADING ===");
        print(42);
        print(3.14);
        print("Java Overloading");
        print(new int[]{1, 2, 3, 4});

        System.out.println("\n=== STATIC VS INSTANCE METHODS ===");
        incrementCounter();
        System.out.println("Counter (static): " + getCounter());
        MethodsAdvancedPractice obj1 = new MethodsAdvancedPractice("Objek1");
        obj1.displayInfo();

        System.out.println("\n=== PASS BY VALUE - PRIMITIVES ===");
        int originalNumber = 10;
        System.out.println("Sebelum: " + originalNumber);
        modifyPrimitive(originalNumber);
        System.out.println("Sesudah: " + originalNumber);

        System.out.println("\n=== PASS BY VALUE OF REFERENCE - OBJECTS ===");
        int[] originalArray = {1, 2, 3, 4, 5};
        System.out.println("Sebelum: " + Arrays.toString(originalArray));
        modifyArray(originalArray);
        System.out.println("Sesudah: " + Arrays.toString(originalArray));

        int[] anotherArray = {10, 20, 30};
        System.out.println("Sebelum reassignment: " + Arrays.toString(anotherArray));
        reassignArray(anotherArray);
        System.out.println("Sesudah reassignment: " + Arrays.toString(anotherArray));

        System.out.println("\n=== ARRAY SEBAGAI PARAMETER DAN RETURN VALUE ===");
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Sorted copy: " + Arrays.toString(sortArrayCopy(numbers)));
        System.out.println("Stats (min,max,avg): " + Arrays.toString(getArrayStats(numbers)));
        System.out.println("Merged arrays: " + Arrays.toString(mergeArrays(numbers, new int[]{100, 200})));

        System.out.println("\n=== VARIABLE ARGUMENTS (VARARGS) ===");
        System.out.println("Sum(1,2,3,4,5) = " + sum(1,2,3,4,5));
        printInfo("Data Mahasiswa", 80, 90, 100);

        System.out.println("\n=== METHOD CHAINING ===");
        Calculator calc = new Calculator(10);
        double result = calc.add(5).multiply(2).subtract(4).getResult();
        System.out.println("Chaining result: " + result);

        System.out.println("\n=== RECURSIVE METHODS ===");
        System.out.println("Factorial(5) = " + factorial(5));
        System.out.println("Fibonacci(6) = " + fibonacci(6));
        int[] sortedArr = {10,20,30,40,50};
        System.out.println("Binary search 30 = " + binarySearchRecursive(sortedArr,30,0,sortedArr.length-1));

        System.out.println("\n=== UTILITY STATIC METHODS ===");
        System.out.println("Power(2,5) = " + MathUtils.power(2,5));
        System.out.println("isPrime(17) = " + MathUtils.isPrime(17));
        System.out.println("GCD(54,24) = " + MathUtils.gcd(54,24));
        System.out.println("Reverse('level') = " + StringUtils.reverse("level"));
        System.out.println("isPalindrome('level') = " + StringUtils.isPalindrome("level"));
        System.out.println("Word count('Halo dunia Java') = " + StringUtils.countWords("Halo dunia Java"));
        ArrayUtils.printMatrix(new int[][]{{1,2,3},{4,5,6}});
        System.out.println("Are arrays equal? " + ArrayUtils.areEqual(new int[]{1,2}, new int[]{1,2}));
    }

    // ===== METHOD OVERLOADING EXAMPLES =====
    public static int calculate(int a, int b) { return a + b; }
    public static double calculate(double a, double b) { return a + b; }
    public static int calculate(int a, int b, int c) { return a + b + c; }
    public static String calculate(String a, String b) { return a + b; }

    public static void print(int value) { System.out.println("Integer: " + value); }
    public static void print(double value) { System.out.println("Double: " + value); }
    public static void print(String value) { System.out.println("String: " + value); }
    public static void print(int[] array) { System.out.println("Array: " + Arrays.toString(array)); }

    // ===== STATIC VS INSTANCE METHODS =====
    public static int getCounter() { return counter; }
    public static void incrementCounter() { counter++; }
    public String getInstanceName() { return instanceName; }
    public void setInstanceName(String name) { this.instanceName = name; }
    public void displayInfo() {
        System.out.println("Instance Name: " + instanceName + ", Counter: " + counter);
    }

    // ===== PASS BY VALUE DEMONSTRATIONS =====
    public static void modifyPrimitive(int number) {
        number += 5;
        System.out.println("Di dalam method: " + number);
    }
    public static void modifyArray(int[] array) {
        if(array.length>0) array[0] = 999;
    }
    public static void reassignArray(int[] array) {
        array = new int[]{7,8,9};
    }

    // ===== ARRAY METHODS =====
    public static int[] sortArrayCopy(int[] original) {
        int[] copy = Arrays.copyOf(original,original.length);
        Arrays.sort(copy);
        return copy;
    }
    public static double[] getArrayStats(int[] array) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        double avg = Arrays.stream(array).average().getAsDouble();
        return new double[]{min, max, avg};
    }
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] merged = Arrays.copyOf(array1, array1.length+array2.length);
        System.arraycopy(array2,0,merged,array1.length,array2.length);
        return merged;
    }

    // ===== VARIABLE ARGUMENTS (VARARGS) =====
    public static int sum(int... numbers) {
        int total=0;
        for(int n:numbers) total+=n;
        return total;
    }
    public static void printInfo(String title, int... values) {
        System.out.println(title + ": " + Arrays.toString(values));
    }

    // ===== RECURSIVE METHODS =====
    public static long factorial(int n) {
        if(n<=1) return 1;
        return n*factorial(n-1);
    }
    public static int fibonacci(int n) {
        if(n<=1) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if(left>right) return -1;
        int mid=(left+right)/2;
        if(array[mid]==target) return mid;
        else if(array[mid]>target) return binarySearchRecursive(array,target,left,mid-1);
        else return binarySearchRecursive(array,target,mid+1,right);
    }

    // ===== UTILITY CLASSES =====
    public static class MathUtils {
        public static double power(double base, int exponent) {
            if(exponent==0) return 1;
            double result=1;
            for(int i=0;i<exponent;i++) result*=base;
            return result;
        }
        public static boolean isPrime(int number) {
            if(number<=1) return false;
            for(int i=2;i<=Math.sqrt(number);i++) if(number%i==0) return false;
            return true;
        }
        public static int gcd(int a, int b) {
            if(b==0) return a;
            return gcd(b,a%b);
        }
    }

    public static class StringUtils {
        public static String reverse(String str) {
            return new StringBuilder(str).reverse().toString();
        }
        public static boolean isPalindrome(String str) {
            return str.equals(reverse(str));
        }
        public static int countWords(String str) {
            if(str==null||str.trim().isEmpty()) return 0;
            return str.trim().split("\\s+").length;
        }
    }

    public static class ArrayUtils {
        public static void printMatrix(int[][] matrix) {
            System.out.println("Matrix:");
            for(int[] row:matrix) System.out.println(Arrays.toString(row));
        }
        public static int[] findDuplicates(int[] array) {
            return Arrays.stream(array).distinct().toArray(); // sederhana
        }
        public static boolean areEqual(int[] array1, int[] array2) {
            return Arrays.equals(array1,array2);
        }
    }

    // ===== METHOD CHAINING EXAMPLE =====
    public static class Calculator {
        private double value;
        public Calculator(double initial) { this.value = initial; }
        public Calculator add(double n) { this.value+=n; return this; }
        public Calculator multiply(double n) { this.value*=n; return this; }
        public Calculator subtract(double n) { this.value-=n; return this; }
        public double getResult() { return value;}
    }
}
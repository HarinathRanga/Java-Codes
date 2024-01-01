import java.util.*;

class array1d {
    public static void printArray(int ar[]) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    public static void reverse(int nums[]) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;

            start++;
            end--;
        }
    }

    public static void printPairs(int ar[]) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                System.out.print("(" + ar[i] + "," + ar[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void printAllSubArrays(int ar[]) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(ar[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int getMaxSubArraySum_prefix(int ar[]) {
        int prefix[] = new int[ar.length];
        prefix[0] = ar[0];
        for (int i = 1; i < ar.length; i++) {
            prefix[i] = prefix[i - 1] + ar[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i; j < ar.length; j++) {
                int currentSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (max < currentSum) {
                    max = currentSum;
                }
            }
        }
        return max;
    }

    public static void kadanes(int ar[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < ar.length; i++) {
            cs += ar[i];
            if (ms < cs) {
                ms = cs;
            }
            if (cs < 0) {
                cs = 0;
            }
        }
        System.out.println(ms);
    }

    public static int trappedRainWater(int h[]) {
        int n = h.length;
        int leftmax[] = new int[n];
        leftmax[0] = h[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], h[i]);
        }

        int rightmax[] = new int[n];
        rightmax[n - 1] = h[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], h[i]);
        }

        int tw = 0;
        for (int i = 0; i < n; i++) {
            int wl = Math.min(leftmax[i], rightmax[i]);
            tw += wl - h[i];
        }
        return tw;
    }

    public static int maxStockProfit(int ar[]) {
        int bp = Integer.MAX_VALUE;
        int maxP = 0;
        for (int i = 0; i < ar.length; i++) {
            if (bp < ar[i]) {
                int prof = ar[i] - bp;
                maxP = Math.max(maxP, prof);
            } else {
                bp = ar[i];
            }
        }
        return maxP;
    }

    public static void main(String[] args) {
        int ar[] = { 14, 20, 4, 12, 5, 11 };
        System.out.println(maxStockProfit(ar));

    }
}
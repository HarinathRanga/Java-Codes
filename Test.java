import java.util.*;
import java.util.LinkedList;
class test{
    public static int isVowel(char ch){
         if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return 1;
         }
         return 0;
    }
    public static long countSpecial(String str)
    {
        long cnt = 0;
        int n = str.length();
 
        // in case of single character or empty string
        // we can't fulfill the given condition , hence the
        // count is 0.
        if (n == 1 || n == 0)
            return 0;
 
        // variables to store count of total vowels and
        // consonants in the string
        long vow = 0, cons = 0;
 
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            vow += isVowel(ch);
        }
        cons = n - vow;
 
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            // as we encounter a vowel, we add no. of
            // consonants after it to our answer
            // and decrease the value of vow by 1,
            // indicating that now the remaining
            // string has one vowel less than current string
            if (isVowel(ch) == 1) {
                vow--;
                cnt += cons;
            }
            // same case as above for consonants
            else {
                cons--;
                cnt += vow;
            }
        }
 
        // finally we return the cnt as our answer
        return cnt;
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> terminals=new ArrayList<>();
        Map<Integer,ArrayList<Integer>> incommings=new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(graph[i].length==0){
                terminals.add(i);
                continue;
            }
            for(int j=0;j<graph[i].length;j++){
                if(incommings.containsKey(graph[i][j])){
                    incommings.get(graph[i][j]).add(i);
                } else {
                    incommings.put(graph[i][j],new ArrayList<>());
                    incommings.get(graph[i][j]).add(i);
                }
            }
        }
        System.out.println(incommings.get(5));
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<terminals.size();i++){
            int ter=terminals.get(i);
            if(incommings.containsKey(ter)){
                ArrayList<Integer> arr=incommings.get(ter);
                for(int j=0;j<arr.size();j++){
                    ans.add(arr.get(j));
                }
            }
            ans.add(ter);
        }
        return ans;
    }
    public static boolean checkPalindrome(String s){
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int odd=0;
        for(int i=0;i<26;i++){
            if(count[i]%2!=0){
                odd++;
            }
        }
        if(odd>1){
            return false;
        }
        return true;
    }
    public static long countCompPairs(String stringData[]){
        int n=stringData.length;
        long ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(checkPalindrome(stringData[i]+stringData[j])){
                    ans++;
                }
            }
        }
        return ans;
    }
    public int findPin(int input1,int input2,int input3,int input4){
        int a1=getLarge(input1);
        int a2=getSmall(input1);
        int b1=getLarge(input2); 
        int b2=getSmall(input2); 
        int c1=getLarge(input3); 
        int c2=getSmall(input3); 
        return ((a1*a2)+(b1*b2)+(c1*c2))-input4;
    }
    public int getSmall(int n){
        int ans=9;
        while(n>0){
            int d=n%10;
            if(d<ans){
                ans=d;
            }
            n/=10;
        }
        return ans;
    }
    public int getLarge(int n){
        int ans=0;
        while(n>0){
            int d=n%10;
            if(d>ans){
                ans=d;
            }
            n/=10;
        }
        return ans;
    }
    
    public static int findSumOfPrimes(int input1[],int input2){
        int sum=0;
        int n=input2;
        for(int i=0;i<n;i++){
            if(!isPrime(i)){
                sum+=input1[i];
            }
        }
        return sum;
    }
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static int findSum(int arr[],int n){
        int sum=0;
        int small=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(arr[i]<small){
                small=arr[i];
            }
        }
        return sum-small;
    }
    public static int findMaximumPetalsSum(int[] petals) {
        // Sort the petals in descending order
        Arrays.sort(petals);
        reverseArray(petals);

        // Initialize variables to store the sum and a flag for whether the result is "Loves"
        int totalPetals = 0;
        boolean lovesFlag = true;

        // Iterate through the petals and calculate the total sum while maintaining the "Loves" flag
        for (int petal : petals) {
            if (lovesFlag) {
                totalPetals += petal;
            }
            lovesFlag = !lovesFlag;
        }

        return totalPetals;
    }

    // Helper function to reverse the array in place
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of chamomiles: ");
        int n = scanner.nextInt();

        int[] petals = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the number of petals for chamomile " + (i + 1) + ": ");
            petals[i] = scanner.nextInt();
        }

        int maxPetalsSum = findMaximumPetalsSum(petals);
        System.out.println("The maximum number of petals possible in the bouquet and the result is 'Loves' is: " + maxPetalsSum);
    }
}

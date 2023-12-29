import java.util.*;
class Stacks{
    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        s.push(0);
        span[0]=1;

        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice >= stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            } else {
                span[i]=i-s.peek();
            }
            s.push(i);
        }
    }
    public static void rightGrater(int arr[],int rightG[]){
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            int curr=arr[i];
            while(!s.isEmpty() && curr>=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                rightG[i]=-1;
            } else {
                rightG[i]=s.peek();
            }
            s.push(i);
        }
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int nsl[]=new int[heights.length];
        int nsr[]=new int[heights.length];
        // finfing Next Smaller To Left
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            } else {
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        s = new Stack<>(); 
        // finding Next Smaller To Right
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=heights.length;
            } else {
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        int ans=0;
        for(int i=0;i<heights.length;i++){
            System.out.println(nsr[i]+" "+nsl[i]+" "+heights[i]);
            int area=(nsr[i]-nsl[i]-1)*heights[i];
            ans=Math.max(ans,area);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={ 2,1,5,6,2,3 };
        System.out.println(largestRectangleArea(arr));
        
    }
}
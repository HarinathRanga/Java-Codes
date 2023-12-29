import javax.print.attribute.standard.PDLOverrideSupported;

public class BitManuplation {
    public static int getIthBit(int n,int i){
        int bitMask=1<<i;
        if((n&bitMask)==0){
            return 0;
        }
        return 1;
    }
    public static int setIthBit(int n,int i){
        int bitMask=1<<i;
        return n|bitMask;
    }
    public static int clearIthBit(int n,int i) {
        int bitMask=~(1<<i);
        return n&bitMask;
    }
    public static int updateIthBit(int n,int i,int newBit) {
        if(newBit==0){
            return clearIthBit(n,i);
        }
        return setIthBit(n,i);
    }
    public static int clearIBits(int n,int i){
        int bitMask=(~0)<<i;
        return n & bitMask;
    }
    public static int clearIBits(int n,int i,int j){
        int a=(~0)<<(j+1);
        int b=(1<<i)-1;
        int bitMask= a | b;
        return n & bitMask;
    }
    public static boolean isPowerOfTwo(int n) {
        return (n&(n-1))==0;
    }
    public static int countSetBits(int n){
        int count=0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static int power(int a,int b){
        int ans=1;
        while(b>0){
            if((b&1)==1){
                ans*=a;
            }
            a=a*a;
            b=b>>1;
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(power(4,3));
    }
}
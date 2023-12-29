import java.util.*;

class Recursion {
    public static void printDec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int calSum(int n){
        if(n==0){
            return 0;
        }
        return n+calSum(n-1);
    }

    public static long fib(int n){
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static boolean isSorted(int ar[],int i){
        if(i==ar.length-1){
            return true;
        }
        if(ar[i]>ar[i+1]){
            return false;
        }
        return isSorted(ar,i+1);
    }

    public static int firstOccurance(int ar[],int key,int i){
        if(i==ar.length){
            return -1;
        }
        if(ar[i]==key){
            return i;
        }
        return firstOccurance(ar,key,i+1);
    }

    public static int lastOccurance(int ar[],int key,int i){
        if(i==ar.length){
            return -1;
        }
        int x=lastOccurance(ar, key, i+1);
        if(x==-1 && ar[i]==key){
            return i;
        }
        return x;
    }

    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return x*power(x,n-1);
    }

    public static int optimizedPower(int a,int n){
        if(n==0){
            return 1;
        }
        int half=optimizedPower(a, n/2);
        int halfSq=half*half;
        if(n%2!=0){
            halfSq*=a;
        }
        return halfSq;
    }

    public static int tilingProblem(int n){
        if(n==0 || n==1){
            return 1;
        }
        int fnm1=tilingProblem(n-1);
        int fnm2=tilingProblem(n-2);
        return fnm1+fnm2;
    }

    public static void removeDublicate(String str,int idx,StringBuilder sb,boolean map[]){
        if(idx==str.length()){
            System.out.println(sb);
            return;
        }
        char currChar=str.charAt(idx);
        if(map[currChar-'a']==true){
            removeDublicate(str, idx+1, sb, map);
        } else {
            map[currChar-'a']=true;
            removeDublicate(str, idx+1, sb.append(currChar), map);
        }
        // boolean map[]=new boolean[26];
        // removeDublicate("appnnacollege", 0, new StringBuilder(), map);
    }

    public static int friendsPairing(int n){
        if(n==1 || n==2){
            return n;
        }
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    public static void printBinString(int n,int lastdigi,StringBuilder str){
        if(n==0){
            System.out.println(str);
            str.delete(str.length()-1,str.length());
            return;
        }
        printBinString(n-1, 0, str.append('0'));
        if(lastdigi==0){
            printBinString(n-1, 1, str.append('1'));
        }
        if(str.length()>0){
            str.delete(str.length()-1,str.length());
        }
    }

    public static void allOccurance(int ar[],int idx,int key){
        if(idx==ar.length){
            return;
        }
        if(ar[idx]==key){
            System.out.print(idx+" ");
        }
        allOccurance(ar, idx+1, key);
        // int ar[]={3,2,4,5,6,2,7,2,2};
        // allOccurance(ar, 0, 2);
    }
    public static void printEnglish(int n,String digits[]){
        if(n==0){
            return;
        }
        printEnglish(n/10,digits);
        System.out.print(digits[n%10]+" ");
        // String digits[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        // printEnglish(1973, digits);
    }
    public static int length(String str){
        if(str.length()==0){
            return 0;
        }
        return length(str.substring(1))+1;
    }

    public static void main(String[] args) {
        printBinString(3, 0, new StringBuilder(""));
    }
}
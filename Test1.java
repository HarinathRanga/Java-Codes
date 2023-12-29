class Test1{
    public static String find(String input1,int input2){
        if(input1.length()==0){
            return "NULL";
        }
        if(input2==0){
            boolean check=false;
            Integer ans=0;
            for(int i=0;i<input1.length();i++){
                char ch=input1.charAt(i);
                if(ch>='0' && ch<='9'){
                    ans+=(ch-'0');
                    check=true;
                }
            }
            if(check){
                return ans.toString();
            }
            return "ZERO";
        } else {
            boolean check=false;
            StringBuilder str=new StringBuilder("");
            for(int i=0;i<input1.length();i++){
                char ch=input1.charAt(i);
                if(!(ch>='0' && ch<='9')){
                    str.append(ch);
                    check=true;
                }
            }
            if(check){
                return str.toString();
            }
            return "ZERO";
        }
    }
    public static String question2(String input1,int input2){
        StringBuilder str=new StringBuilder("");
        if(input2==0){
            for(int i=0;i<input1.length();i++){
                if(i%2==0){
                    char ch=input1.charAt(i);
                    if(ch>='a'){
                        str.append(Character.toUpperCase(ch));
                    } else {
                        str.append(Character.toLowerCase(ch));
                    }
                }
            }
        } else if(input2==1){
            for(int i=0;i<input1.length();i++){
                if(i%2!=0){
                    char ch=input1.charAt(i);
                    if(ch>='a'){
                        str.append(Character.toUpperCase(ch));
                    } else {
                        str.append(Character.toLowerCase(ch));
                    } 
                }
            }
        } else {
            for(int i=input1.length()-1;i>=0;i--){
                char ch=input1.charAt(i);
                if(ch>='a'){
                    str.append(Character.toUpperCase(ch));
                } else {
                    str.append(Character.toLowerCase(ch));
                }
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        int input1=5;
        int a=0;
        int b=1;
        int count =2;
        if(input1==0 || input1==1){
            return input1+1;
        }
        while(true){
            int sum=a+b;
            count++;
            if(sum==input1){
                System.out.println(count);
                break;
            }
            a=b;
            b=sum;
        }
    }
}
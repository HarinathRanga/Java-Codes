import java.util.*;

class conditions{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int var=sc.nextInt();
        switch (var) {
            case 1:
                System.out.println("Hello");
                break;
            case 2:
                System.out.println("Namestee");
                break;
            case 3:
                System.out.println("Hi");
                break;
        
            default:
                System.out.println("Enter correct choice");
                break;
        }

    }
}
import java.util.*;
class Arraylist{
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(12);
        list.remove(3);
        System.out.println(list.contains(10));
        System.out.println(list);
    }
}
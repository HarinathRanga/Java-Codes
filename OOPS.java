public class OOPS {
    public static void main(String[] args) {
        Students s1=new Students();
        s1.schoolName="JVM";
        Students s2=new Students();
        System.out.println(s2.schoolName);
        s2.schoolName="ABC";
        System.out.println(s1.schoolName);
    }
}

class Students {
    String name;
    int rollno;

    static String schoolName;

    String getName(){
        return this.name;
    }
    void setName(String name){
        this.name=name;
    }
}

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves(){
        System.out.println("up , down , left , right , diagonal in all directions");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up , down , left , right , diagonal - by one step");
    }

    // King k=new King();
    // k.moves();
    // Queen q=new Queen();
    // q.moves();
}

abstract class Animal {
    Animal() {
        System.out.println("Animal con");
    }

    void eat(){
        System.out.println("Animal eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse(){
        System.out.println("Horse con");
    }

    void walk(){
        System.out.println("Walks with 4 legs");
    }
    // Horse h=new Horse();
    //     h.eat();
    //     h.walk();
}

class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang con");
    }

    //Mustang m=new Mustang();
}


class Calculator {
    int sum(int a,int b) {
        return a+b;
    }

    int sum(int a,int b,int c) {
        return a+b+c;
    }

    float sum(float a,float b) {
        return (a+b);
    }

        // Calculator cal=new Calculator();
        // System.out.println(cal.sum(1,2));
        // System.out.println(cal.sum(1,2,3));
        // System.out.println(cal.sum((float)1.2,(float)3.6));

}

class Animals{
    String color;
    
    void breathe(){
        System.out.println("breathes");
    }

    void eat(){
        System.out.println("Eats");
    }
}

class mammel extends Animals {
    int legs;
}

class Dog extends mammel {
    String breed;

    void walk(){
        System.out.println("Walks with four legs");
    }
}

        // Dog leo=new Dog();
        // leo.breathe();
        // leo.walk();
        // leo.legs=4;

    // single in heritance
// class Fish extends Animals {
//     int fins;


//     void swim(){
//         System.out.println("Swims");
//     }
// }

class Student {
    String name;
    int rollno;
    int marks[];
    String password;
    Student (Student s1){
        marks=new int[3];
        this.name=s1.name;
        this.rollno=s1.rollno;
        this.marks=s1.marks;
    }
    Student (){
        marks=new int[3];
        System.out.println("Constructor is called...");
    }

    // main()
    // Student s1=new Student();
        // s1.name="Harinath";
        // s1.rollno=1213;
        // s1.marks[0]=80;
        // s1.marks[1]=100;
        // s1.marks[2]=90;
        // Student s2=new Student(s1);
        // s1.marks[2]=20;
        // // System.out.println(s2.name);
        // // System.out.println(s2.rollno);
        // for(int i=0;i<3;i++){
        //     System.out.println(s2.marks[i]);
        // }
}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String newPass) {
        password=newPass;
    }
        // Access Modifiers
        // BankAccount b1=new BankAccount();
        // b1.username="hari@123";
        // // b1.password="Hari@1234";
        // System.out.println(b1.username);
        // b1.setPassword("Hari@1234");
}

class Pen {
    String color;
    int tip;

    void setColor(String newColor){
        color=newColor;
    }
    void setTip(int newTip) {
        tip=newTip;
    }


        // Class and Objects
        // Pen p1=new Pen();
        // p1.setColor("Blue");
        // p1.setTip(5);
        // System.out.println(p1.color);
        // System.out.println(p1.tip);
        // // p1.setColor("Green");
        // // p1.setTip(2);
        // p1.color="Green";
        // p1.tip=2;
        // System.out.println(p1.color);
        // System.out.println(p1.tip);
}
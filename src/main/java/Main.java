import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter a name :");
        String name = input.next();
        System.out.print("enter the assistance name  :");
        String assist = input.next();
        System.out.print("enter the age :");
        String age  = input.next();
        Visitor v = new Visitor();
        //removed
        v.setFullName(name);
        v.setAge(Integer.parseInt(age));
        v.setAssist(assist);
        v.setDate(LocalDate.now());
        v.setTime(LocalTime.now());
        v.save();
        try {
            v.load("Alice Cooper");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
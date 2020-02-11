import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class Visitor {
    Logger VisitorLog = LogManager.getLogger(Visitor.class);
    private String fullName;
    private int age;
    private LocalDate date;
    private LocalTime time;
    private String assist;

    public void setFullName(String Name) {
        this.fullName = Name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setAssist(String assistance) {
        this.assist = assistance;
    }

    public void save(){

        StringBuilder writer = new StringBuilder();
        writer.append("full names: "+fullName + "\n").append(" ").append("Age: "+age+"\n")
                .append(" ").append("Date: "+date+"\n")
                .append(" ").append("Time: "+time+"\n").append(" ")
                .append("Assisted by:"+assist+" ");

        String full_Name = fullName.replace(" ", "_");

        String fileName = "visitor_{"+full_Name+"}.txt";
        int obj[] = new int[3];

        File myObj = null;
        try {

            myObj = new File(fileName);
            if(myObj.createNewFile()) {
                Files.write(Paths.get(fileName),String.valueOf(writer).getBytes());

            }
            else
                System.out.println ("File already exist");


        } catch (IOException e) {

            VisitorLog.info(e);
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        VisitorLog.info(writer);

    }

    public String load(String searchFile) throws IOException
    {

        String full_Name = searchFile.replace(" ", "_");

        String fileName = "visitor_{"+full_Name+"}.txt";
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(fileName));
            String input;
            while ((input = file.readLine()) !=null) {
                System.out.println(input);
            }

        } catch (IOException e) {
            VisitorLog.error(e);
            e.printStackTrace();

        }
        return fileName;
    }
}
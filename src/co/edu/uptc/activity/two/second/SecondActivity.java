package co.edu.uptc.activity.two.second;

import java.io.*;

public class SecondActivity {

    private static Person readPerson(String path){
        Person person = new Person();
        File file = new File(path);
        try(DataInputStream stream = new DataInputStream(new FileInputStream(path))){

            person.setId(stream.readLong());
            person.setFullName(stream.readUTF());
            person.setPhoneNumber(stream.readUTF());
            person.setSalary(stream.readDouble());
            person.setAge(stream.readInt());

        }catch (Exception e){
            System.err.println(e.getStackTrace());
        }
        return person;
    }

    private static String revertFullName(String fullName, String useDecode){
        StringBuilder builder = new StringBuilder();
        String[] names = fullName.split(useDecode);

        for (int i = names.length-1; i >= 0; i--) {
            builder.append(names[i]).append(" ");
        }

        return builder.toString();
    }

    private static int newAge(int age){
        int newAge = age -10;
        return newAge;
    }

    private static long newId(long id){
        long newId = id * 2;
        return newId;
    }
    private static double newSalary(double salary){
        double newSalary = salary / 2;
        return newSalary;
    }



    private static void writeNewPerson(String path, Person  person){
        try{
            DataOutputStream stream = new DataOutputStream(new FileOutputStream(path));

            stream.writeUTF(person.getFullName());
            stream.writeDouble(person.getSalary());
            stream.writeInt(person.getAge());
            stream.writeUTF(person.getPhoneNumber());
            stream.writeLong(person.getId());
            stream.close();

        }catch (IOException e){
            System.err.println(e.getStackTrace());
        }
    }

    public static void main(String[] args) {

        Person oldPerson = readPerson("src/resources/input/person.bin");
        oldPerson.setFullName(revertFullName(oldPerson.getFullName(), " "));
        oldPerson.setAge(newAge(oldPerson.getAge()));
        oldPerson.setId(newId(oldPerson.getId()));
        oldPerson.setSalary(newSalary(oldPerson.getSalary()));
        System.out.println("Edad " + newId(oldPerson.getId()));
        System.out.println("number " + oldPerson.getPhoneNumber());
        writeNewPerson("src/resources/output/new-person.ddr", oldPerson);

    }

}

//package Gsonpackage;

import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GsonImpl implements GsonInter {
    private Scanner sc = new Scanner(System.in);
    private File file = new File("Doniyor.txt");
    Gson gson = new Gson();
    @Override
    public void addUser() {
        System.out.println(" Enter Name ");
        sc = new Scanner(System.in);
        String name =  sc.nextLine();
        System.out.println(" Enter Password ");
        sc = new Scanner(System.in);
        String password =  sc.nextLine();
        GsonClass gsonClass = new GsonClass(name,password);
        List<GsonClass> stringList = GsonReturn.readGson(file);
        if (stringList==null){
            stringList = new ArrayList<>();
        }
       stringList.add(gsonClass);
        String s = gson.toJson(stringList);
        GsonReturn.WriteGson(file,s);

    }

    @Override
    public void editUser() {
        List<GsonClass> stringList = GsonReturn.readGson(file);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println((i+1) + " -> " + stringList.get(i).getName());
        }
        System.out.println(" Siz qaysi nameni ozgartimoqchisiz ? ");
        int n =  sc.nextInt();
        System.out.println(" Yangi nameni kiriting ");
        sc = new Scanner(System.in);
        String newName = sc.nextLine();
        System.out.println(" Yangi password kiriting ");
        String n1 = sc.nextLine();
        stringList.get(n-1).setName(newName);
        stringList.get(n-1).setPassword(n1);
        String s = gson.toJson(stringList);
        GsonReturn.WriteGson(file,s);


    }

    @Override
    public void allUser() {
        List<GsonClass> stringList = GsonReturn.readGson(file);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }

    }

    @Override
    public void searchUser() {
        List<GsonClass> stringList = GsonReturn.readGson(file);
        System.out.println(" Ism yoki parolni kiting ");
        String nameOrpassword = sc.nextLine();
        for (int i = 0; i < stringList.size(); i++) {
        if (stringList.get(i).getName().toLowerCase().contains(nameOrpassword) || stringList.get(i).getPassword().toLowerCase().contains(nameOrpassword)){
            System.out.println(stringList.get(i).getName() + " " + stringList.get(i).getPassword());
        }
        }

    }

    @Override
    public void deleteUser() {
        List<GsonClass> stringList = GsonReturn.readGson(file);
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println((i+1) + " -> " + stringList.get(i));
        }
        System.out.println(" o'chirayrdigon nameni tanglang ");
        int n= sc.nextInt();
        stringList.remove(n-1);
        GsonReturn.WriteGson(file,gson.toJson(stringList));


    }
}

//package Gsonpackage;

//import Gsonpackage.GsonImpl;
//import Gsonpackage.GsonInter;

import java.util.Scanner;

public class GsonMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GsonInter gsonInter = new GsonImpl();
        while (true){
            System.out.println(" 1-> Add user " +
            " 2-> Edit user " +
            " 3-> All user " +
            " 4-> Search user ");
            int n =  sc.nextInt();
            switch (n){
                case 1:
                    gsonInter.addUser();
                    break;
                case 2:
                    gsonInter.editUser();
                    break;
                case 3:
                    gsonInter.allUser();
                    break;
                case 4:
                    gsonInter.searchUser();
                    break;
                case 5:
                    gsonInter.deleteUser();
                    break;
            }
        }

    }
}

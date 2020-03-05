//package Gsonpackage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class GsonReturn {

    public  static  void WriteGson(File file, String text){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  static List<GsonClass> readGson(File file){
        List<GsonClass> gsonClasslist = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileInputStream fileInputStream =new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            while ((row = bufferedReader.readLine()) !=null){
                stringBuilder.append(row);
            }
            bufferedReader.close();
            fileInputStream.close();
            Type type = new TypeToken<List<GsonClass>>() {}.getType();
            Gson gson = new Gson();
            gsonClasslist = gson.fromJson(stringBuilder.toString(), type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gsonClasslist;


    }
}

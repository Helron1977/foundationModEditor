package fr.foundation.modwizard.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

public abstract class Model {


    public abstract String toString();

   public static String generateCode(Building buildingToCode) throws IllegalAccessException {
        //Store the class of the asset
        Class<? extends Building> test = buildingToCode.getClass();

        //Store the param of the asset in a Field[]
        Field[] params = test.getDeclaredFields();

        //Collection of asset's params , objects
        LinkedHashMap<String,Object> structure = new LinkedHashMap<String, Object>(){
            @Override
            public String toString() {
                //change [ to {
                String step01 =super.toString().replace("[","{");
                //change ] to }
                String step02= step01.replace("]","}");
                // add /n at the end of each "String",
                String step04= step02.replace("\",","\",\n");
                // add /n at the end of each list
                String step05= step04.replace("},","},\n");
                // add /n between 2 {{ case begin a list of list
                String step06 = step05.replace("{{","{\n\t{");
                // add /n between 2 } case end list of list
                String step07= step06.replace("}},","}\n},");


                return step07.toString();
            }
        } ;

        for (Field param : params) {
            if (param.getType().toString().contains("String")) {
                structure.put(param.getName(), "\"" + param.get(buildingToCode) + "\"");
            } else {
                structure.put(param.getName(), param.get(buildingToCode));
            }

        }

        //store the code
        String code = structure.toString();


        //Display the Lua code
        System.out.println(structure.toString());



        //export file
        File myFile = new File("C:\\Users\\Roland\\Desktop\\tmp/building.lua");

        try {

            // open an output stream that create the file
            Writer writer = new FileWriter(myFile);

            writer.write(structure.toString());

            writer.close();
        } catch (IOException e) {

            // affichage du message d'erreur et de la pile d'appel
            System.out.println("Erreur " + e.getMessage()) ;
            e.printStackTrace() ;
        }

        return code;

    }
}

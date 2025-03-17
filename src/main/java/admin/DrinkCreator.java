package admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DrinkCreator implements MenuCreator{
    ArrayList<MenuItem> drinks = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void addMenuItem(MenuItem menuItem){
        drinks.add(menuItem);
    }

    @Override
    public void toJson() throws IOException {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("src/main/resources/json/Drinks.json"), drinks);
    }
}

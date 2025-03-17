package admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HamburgerCreator implements MenuCreator {
    ArrayList<MenuItem> hamburgers = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void addMenuItem(MenuItem menuItem){
        while(true) {
            int i = 0;
            hamburgers.add(menuItem);

            if(hamburgers.get(i).getName().isEmpty()){
                break;
            } else {
                i++;
            }
        }
    }

    @Override
    public void toJson()throws IOException {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonDir = System.getProperty("user.dir") + "/data/json";
        File directory = new File(jsonDir);
        if (!directory.exists()) {
            directory.mkdirs();  // 폴더가 없으면 생성
        }
        objectMapper.writeValue(new File(jsonDir + "/Hamburger.json"), hamburgers);
    }
}

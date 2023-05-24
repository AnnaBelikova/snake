package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {

        Field field = new Field(9,9, 7);

        Viewer viewer = new Viewer();

        Commander commander = new Commander();

        viewer.createField(field);

        while (true) {

            Commander.Sites command = commander.getCommand();

            field.updateField(command);

            if(field.ifIsLooser()){
                viewer.printLooser();
            }else{
                viewer.printField(field);
            }

        }

    }
}

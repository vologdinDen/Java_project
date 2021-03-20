import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

public class Main {

    final static ArrayList<IMG> images_arr = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Scanner in = new Scanner(System.in);
        String xml_path;
        Document document;
        while (true){
            System.out.print("Введите путь до xml-файла:");
            xml_path = in.nextLine();
            try {
                document =  builder.parse(new File(xml_path));
                break;
            }catch (IOException e){
                System.out.println("Файла по такому пути нет");
            }
            catch (SAXException ex){
                System.out.println("Вы ввели что-то не то");
            }
        }

        NodeList images = document.getDocumentElement().getElementsByTagName("image");

        for(int i = 0; i < images.getLength(); i++){
            Node node = images.item(i);

            NamedNodeMap attributes = node.getAttributes();

            images_arr.add(new IMG(attributes.getNamedItem("id").getNodeValue(), attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("width").getNodeValue(), attributes.getNamedItem("height").getNodeValue()));
        }

        JSONObject new_json = new JSONObject();


        for(IMG img : images_arr){
            JSONObject put_json = new JSONObject();
            put_json.put("id", img.get_id());
            put_json.put("height", img.get_height());
            put_json.put("width", img.get_width());
            new_json.put(img.get_name(), put_json);
        }

        String save_path;

        while (true){
            System.out.print("Введите путь для сохранения:");
            save_path = in.nextLine();
            try(FileWriter file = new FileWriter(save_path)){
                file.write(new_json.toString());
                break;
            }catch (IOException e){
                System.out.println("Такого пути нет!");
            }
        }


    }

}


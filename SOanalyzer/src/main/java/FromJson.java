import com.google.gson.JsonParser;
import org.json.*;
import weka.core.converters.ArffSaver;

import java.io.*;


public class FromJson {
    public static void main(String[] args) {

        // The name of the file to open.
        DataInstances instances = new DataInstances();
        String fileName = "versions.json";
        JsonParser parser = new JsonParser();

        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                JSONObject obj = null;
                try
                {
                    obj = new JSONObject(line);
                    instances.addInstance(obj);
                }
                catch ( Exception e)
                {
                    e.printStackTrace();
                }
            }
            // Always close files.
            bufferedReader.close();
            ArffSaver saver = new ArffSaver();
            saver.setInstances(instances.data);
            saver.setFile(new File("versions.arff"));
            saver.writeBatch();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

//        System.out.println("Working Directory = " +
//                System.getProperty("user.dir"));
//        JsonParser paser = new JsonParser();
//        try {
//            JSONLoader loader = new JSONLoader();
//            loader.setSource(new File("posts0324.json"));
//            Instances data = loader.getDataSet();
//            // setting class attribute if the data format does not provide this information
//            // For example, the XRFF format saves the class attribute information as well
//            if (data.classIndex() == -1)
//                data.setClassIndex(data.numAttributes() - 1);
//            ArffSaver saver = new ArffSaver();
//            saver.setInstances(data);
//            saver.setFile(new File("posts.arff"));
//            saver.writeBatch();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ArffLoader.ArffReader;
import weka.core.converters.ConverterUtils.DataSource;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String file_name_input = "C:\\Users\\34463\\Documents\\words_alpha.txt";
		BufferedReader in = null;
		in = new BufferedReader(new FileReader(file_name_input));
		String currentLine= "";
		HashSet<String> hashSet = new HashSet<>();
		int total_words = 0;
		while((currentLine= in.readLine())!=null) 
		{
			hashSet.add(currentLine);
			total_words++;
		}
		
		BufferedReader reader =  new BufferedReader(new FileReader("C:\\Users\\34463\\Documents\\without_wordsFilter.arff"));
		ArffReader arff = new ArffReader(reader);
		Instances dataset = arff.getData();
		int num_of_instances = dataset.numInstances();
		String tmp_value = "";
		
		long beginTime = System.currentTimeMillis();  
		for( int i=0;i<num_of_instances;i++) 
		{	
			tmp_value = dataset.instance(i).stringValue(22);
			String [] arr = tmp_value.split("[\\s%&',;=?$\\\\^]+");
			String tmp_2 = " ";
			for(String s: arr) 
			{	
				if(hashSet.contains(s)) 
				{	
					tmp_2 = tmp_2 + " " + s;
				}	
			}
			dataset.renameAttributeValue(22,i,tmp_2);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-beginTime);
		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		String outputFile_name = "C:\\Users\\34463\\Documents\\data_process_with_wordsFilter.arff";
		saver.setFile(new File(outputFile_name));
		saver.writeBatch();
	}

}

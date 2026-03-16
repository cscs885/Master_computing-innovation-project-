package unused;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ArffLoader.ArffReader;

public class Words_filter_in {
	

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		String file_name_input = "C:\\Users\\34463\\Documents\\words+tags.txt";
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
		
		BufferedReader reader =  new BufferedReader(new FileReader("C:\\Users\\34463\\Documents\\RawData2(PurifiedText)\\RawData2(PurifiedText).arff"));
		ArffReader arff = new ArffReader(reader);
		Instances dataset = arff.getData();
		int num_of_instances = dataset.numInstances();
		System.out.println(num_of_instances);
		String tmp_value = "";
		
		long beginTime = System.currentTimeMillis();  
		for( int i=0;i<num_of_instances-10;i++) 
		{	
			tmp_value = " ";
			tmp_value = dataset.attribute(27).value(i);
			//System.out.println(tmp_value);
			String [] arr = tmp_value.split("[\\s#-\\%&.({!<',;=?$\\\\^]+");
			String tmp_2 = " ";
			for(String s: arr) 
			{	
				if(hashSet.contains(s)) 
				{	
					tmp_2 = tmp_2 + " " + s;
				}
			}
			dataset.renameAttributeValue(27,i,tmp_2);
		}
		long endTime = System.currentTimeMillis();
		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		String outputFile_name = "C:\\Users\\34463\\Documents\\RawData3(WordsFilterer).arff";
		saver.setFile(new File(outputFile_name));
		saver.writeBatch();
	}

}

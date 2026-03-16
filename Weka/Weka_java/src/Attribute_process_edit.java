import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import weka.filters.*;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ArffLoader.ArffReader;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.Reorder;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class Attribute_process_edit {
	
	public void edit_attributes_process() throws Exception
	{
		BufferedReader reader1 = new BufferedReader(new FileReader("versionsW7.arff"));
		ArffReader arff_postion_ver1 = new ArffReader(reader1);
		Instances dataset_edit_ver1 = arff_postion_ver1.getData();
		
		String[] remove_opts = new String[] {"-R","27-last,12-22"};
		Remove remove = new Remove();
		remove.setOptions(remove_opts);
		remove.setInputFormat(dataset_edit_ver1);
		dataset_edit_ver1 = Filter.useFilter(dataset_edit_ver1,remove);
		
		StringToWordVector stringToWordVector1 = new StringToWordVector();
		stringToWordVector1.setInputFormat(dataset_edit_ver1);
		dataset_edit_ver1 = Filter.useFilter(dataset_edit_ver1, stringToWordVector1);
		
		String[] reorder_otps3 = new String[] {"-R","first-7,9-last,8"};
		Reorder reorder3 = new Reorder();
		reorder3.setOptions(reorder_otps3);
		reorder3.setInputFormat(dataset_edit_ver1);
		dataset_edit_ver1 = Filter.useFilter(dataset_edit_ver1,reorder3);
		
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset_edit_ver1);
		String edit_ver1 = "edit_test.arff";
		saver.setFile(new File(edit_ver1));
		saver.writeBatch();
	}
	
}

package unused;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ArffLoader.ArffReader;
import weka.filters.Filter;
import weka.filters.supervised.instance.SMOTE;

public class Instances_Balance {
	
	public static void Balance_position(String fileName) throws Exception 
	{
		BufferedReader reader =  new BufferedReader(new FileReader(fileName));
		ArffReader arff = new ArffReader(reader);
		Instances dataset = arff.getData();
		int num_of_instances = dataset.numInstances();
		int position_num_middle = 0;
		int position_num_end = 0;
		int num_of_deleted_middle = 0;
		int num_of_deleted_end = 0;
		
		for(int j=0;j<num_of_instances;j++) 
		{	
			if(dataset.instance(j).stringValue(27).equals("0")) 
			{	
				position_num_middle++;
			}
			if(dataset.instance(j).stringValue(27).equals("1")) 
			{	
				position_num_end++;
			}
		}
		//System.out.println(position_num_end);
		for(int i=0;i<num_of_instances-num_of_deleted_middle;i++) 
		{	
			if(dataset.instance(i).stringValue(27).equals("0")) 
			{	
				dataset.delete(i);
				num_of_deleted_middle++;
				i--;
				if((position_num_middle-num_of_deleted_middle)<=3000)
					break;
			}
		}
		
		int num_of_instances_after_balanceMiddle = dataset.numInstances();
		
		for(int i=0;i<num_of_instances_after_balanceMiddle-num_of_deleted_end;i++) 
		{	
			if(dataset.instance(i).stringValue(27).equals("1")) 
			{	
				dataset.delete(i);
				num_of_deleted_end++;
				i--;
				if((position_num_end-num_of_deleted_end)<=3000)
					break;
			}
		}

		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		String outputFile_name = "C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Position)\\RawData1(OriText)(Position)(Balanced).arff";
		saver.setFile(new File(outputFile_name));
		saver.writeBatch();
	}
	
	
	public static void Balance_operation(String fileName) throws Exception 
	{
		BufferedReader reader =  new BufferedReader(new FileReader(fileName));
		ArffReader arff = new ArffReader(reader);
		Instances dataset = arff.getData();
		int num_of_instances = dataset.numInstances();
		int operation_num_addition = 0;
		int operation_num_modification = 0;
		int num_of_deleted_addition = 0;
		int num_of_deleted_modification = 0;
		
		for(int j=0;j<num_of_instances;j++) 
		{	
			if(dataset.instance(j).stringValue(25).equals("0")) 
			{	
				operation_num_addition++;
			}
			if(dataset.instance(j).stringValue(25).equals("2")) 
			{	
				operation_num_modification++;
			}
		}
		System.out.println(operation_num_addition + " " +operation_num_modification);
		for(int i=0;i<num_of_instances-num_of_deleted_addition;i++) 
		{	
			if(dataset.instance(i).stringValue(25).equals("0")) 
			{	
				dataset.delete(i);
				num_of_deleted_addition++;
				i--;
				if((operation_num_addition-num_of_deleted_addition)<=2487)
					break;
			}
		}
		
		int num_of_instances2 = dataset.numInstances();
		//System.out.println(num_of_instances2);
		for(int i=0;i<num_of_instances2-num_of_deleted_modification;i++) 
		{	
			if(dataset.instance(i).stringValue(25).equals("2")) 
			{	
				dataset.delete(i);
				num_of_deleted_modification++;
				i--;
				if((operation_num_modification-num_of_deleted_modification)<=2487)
					break;
			}
		}
		
		int num_of_instances3 = dataset.numInstances();
		double num_of_edited_1 = 0;
		double num_of_edited_0 = 0;
		for(int i=0;i<num_of_instances3;i++) 
		{	
			if(dataset.instance(i).stringValue(25).equals("0"))
			{
				num_of_edited_0++;
			}
			if(dataset.instance(i).stringValue(25).equals("1"))
			{
				num_of_edited_1++;
			}
		}
//		SMOTE smote = new SMOTE();
//		System.out.println(num_of_edited_0);
//		double percentage_start = (num_of_edited_0/num_of_edited_1)*100-100;
//		System.out.println(percentage_start);
//		dataset.setClassIndex(dataset.numAttributes()-1);
//		smote.setPercentage(percentage_start);
//		smote.setInputFormat(dataset);
//		dataset = Filter.useFilter(dataset,smote);

		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		String outputFile_name = "C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Operation)\\RawData1(OriText)(Operation)(Balanced2).arff";
		saver.setFile(new File(outputFile_name));
		saver.writeBatch();
	}
	
	public static void Balance_Similarity(String fileName) throws Exception 
	{
		BufferedReader reader =  new BufferedReader(new FileReader(fileName));
		ArffReader arff = new ArffReader(reader);
		Instances dataset = arff.getData();
		int num_of_instances = dataset.numInstances();
		int position_num_middle = 0;
		int position_num_end = 0;
		int num_of_deleted_middle = 0;
		int num_of_deleted_end = 0;
		
		for(int j=0;j<num_of_instances;j++) 
		{	
			if(dataset.instance(j).stringValue(27).equals("0")) 
			{	
				position_num_middle++;
			}
			if(dataset.instance(j).stringValue(27).equals("1")) 
			{	
				position_num_end++;
			}
		}
		for(int i=0;i<num_of_instances-num_of_deleted_middle;i++) 
		{	
			if(dataset.instance(i).stringValue(27).equals("0")) 
			{	
				dataset.delete(i);
				num_of_deleted_middle++;
				i--;
				if((position_num_middle-num_of_deleted_middle)<=3000)
					break;
			}
		}
		
		int num_of_instances_after_balanceMiddle = dataset.numInstances();
		
		for(int i=0;i<num_of_instances_after_balanceMiddle-num_of_deleted_end;i++) 
		{	
			if(dataset.instance(i).stringValue(27).equals("1")) 
			{	
				dataset.delete(i);
				num_of_deleted_end++;
				i--;
				if((position_num_end-num_of_deleted_end)<=3000)
					break;
			}
		}

		ArffSaver saver = new ArffSaver();
		saver.setInstances(dataset);
		String outputFile_name = "C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Similarity)\\RawData1(OriText)(Similarity)(Balanced).arff";
		saver.setFile(new File(outputFile_name));
		saver.writeBatch();
	}
	
	public static void main(String[] args) throws Exception 
	{
		Balance_position("C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Position).arff");
		Balance_Similarity("C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Similarity).arff");
		Balance_operation("C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Operation).arff");
	}
}

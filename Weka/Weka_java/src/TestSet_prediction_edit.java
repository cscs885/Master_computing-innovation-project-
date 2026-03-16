import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class TestSet_prediction_edit {
	
	public int test_edit() throws Exception
	{
		String prefix = "Edit_Randomforest_model//";
		
		String trainset_edit_name1 = "edit_model";
		
		String test_edit_name = "edit_test.arff";
		
		BufferedReader testing1 = new BufferedReader(new FileReader(test_edit_name));
		Instances test = new Instances(testing1);
		int class_index = test.numAttributes()-1;
		test.setClassIndex(class_index);
		SerializationHelper serialize = new SerializationHelper();
		int edited_result = 0;
		
		
		RandomForest randomForest_read = (RandomForest)serialize.read(new FileInputStream(prefix + trainset_edit_name1));
		
		for(int i=0;i<test.size();i++) 
		{
			int label = (int)randomForest_read.classifyInstance(test.instance(i));
			int true_answer = (int)test.instance(i).value(class_index);
			
//			if(true_answer==0)
//				System.out.print("true answer  " + "(will not be edited)  |||   ");	
//			else
//				System.out.print("true answer  " + "(will be edited)  |||  ");	
			if(label ==0) 	
			{
				System.out.print("Predicted  " + "(will not be edited)");
				edited_result = 0;
			}	
			else 
			{
				System.out.print("Predicted  " + "(will be edited)");
				edited_result = 1;
			}
			
//			if(true_answer==label)
//				System.out.println("ã");
//			else
//				System.out.println("X");
		}
		
		return edited_result;
	}
}

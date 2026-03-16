import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class Position_TestSet {

	public  void test_position() throws Exception {
		
		String suffix = ".arff";
		String prefix = "PurifiedText_Position_RandomForest130//";
		String prefix2 = "Oritext_Operation_NaiveBayse//";
		String prefix3 = "Oritext_Similarity_NaiveBayse//";
		
//		String operation_prefix = "Oritext_Position_NaiveBayse//";
//		String operation_prefix2 = "Oritext_Operation_NaiveBayse//";
//		String operation_prefix3 = "Oritext_Similarity_NaiveBayse//";
		
		String trainset_position_name1 = "Position(Balanced,stemmer,NGram2-3)";
	
		String testset_name1 = "position_process" + suffix;	
		BufferedReader testing1 = new BufferedReader(new FileReader(testset_name1));		
		Instances test = new Instances(testing1);	
		int last = test.numAttributes()-1;
		test.setClassIndex(last);		

		
		SerializationHelper serialize = new SerializationHelper();
		
		RandomForest randomForest_position_read = (RandomForest)serialize.read(new FileInputStream(prefix + trainset_position_name1));

		
		
		//Test Position
		System.out.println("---------- Position" + "--------------");
			int label;
					System.out.println("\nRunning RandomForest130 on " + trainset_position_name1);
					for(int i=0;i<test.size();i++)
					{	
						label = (int)randomForest_position_read.classifyInstance(test.instance(i));
						int true_answer = (int)test.instance(i).value(last);						
//						if(true_answer == 1 )
//							System.out.print("True answer (end) |||||  ");
//						else 
//							System.out.print("True answer (beginning/middle) |||||  ");
						
						if(label ==0) 	
							System.out.print("Predicted  " + "(beginning/middle)");	
						
						else
							System.out.print("Predicted  " + "(end)");
						
//						if(true_answer==label)
//							System.out.println("ã");
//						else
//							System.out.println("X");
					}
			}
}
		//end of Position

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class Similarity_TestSet {

	public  void test_similarity() throws Exception {
		
		String suffix = ".arff";
		String prefix = "OriText_Similarity_RandomForest130//";

		
		String trainset_similarity_name1 = "Similarity(Balanced,stemmer,Rainbow).model";
	
		String testset_name1 = "similarity_process" + suffix;	
		BufferedReader testing1 = new BufferedReader(new FileReader(testset_name1));		
		Instances test = new Instances(testing1);	
		int last = test.numAttributes()-1;
		test.setClassIndex(last);		

		
		SerializationHelper serialize = new SerializationHelper();
		
		RandomForest randomForest_similarity_read = (RandomForest)serialize.read(new FileInputStream(prefix + trainset_similarity_name1));

		
		
		//Test similarity
		System.out.println("---------- Similarity" + "--------------");
			int label;
					System.out.println("\nRunning RandomForest130 on " + trainset_similarity_name1);
					for(int i=0;i<test.size();i++)
					{	
						label = (int)randomForest_similarity_read.classifyInstance(test.instance(i));
						int true_answer = (int)test.instance(i).value(last);						
//						if(true_answer == 1 )
//							System.out.print("True answer (big edit) |||||  ");
//						else 
//							System.out.print("True answer (small edit) |||||  ");
						
						if(label ==0) 	
							System.out.print("Predicted  " + "(small edit)");	
						
						else
							System.out.print("Predicted  " + "(big edit)");
						
//						if(true_answer==label)
//							System.out.println("ã");
//						else
//							System.out.println("X");
					}
			}
}
		//end of similarity

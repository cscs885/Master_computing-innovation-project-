	import java.io.BufferedReader;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;

	import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
	import weka.core.SerializationHelper;
public class Operation_TestSet {

	
		public void test_operation() throws Exception
		{
			
			String suffix = ".arff";
			String prefix = "OriText_Operation_RandomForest130//";

			
			String trainset_operation_name1 = "Operation(Balanced,stemmer,NGram1-3).model";
		
			String testset_name1 = "operation_process" + suffix;	
			BufferedReader testing1 = new BufferedReader(new FileReader(testset_name1));		
			Instances test = new Instances(testing1);	
			int last = test.numAttributes()-1;
			test.setClassIndex(last);

			
			SerializationHelper serialize = new SerializationHelper();

			
			RandomForest randomForest_operation_read = (RandomForest)serialize.read(new FileInputStream(prefix + trainset_operation_name1));
			
			
			System.out.println("\n\n----------PufiedText Operation" + "--------------");
			//Test operation
						System.out.println("\nRunning RandomForest130 on " + trainset_operation_name1);
						for(int i=0;i<test.size();i++)
						{	
							int label2 = (int)randomForest_operation_read.classifyInstance(test.instance(i));
							int true_answer = (int)test.instance(i).value(last);
							
//							if(true_answer ==0) 	
//								System.out.print("True operation (addition) |||| ");	
//							else if (true_answer ==1)
//								System.out.print("True operation  (deletion) |||| ");	
//							else
//								System.out.print("True operation  (modification) |||| ");
							
							
							if(label2 ==0) 	
								System.out.print("Predicted (addition)");	
							else if (label2 ==1)
								System.out.print("Predicted (deletion)");	
							else
								System.out.print("Predicted operation  (modification) ");
							
//							if(true_answer==label2)
//								System.out.println("ã");
//							else
//								System.out.println("X");
						}				
			}
			//end of Operation
}

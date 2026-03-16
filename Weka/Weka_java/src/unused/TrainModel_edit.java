package unused;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.SerializationHelper;
public class TrainModel_edit {
	
	public static void main(String[] args)throws Exception
	{
		String trainset_position_name1 = "edit_model.arff";
		String write_name = "edit_model";
		BufferedReader train_edit = new BufferedReader(new FileReader(trainset_position_name1));
		Instances train1 = new Instances(train_edit);
		train1.setClassIndex(train1.numAttributes()-1);
		
		SerializationHelper serialize = new SerializationHelper();
		
		RandomForest randomForest_100 = new RandomForest();
		randomForest_100.setNumIterations(100);
		randomForest_100.buildClassifier(train1);
		serialize.write(write_name,randomForest_100);
	}
}

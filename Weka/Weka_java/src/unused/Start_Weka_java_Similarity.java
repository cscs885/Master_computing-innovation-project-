package unused;
	import java.io.*;
	import java.net.*;
	import java.util.*;
	import weka.classifiers.Evaluation;
	import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
	import weka.classifiers.trees.J48;
	import weka.classifiers.trees.RandomForest;
	import weka.core.Instances;
	import weka.filters.Filter;
	import weka.filters.unsupervised.attribute.Remove;
public class Start_Weka_java_Similarity {
	
		public static void main(String[] args) throws Exception 
			{	
				BufferedReader in = null;
				BufferedReader in2 = null;
				BufferedReader in3 = null;
				BufferedReader in4 = null;
				String file_name_input_1 = "Similarity(Balanced,stemmer).arff";
				String file_name_input_2 = "Similarity(Balanced,stemmer,NGram1-3).arff";
				String file_name_input_3 = "Similarity(Balanced,stemmer,NGram2-3).arff";
				String file_name_input_4 = "Similarity(Balanced,stemmer,NGram2-3,Rainbow).arff";
				//String file_name_input_2 = 
				
				in = new BufferedReader(new FileReader(file_name_input_1));	
				in2 = new BufferedReader(new FileReader(file_name_input_2));
				in3 = new BufferedReader(new FileReader(file_name_input_3));	
				in4 = new BufferedReader(new FileReader(file_name_input_4));	
				
				Instances train = new Instances(in);
				Instances train2 = new Instances(in2);
				Instances train3 = new Instances(in3);
				Instances train4 = new Instances(in4);
				
				
				
				train.setClassIndex(train.numAttributes()-1);
				train2.setClassIndex(train2.numAttributes()-1);
				train3.setClassIndex(train3.numAttributes()-1);
				train4.setClassIndex(train4.numAttributes()-1);
				
				//SMO
//				SMO smo = new SMO();
//				smo.buildClassifier(train);
//				Evaluation eval0 = new Evaluation(train);
//				eval0.crossValidateModel(smo,train,10,new Random(1));
//				System.out.println("smo(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval0.weightedFMeasure()) + 
//				"Precision:" + String.format("%.3f",eval0.weightedPrecision()) + "Recall: " +String.format("%.3f",eval0.weightedRecall()));
//				
//				SMO smo2 = new SMO();
//				smo2.buildClassifier(train2);
//				Evaluation eval1 = new Evaluation(train2);
//				eval1.crossValidateModel(smo2,train2,10,new Random(1));
//				System.out.println("smo2(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval1.weightedFMeasure()) + 
//				"Precision:" + String.format("%.3f",eval1.weightedPrecision()) + "Recall: " +String.format("%.3f",eval1.weightedRecall()));
//				
//				SMO smo3 = new SMO();
//				smo3.buildClassifier(train3);
//				Evaluation eval2 = new Evaluation(train3);
//				eval2.crossValidateModel(smo3,train3,10,new Random(1));
//				System.out.println("smo2(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval2.weightedFMeasure()) + 
//				"Precision:" + String.format("%.3f",eval2.weightedPrecision()) + "Recall: " +String.format("%.3f",eval2.weightedRecall()));
//				
//				SMO smo4 = new SMO();
//				smo4.buildClassifier(train4);
//				Evaluation eval3 = new Evaluation(train4);
//				eval3.crossValidateModel(smo4,train4,10,new Random(1));
//				System.out.println("smo3(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval3.weightedFMeasure()) + 
//				"Precision:" + String.format("%.3f",eval3.weightedPrecision()) + "Recall: " +String.format("%.3f",eval3.weightedRecall()));
				
				
				
				//NaiveBayse
//				NaiveBayes nBayes = new NaiveBayes();
//				nBayes.buildClassifier(train);
//				Evaluation eval0 = new Evaluation(train);
//				eval0.crossValidateModel(nBayes,train,10,new Random(1));
//				System.out.println("NaiveBayes(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval0.weightedFMeasure()) + 
//						"Precision:" + String.format("%.3f",eval0.weightedPrecision()) + "Recall: " +String.format("%.3f",eval0.weightedRecall()));
//				
//				NaiveBayes nBayes2 = new NaiveBayes();
//				nBayes2.buildClassifier(train2);
//				Evaluation eval1 = new Evaluation(train2);
//				eval1.crossValidateModel(nBayes2,train2,10,new Random(1));
//				System.out.println("NaiveBayes(Similarity(Balanced,stemmer,NGram1-3)) fMeasure: " + String.format("%.3f",eval1.weightedFMeasure()) + 
//						"Precision:" + String.format("%.3f",eval1.weightedPrecision()) + "Recall: " +String.format("%.3f",eval1.weightedRecall()));
//				
//				NaiveBayes nBayes3 = new NaiveBayes();
//				nBayes3.buildClassifier(train3);
//				Evaluation eval3 = new Evaluation(train3);
//				eval3.crossValidateModel(nBayes3,train3,10,new Random(1));
//				System.out.println("NaiveBayes(Similarity(Balanced,stemmer,NGram2-3)) fMeasure: " + String.format("%.3f",eval3.weightedFMeasure()) + 
//						"Precision:" + String.format("%.3f",eval3.weightedPrecision()) + "Recall: " +String.format("%.3f",eval3.weightedRecall()));
//
//				NaiveBayes nBayes4 = new NaiveBayes();
//				nBayes4.buildClassifier(train4);
//				Evaluation eval4 = new Evaluation(train4);
//				eval4.crossValidateModel(nBayes4,train4,10,new Random(1));
//				System.out.println("NaiveBayes(Similarity(Balanced,stemmer,NGram2-3,Rainbow)) fMeasure: " + String.format("%.3f",eval4.weightedFMeasure()) + 
//						"Precision:" + String.format("%.3f",eval4.weightedPrecision()) + "Recall: " +String.format("%.3f",eval4.weightedRecall()));
//				
//				
//				//RandomForest 130
//				RandomForest randomForest_130 = new RandomForest();
//				randomForest_130.setNumIterations(130);
//				randomForest_130.buildClassifier(train);
//				Evaluation eval01 = new Evaluation(train);
//				eval01.crossValidateModel(randomForest_130,train,10,new Random(1));
//				System.out.println("randomForest_130(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval01.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval01.weightedPrecision()) + "Recall: " +String.format("%.3f",eval01.weightedRecall()));
//				
//				RandomForest randomForest_130_2 = new RandomForest();
//				randomForest_130_2.setNumIterations(130);
//				randomForest_130_2.buildClassifier(train2);
//				Evaluation eval11 = new Evaluation(train2);
//				eval11.crossValidateModel(randomForest_130_2,train2,10,new Random(1));
//				System.out.println("randomForest_130(Similarity((Balanced,stemmer,NGram1-3)) fMeasure: " + String.format("%.3f",eval11.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval11.weightedPrecision()) + "Recall: " +String.format("%.3f",eval11.weightedRecall()));
//				
//				RandomForest randomForest_130_3 = new RandomForest();
//				randomForest_130_3.setNumIterations(130);
//				randomForest_130_3.buildClassifier(train3);
//				Evaluation eval21 = new Evaluation(train3);
//				eval21.crossValidateModel(randomForest_130_3,train3,10,new Random(1));
//				System.out.println("randomForest_130(Similarity(Balanced,stemmer,NGram2-3)) fMeasure: " + String.format("%.3f",eval21.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval21.weightedPrecision()) + "Recall: " +String.format("%.3f",eval21.weightedRecall()));
//				
//				RandomForest randomForest_130_4 = new RandomForest();
//				randomForest_130_4.setNumIterations(130);
//				randomForest_130_4.buildClassifier(train4);
//				Evaluation eval31 = new Evaluation(train4);
//				eval31.crossValidateModel(randomForest_130_4,train4,10,new Random(1));
//				System.out.println("randomForest_130(Similarity(Balanced,stemmer,NGram1-3,Rainbow)) fMeasure: " + String.format("%.3f",eval31.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval31.weightedPrecision()) + "Recall: " +String.format("%.3f",eval31.weightedRecall()));
//				
//				
//				//RandomForest 100
//				RandomForest randomForest_100 = new RandomForest();
//				randomForest_100.setNumIterations(100);
//				randomForest_100.buildClassifier(train);
//				Evaluation eval02 = new Evaluation(train);
//				eval02.crossValidateModel(randomForest_100,train,10,new Random(1));
//				System.out.println("randomForest_100(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval02.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval02.weightedPrecision()) + "Recall: " +String.format("%.3f",eval02.weightedRecall()));
//				
//				RandomForest randomForest_100_2 = new RandomForest();
//				randomForest_100_2.setNumIterations(100);
//				randomForest_100_2.buildClassifier(train2);
//				Evaluation eval12 = new Evaluation(train2);
//				eval12.crossValidateModel(randomForest_100_2,train2,10,new Random(1));
//				System.out.println("randomForest_100(Similarity(Balanced,stemmer,NGram1-3)) fMeasure: " + String.format("%.3f",eval12.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval12.weightedPrecision()) + "Recall: " +String.format("%.3f",eval12.weightedRecall()));
//				
//				RandomForest randomForest_100_3 = new RandomForest();
//				randomForest_100_3.setNumIterations(100);
//				randomForest_100_3.buildClassifier(train3);
//				Evaluation eval22 = new Evaluation(train3);
//				eval22.crossValidateModel(randomForest_100_3,train3,10,new Random(1));
//				System.out.println("randomForest_100(Similarity(Balanced,stemmer,NGram2-3)) fMeasure: " + String.format("%.3f",eval22.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval22.weightedPrecision()) + "Recall: " +String.format("%.3f",eval22.weightedRecall()));
//				
//				RandomForest randomForest_100_4 = new RandomForest();
//				randomForest_100_4.setNumIterations(100);
//				randomForest_100_4.buildClassifier(train4);
//				Evaluation eval32 = new Evaluation(train4);
//				eval32.crossValidateModel(randomForest_100_4,train4,10,new Random(1));
//				System.out.println("randomForest_100(Similarity(Balanced,stemmer,NGram2-3,Rainbow)) fMeasure: " + String.format("%.3f",eval32.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval32.weightedPrecision()) + "Recall: " +String.format("%.3f",eval32.weightedRecall()));
//				
////				
//				//RandomForest 75
//				RandomForest randomForest_75 = new RandomForest();
//				randomForest_75.setNumIterations(75);
//				randomForest_75.buildClassifier(train);
//				Evaluation eval03 = new Evaluation(train);
//				eval03.crossValidateModel(randomForest_75,train,10,new Random(1));
//				System.out.println("randomForest_75(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval03.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval03.weightedPrecision()) + "Recall: " +String.format("%.3f",eval03.weightedRecall()));
//				
//				RandomForest randomForest_75_2 = new RandomForest();
//				randomForest_75_2.setNumIterations(75);
//				randomForest_75_2.buildClassifier(train2);
//				Evaluation eval13 = new Evaluation(train2);
//				eval13.crossValidateModel(randomForest_75_2,train2,10,new Random(1));
//				System.out.println("randomForest_75(Similarity(Balanced,stemmer,NGram1-3)) fMeasure: " + String.format("%.3f",eval13.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval13.weightedPrecision()) + "Recall: " +String.format("%.3f",eval13.weightedRecall()));
//				
//				RandomForest randomForest_75_3 = new RandomForest();
//				randomForest_75_3.setNumIterations(75);
//				randomForest_75_3.buildClassifier(train3);
//				Evaluation eval23 = new Evaluation(train3);
//				eval23.crossValidateModel(randomForest_75_3,train3,10,new Random(1));
//				System.out.println("randomForest_75(Similarity(Balanced,stemmer,NGram2-3)) fMeasure: " + String.format("%.3f",eval23.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval23.weightedPrecision()) + "Recall: " +String.format("%.3f",eval23.weightedRecall()));
//				
//				RandomForest randomForest_75_4 = new RandomForest();
//				randomForest_75_4.setNumIterations(75);
//				randomForest_75_4.buildClassifier(train4);
//				Evaluation eval33 = new Evaluation(train4);
//				eval33.crossValidateModel(randomForest_75_4,train4,10,new Random(1));
//				System.out.println("randomForest_75(Similarity(Balanced,stemmer,NGram2-3,Rainbow)) fMeasure: " + String.format("%.3f",eval33.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval33.weightedPrecision()) + "Recall: " +String.format("%.3f",eval33.weightedRecall()));
//				
//						
//				//IBK KNN20
//				IBk ibk_20 = new IBk(20);
//				ibk_20.buildClassifier(train);
//				Evaluation eval04 = new Evaluation(train);
//				eval04.crossValidateModel(ibk_20,train,10,new Random(1));
//				System.out.println("ibk_20(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval04.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval04.weightedPrecision()) + "Recall: " +String.format("%.3f",eval04.weightedRecall()));
//				
//				IBk ibk_20_2 = new IBk(20);
//				ibk_20_2.buildClassifier(train2);
//				Evaluation eval14 = new Evaluation(train2);
//				eval14.crossValidateModel(ibk_20_2,train2,10,new Random(1));
//				System.out.println("ibk_20(Similarity(Balanced,stemmer,NGram1-3)) fMeasure: " + String.format("%.3f",eval14.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval14.weightedPrecision()) + "Recall: " +String.format("%.3f",eval14.weightedRecall()));
//				
//				IBk ibk_20_3 = new IBk(20);
//				ibk_20_3.buildClassifier(train3);
//				Evaluation eval24 = new Evaluation(train3);
//				eval24.crossValidateModel(ibk_20_3,train3,10,new Random(1));
//				System.out.println("ibk_20(Similarity(Balanced,stemmer,NGram2-3)) fMeasure: " + String.format("%.3f",eval24.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval24.weightedPrecision()) + "Recall: " +String.format("%.3f",eval24.weightedRecall()));
//				
//				IBk ibk_20_4 = new IBk(20);
//				ibk_20_4.buildClassifier(train4);
//				Evaluation eval34 = new Evaluation(train4);
//				eval34.crossValidateModel(ibk_20_4,train4,10,new Random(1));
//				System.out.println("ibk_20(Similarity(Balanced,stemmer,NGram2-3,Rainbow)) fMeasure: " + String.format("%.3f",eval34.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval34.weightedPrecision()) + "Recall: " +String.format("%.3f",eval34.weightedRecall()));
//				
//				//IBK KNN40 ibk_40
//				IBk ibk_40 = new IBk(40);
//				ibk_40.buildClassifier(train);
//				Evaluation eval05 = new Evaluation(train);
//				eval05.crossValidateModel(ibk_40,train,10,new Random(1));
//				System.out.println("ibk_40(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval05.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval05.weightedPrecision()) + "Recall: " +String.format("%.3f",eval05.weightedRecall()));
//				
//				IBk ibk_40_2 = new IBk(40);
//				ibk_40_2.buildClassifier(train2);
//				Evaluation eval15 = new Evaluation(train2);
//				eval15.crossValidateModel(ibk_40_2,train2,10,new Random(1));
//				System.out.println("ibk_40(Similarity(Balanced,stemmer,NGram1-3)) fMeasure: " + String.format("%.3f",eval15.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval15.weightedPrecision()) + "Recall: " +String.format("%.3f",eval15.weightedRecall()));
//				
//				IBk ibk_40_3 = new IBk(40);
//				ibk_40_3.buildClassifier(train3);
//				Evaluation eval25 = new Evaluation(train3);
//				eval25.crossValidateModel(ibk_40_3,train3,10,new Random(1));
//				System.out.println("ibk_40(Similarity(Balanced,stemmer,NGram2-3)) fMeasure: " + String.format("%.3f",eval25.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval25.weightedPrecision()) + "Recall: " +String.format("%.3f",eval25.weightedRecall()));
//				
//				IBk ibk_40_4 = new IBk(40);
//				ibk_40_4.buildClassifier(train4);
//				Evaluation eval35 = new Evaluation(train4);
//				eval35.crossValidateModel(ibk_40_4,train4,10,new Random(1));
//				System.out.println("ibk_40(Similarity(Balanced,stemmer,NGram2-3,Rainbow)) fMeasure: " + String.format("%.3f",eval35.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval35.weightedPrecision()) + "Recall: " +String.format("%.3f",eval35.weightedRecall()));
//				
//					
//				//IBK KNN30
//				IBk ibk_30 = new IBk(30);
//				ibk_30.buildClassifier(train);
//				Evaluation eval06 = new Evaluation(train);
//				eval06.crossValidateModel(ibk_30,train,10,new Random(1));
//				System.out.println("ibk_30(Similarity(Balanced,stemmer)) fMeasure: " + String.format("%.3f",eval06.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval06.weightedPrecision()) + "Recall: " +String.format("%.3f",eval06.weightedRecall()));
//				
//				IBk ibk_30_2 = new IBk(30);
//				ibk_30_2.buildClassifier(train2);
//				Evaluation eval16 = new Evaluation(train2);
//				eval16.crossValidateModel(ibk_30_2,train2,10,new Random(1));
//				System.out.println("ibk_30(Similarity(Balanced,stemmer,NGram1-3)) fMeasure: " + String.format("%.3f",eval16.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval16.weightedPrecision()) + "Recall: " +String.format("%.3f",eval16.weightedRecall()));
//				
//				IBk ibk_30_3 = new IBk(30);
//				ibk_30_3.buildClassifier(train3);
//				Evaluation eval26 = new Evaluation(train3);
//				eval26.crossValidateModel(ibk_30_3,train3,10,new Random(1));
//				System.out.println("ibk_30(Similarity(Balanced,stemmer,NGram2-3)) fMeasure: " + String.format("%.3f",eval26.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval26.weightedPrecision()) + "Recall: " +String.format("%.3f",eval26.weightedRecall()));
//				
//				IBk ibk_30_4 = new IBk(30);
//				ibk_30_4.buildClassifier(train4);
//				Evaluation eval36 = new Evaluation(train4);
//				eval36.crossValidateModel(ibk_30_4,train4,10,new Random(1));
//				System.out.println("ibk_30(Similarity(Balanced,stemmer,NGram2-3,Rainbow)) fMeasure: " + String.format("%.3f",eval36.weightedFMeasure())+ 
//						"Precision:" + String.format("%.3f",eval36.weightedPrecision()) + "Recall: " +String.format("%.3f",eval36.weightedRecall()));
				in.close();	
			}

}

	
	import weka.filters.*;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;

	import weka.core.Attribute;
	import weka.core.Instances;
	import weka.core.converters.ArffLoader.ArffReader;
	import weka.core.converters.ArffSaver;
	import weka.core.converters.ConverterUtils.DataSource;
	import weka.core.stemmers.SnowballStemmer;
	import weka.core.stopwords.Rainbow;
	import weka.core.tokenizers.NGramTokenizer;
	import weka.core.converters.Loader;
	import weka.filters.unsupervised.attribute.Remove;
	import weka.filters.unsupervised.attribute.Reorder;
	import weka.filters.unsupervised.attribute.StringToWordVector;
	import weka.attributeSelection.AttributeSelection;
	import weka.attributeSelection.InfoGainAttributeEval;
	import weka.attributeSelection.Ranker;
	import weka.attributeSelection.ClassifierSubsetEval;
	import weka.attributeSelection.BestFirst;
import weka.filters.supervised.instance.SMOTE;
public class Attribute_process_Operation {


		
		//public String attributes_preprocess(String fileName) throws Exception
		
		public void process_operation()throws Exception
		{	
			//Instances_Balance instances_Balance = new Instances_Balance();
			//instances_Balance.call_balance();
			//BufferedReader reader_1 =  new BufferedReader(new FileReader("C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Operation)\\RawData1(OriText)(Operation)(Balanced).arff"));
			BufferedReader reader_2 =  new BufferedReader(new FileReader("versionsW7.arff"));
			//BufferedReader reader_3 = new BufferedReader(new FileReader("C:\\Users\\34463\\Documents\\RawData1(OriText)\\RawData1(OriText)(Similarity)\\RawData1(OriText)(Similarity)(Balanced).arff"));
			ArffReader arff_postion_ver1 = new ArffReader(reader_2);
			
			Instances dataset_postion_ver1 = arff_postion_ver1.getData();
			
			long start_time = System.currentTimeMillis();
			
			String[] remove_opts = new String[] {"-R","8-9,12-22,28,41-42,44-45,47-last"};
			Remove remove = new Remove();
			remove.setOptions(remove_opts);
			remove.setInputFormat(dataset_postion_ver1);
			dataset_postion_ver1 = Filter.useFilter(dataset_postion_ver1,remove);
			
			String[] reorder_otps = new String[] {"-R","first-23,25-last,24"};
			
			
			//Convert String to WordsVector (stemmer) ver1
			NGramTokenizer ngramTokenizer3 = new NGramTokenizer();
			StringToWordVector stringToWordVector_Operation_ver1 = new StringToWordVector();
			SnowballStemmer snowballStemmer = new SnowballStemmer();
			stringToWordVector_Operation_ver1.setStemmer(snowballStemmer);
			stringToWordVector_Operation_ver1.setTokenizer(ngramTokenizer3);	
			stringToWordVector_Operation_ver1.setInputFormat(dataset_postion_ver1);
			dataset_postion_ver1= Filter.useFilter(dataset_postion_ver1, stringToWordVector_Operation_ver1);
			
			Reorder reorder = new Reorder();
			reorder.setOptions(reorder_otps);
			reorder.setInputFormat(dataset_postion_ver1);
			dataset_postion_ver1 = Filter.useFilter(dataset_postion_ver1,reorder);	
			
			ArffSaver saver = new ArffSaver();
			saver.setInstances(dataset_postion_ver1);
			String outputFile_Postion_stemmer = "operation_process.arff";
			saver.setFile(new File(outputFile_Postion_stemmer));
			saver.writeBatch();
//			
//			String[] ranking_opts = new String[] {"-N","20"};
//			InfoGainAttributeEval infoGainAttributeEval = new InfoGainAttributeEval();
//			Ranker ranker = new Ranker();
//			ranker.setOptions(ranking_opts);
//			AttributeSelection filter = new AttributeSelection();
//			dataset_postion_ver1.setClassIndex(dataset_postion_ver1.numAttributes()-1);
//			filter.setEvaluator(infoGainAttributeEval);
//			filter.setSearch(ranker);
//			filter.SelectAttributes(dataset_postion_ver1);	
//			System.out.println(filter.toResultsString());
			

			
			
			
			//Convert String to WordsVector (stemmer,NGramtokeniser,min=1,max =3)) ver2
			
//			SnowballStemmer snowballStemmer2 = new SnowballStemmer();
//			StringToWordVector stringToWordVector_Operation_ver2 = new StringToWordVector();
//			NGramTokenizer ngramTokenizer = new NGramTokenizer();
//			stringToWordVector_Operation_ver2.setStemmer(snowballStemmer2);
//			stringToWordVector_Operation_ver2.setTokenizer(ngramTokenizer);
//			stringToWordVector_Operation_ver2.setInputFormat(dataset2_postion_ver1);
//			dataset2_postion_ver1= Filter.useFilter(dataset2_postion_ver1, stringToWordVector_Operation_ver2);
//			long flag2_time = System.currentTimeMillis();
//			System.out.println(flag2_time-flag1_time);
//
//			String[] reorder_otps2 = new String[] {"-R","first-23,25-last,24"};
//			Reorder reorder2 = new Reorder();
//			reorder2.setOptions(reorder_otps2);
//			reorder2.setInputFormat(dataset2_postion_ver1);
//			dataset2_postion_ver1 = Filter.useFilter(dataset2_postion_ver1,reorder2);		
//			
//			String[] ranking_opts_2 = new String[] {"-N","20"};
//			InfoGainAttributeEval infoGainAttributeEval_2 = new InfoGainAttributeEval();
//			Ranker ranker2 = new Ranker();
//			ranker2.setOptions(ranking_opts_2);
//			AttributeSelection filter2 = new AttributeSelection();
//			dataset2_postion_ver1.setClassIndex(dataset2_postion_ver1.numAttributes()-1);
//			filter2.setEvaluator(infoGainAttributeEval_2);
//			filter2.setSearch(ranker2);
//			filter2.SelectAttributes(dataset2_postion_ver1);	
//			System.out.println(filter2.toResultsString());
//					
//			ArffSaver saver2 = new ArffSaver();
//			saver2.setInstances(dataset2_postion_ver1);
//			String outputFile_Postion_stemmer_NGram1To3 = "C:\\Users\\34463\\Documents\\RawData1(OriText)\\Operation(Balanced,stemmer,NGram1-3).arff";
//			saver2.setFile(new File(outputFile_Postion_stemmer_NGram1To3));
//			saver2.writeBatch();
//			
//			
//			
//			//Convert String to WordsVector (stemmer,NGramtokeniser,min=2,max =3)) ver3
//			SnowballStemmer snowballStemmer3 = new SnowballStemmer();
//			StringToWordVector stringToWordVector_Operation_ver3 = new StringToWordVector();
//			NGramTokenizer ngramTokenizer2 = new NGramTokenizer();
//			ngramTokenizer2.setNGramMinSize(2);
//			stringToWordVector_Operation_ver3.setStemmer(snowballStemmer3);
//			stringToWordVector_Operation_ver3.setTokenizer(ngramTokenizer2);
//			stringToWordVector_Operation_ver3.setInputFormat(dataset3_postion_ver1);
//			dataset3_postion_ver1 = Filter.useFilter(dataset3_postion_ver1, stringToWordVector_Operation_ver3);
//			long flag3_time = System.currentTimeMillis();
//			System.out.println(flag3_time-flag2_time);
//			
//			String[] reorder_otps3 = new String[] {"-R","first-23,25-last,24"};
//			Reorder reorder3 = new Reorder();
//			reorder3.setOptions(reorder_otps3);
//			reorder3.setInputFormat(dataset3_postion_ver1);
//			dataset3_postion_ver1 = Filter.useFilter(dataset3_postion_ver1,reorder3);
//			
//			String[] ranking_opts_3 = new String[] {"-N","20"};
//			InfoGainAttributeEval infoGainAttributeEval_3 = new InfoGainAttributeEval();
//			Ranker ranker3 = new Ranker();
//			ranker3.setOptions(ranking_opts_3);
//			AttributeSelection filter3 = new AttributeSelection();
//			dataset3_postion_ver1.setClassIndex(dataset3_postion_ver1.numAttributes()-1);
//			filter3.setEvaluator(infoGainAttributeEval_3);
//			filter3.setSearch(ranker3);
//			filter3.SelectAttributes(dataset3_postion_ver1);	
//			System.out.println(filter3.toResultsString());
//			
//			ArffSaver saver3 = new ArffSaver();
//			saver3.setInstances(dataset3_postion_ver1);
//			String outputFile_Postion_stemmer_NGram2To3 = "C:\\Users\\34463\\Documents\\RawData1(OriText)\\Operation(Balanced,stemmer,NGram2-3).arff";
//			saver3.setFile(new File(outputFile_Postion_stemmer_NGram2To3));
//			saver3.writeBatch();
//			
//			//Convert String to WordsVector (stemmer,NGramtokeniser,min=2,max =3,stopwordsRainbow)) ver3
//			SnowballStemmer snowballStemmer4 = new SnowballStemmer();
//			StringToWordVector stringToWordVector_Operation_ver4 = new StringToWordVector();
//			NGramTokenizer ngramTokenizer3 = new NGramTokenizer();
//			Rainbow rainbow2 = new Rainbow();
//			//ngramTokenizer3.setNGramMinSize(2);
//			stringToWordVector_Operation_ver4.setStopwordsHandler(rainbow2);
//			stringToWordVector_Operation_ver4.setStemmer(snowballStemmer4);
//			stringToWordVector_Operation_ver4.setInputFormat(dataset4_postion_ver1);
//			dataset4_postion_ver1 = Filter.useFilter(dataset4_postion_ver1, stringToWordVector_Operation_ver4);
//			long flag4_time = System.currentTimeMillis();
//			System.out.println(flag4_time-flag3_time);
//			
//			String[] reorder_otps4 = new String[] {"-R","first-23,25-last,24"};
//			Reorder reorder4 = new Reorder();
//			reorder4.setOptions(reorder_otps4);
//			reorder4.setInputFormat(dataset4_postion_ver1);
//			dataset4_postion_ver1 = Filter.useFilter(dataset4_postion_ver1,reorder4);
//			
//			String[] ranking_opts_4 = new String[] {"-N","20"};
//			InfoGainAttributeEval infoGainAttributeEval_4 = new InfoGainAttributeEval();
//			Ranker ranker4 = new Ranker();
//			ranker4.setOptions(ranking_opts_4);
//			AttributeSelection filter4 = new AttributeSelection();
//			dataset4_postion_ver1.setClassIndex(dataset4_postion_ver1.numAttributes()-1);
//			filter4.setEvaluator(infoGainAttributeEval_4);
//			filter4.setSearch(ranker4);
//			filter4.SelectAttributes(dataset4_postion_ver1);	
//			System.out.println(filter4.toResultsString());
//			
//			ArffSaver saver4 = new ArffSaver();
//			saver4.setInstances(dataset4_postion_ver1);
//			String outputFile_Postion_stemmer_NGram2To3_Rainbow = "C:\\Users\\34463\\Documents\\RawData1(OriText)\\Operation(Balanced,stemmer,NGram2-3,Rainbow).arff";
//			saver4.setFile(new File(outputFile_Postion_stemmer_NGram2To3_Rainbow));
//			saver4.writeBatch();
			
		
		}

}

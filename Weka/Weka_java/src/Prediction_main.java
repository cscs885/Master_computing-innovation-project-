
public class Prediction_main {

	public static void main(String[] args) throws Exception {
		
		//Convert_Edited format
		Attribute_process_edit attribute_process_edit = new Attribute_process_edit();
		attribute_process_edit.edit_attributes_process();
		
		//Test Edited prediction
		TestSet_prediction_edit testSet_prediction_edit = new TestSet_prediction_edit();	
		testSet_prediction_edit.test_edit();
		
		//Convert Position format
		Attribute_process_Position attribute_process_position = new Attribute_process_Position();
		attribute_process_position.process_position();
		
		//Test Position prediction
		Position_TestSet position_TestSet = new Position_TestSet();
		position_TestSet.test_position();
		
		//Convert Operation format
		Attribute_process_Operation attribute_process_operation = new Attribute_process_Operation();
		attribute_process_operation.process_operation();
		
		//Test Operation prediction
		Operation_TestSet operation_TestSet = new Operation_TestSet();
		operation_TestSet.test_operation();
		
		//Convert similarity format
		Arrtibute_process_Similarity arrtibute_process_Similarity = new Arrtibute_process_Similarity();
		arrtibute_process_Similarity.process_similarity();
		
		//Test Similarity prediction
		Similarity_TestSet similarity_TestSet = new Similarity_TestSet();
		similarity_TestSet.test_similarity();
		
		
		
		
		//Operation_TestSet operation_TestSet = new Operation_TestSet();
		//operation_TestSet.test_operation();
//		Testset_Prediction_PurifiedText testset_Prediction_PurifiedText = new Testset_Prediction_PurifiedText();
//		Testset_Prediction_WordsFilter testset_Prediction_WordsFilter = new Testset_Prediction_WordsFilter();
//		Testset_Prediction testset_Prediction = new Testset_Prediction();
//		
//		testset_Prediction.test_Oritext();
//		testset_Prediction_PurifiedText.test_pufified();
//		testset_Prediction_WordsFilter.test_WordsFilter();
	}

}

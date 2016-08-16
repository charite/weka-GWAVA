package weka.classifiers.meta;

import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class GWAVABaggingTest {

	private static Instances data;
	private static Instances randData;
	private static String diabetesFile = "diabetes.arff";
	private static int seed = 42;
	private int folds = 10;

	@Before
	public void setUp() throws Exception {
		File file = new File(Resources.getResource(diabetesFile).getPath());
		BufferedReader reader = new BufferedReader(new FileReader(file));
		data = new Instances(reader);
		reader.close();
		// setting class attribute
		data.setClassIndex(data.numAttributes() - 1);
		Random rand = new Random(seed); // create seeded number generator
		randData = new Instances(data); // create copy of original data
		randData.randomize(rand);
	}

	@Test
	public void classifyJ48Test() throws Exception {

		GWAVABagging gwavaBagging = new GWAVABagging();
		gwavaBagging.setNumIterations(10);
		gwavaBagging.setClassifier(new J48());

		Evaluation eval = new Evaluation(randData);
		eval.crossValidateModel(gwavaBagging, randData, folds, new Random(seed));

		double prcGWAVABagging = eval.areaUnderPRC(1);
		double rocGWAVABagging = eval.areaUnderROC(1);

		eval = new Evaluation(randData);
		eval.crossValidateModel(new J48(), randData, folds, new Random(seed));
		double prcJ48 = eval.areaUnderPRC(1);
		double rocJ48 = eval.areaUnderROC(1);

		assertThat(prcGWAVABagging, Matchers.greaterThan(prcJ48));
		assertThat(rocGWAVABagging, Matchers.greaterThan(rocJ48));
	}

}

package weka.classifiers.trees;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.instance.SpreadSubsample;

/**
 * The GWAVA random forest. Important that for every training set the majority class must be subsampled to the minority
 * class.
 * 
 * @author <a href="mailto:max.schubach@charite.de">Max Schubach</a>
 *
 */
public class GWAVARandomForest extends RandomForest {

	/**
	 * for serialization
	 */
	private static final long serialVersionUID = 8536067796307206185L;

	@Override
	protected synchronized Instances getTrainingSet(int iteration) throws Exception {
		Instances bagData = super.getTrainingSet(iteration);

		SpreadSubsample subsample = new SpreadSubsample();

		subsample.setRandomSeed(m_Seed);
		subsample.setDistributionSpread(1);
		subsample.setInputFormat(bagData);
		return Filter.useFilter(bagData, subsample);

	}
}

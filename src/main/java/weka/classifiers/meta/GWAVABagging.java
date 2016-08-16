package weka.classifiers.meta;

import weka.classifiers.meta.Bagging;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.instance.SpreadSubsample;

/**
 * Extended class for bagging. Important that for every training set the majority class must be subsampled to the
 * minority class.
 * 
 * @author <a href="mailto:max.schubach@charite.de">Max Schubach</a>
 *
 */
public class GWAVABagging extends Bagging {

	/**
	 * for serialization
	 */
	private static final long serialVersionUID = -3101726478201686871L;

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

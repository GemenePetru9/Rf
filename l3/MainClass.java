package exceptii;

public class MainClass {
	
	
	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("D:\\facultate\\Anul 4\\Semestrul II\\RF\\lab3\\in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
			
			//euclidian distance
			double[] x=new double[learningSet.length];
			double[] y=new double[learningSet.length];
			double[] euclidian=new double[learningSet.length-1];
			for(int i=0;i<learningSet.length;i++)
			{
				x[i]=learningSet[i][0];
				y[i]=learningSet[i][1];
			}
			euclidian=FileUtils.CalculateEuclidianDistance(x,y);
			System.out.println("Euclidian distance between the first two features: ");
			for(int i=0;i<euclidian.length;i++)
			{
				System.out.println(euclidian[i]+" ");
			}
			
			//cebisev distance
			double[] cebisev=new double[learningSet.length-1];
			cebisev=FileUtils.CalculateCebisev(learningSet);
			System.out.println("Cebisev distance is: ");
			for(int i=1;i<cebisev.length;i++)
			{
				System.out.println(cebisev[i]);
			}
			
			//cityblock distance
			double[] cityBlock=new double[learningSet.length-1];
			cityBlock=FileUtils.CityBlockDistance(learningSet);
			System.out.println("City Block distance is: ");
			for(int i=1;i<cityBlock.length;i++)
			{
				System.out.println(cityBlock[i]);
			}
			
			//Mahalanobis
			double[] mahalanobis=new double[learningSet.length-1];
			mahalanobis=FileUtils.MahalanobisDistance(learningSet, learningSet.length);
			System.out.println("Mahalanobis distance is: ");
			for(int i=1;i<mahalanobis.length;i++)
			{
				System.out.println(mahalanobis[i]);
			}
			
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
		
		/*try{
			double[] x=new double[learningSet.length];
			double[] y=new double[learningSet.length];
			double[] euclidian=new double[learningSet.length];
		}catch (USVInputFileCustomException e)
		{
			System.out.println(e);
		}*/
		
	}

}


public class SplineCalculator {
	
	private double[] f;
	
	public SplineCalculator(double[] f) {
		this.f = f;
	}
	
	public double solveAtX(double x) {
		double y = 0.0;
		for(int i = 0; i < f.length; i++) {
			y += f[i] * Math.pow(x, f.length-1-i);
		}
		return y;
	}
}

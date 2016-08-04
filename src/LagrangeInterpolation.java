import java.text.DecimalFormat;

import Jama.Matrix;

/*
 * This code is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation; either 
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this program; if not, write to the Free 
 * Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, 
 * MA  02111-1307, USA.
 */

/**
 * Given n points (x0,y0)...(xn-1,yn-1), the following method computes the
 * polynomial factors of the n-1't degree polynomial passing through the n
 * points.
 *
 * Example: Passing in three points (2,3) (1,4) and (3,7) will produce the
 * results [2.5, -8.5, 10] which means that the points is on the curve y = 2.5x²
 * - 8.5x + 10.
 * 
 * @author <a href="mailto:info@geosoft.no">GeoSoft</a>
 */
public class LagrangeInterpolation {
	public static double[] findPolynomialFactors(double[] x, double[] y)
			throws RuntimeException {
		if(x.length == 0 || y.length == 0)
			return new double[0];
		
		int n = x.length;

		double[][] data = new double[n][n];
		double[] rhs = new double[n];

		for (int i = 0; i < n; i++) {
			double v = 1;
			for (int j = 0; j < n; j++) {
				data[i][n - j - 1] = v;
				v *= x[i];
			}

			rhs[i] = y[i];
		}

		// Solve m * s = b

		Matrix m = new Matrix(data);
		Matrix b = new Matrix(rhs, n);

		Matrix s = m.solve(b);

		return s.getRowPackedCopy();
	}

	public static String getPrintableForm(double f[]) {
		DecimalFormat df = new DecimalFormat("#.###");
		String equation = "";
		for (int i = 0; i < f.length; i++) {
			double j = Double.parseDouble(df.format(f[i]));
			if(j!=0) {
				if(equation.length()>=1) {
					equation += " + ";
				}
				if (i < f.length - 1) {
					if(j!=1)
						equation += j + "x^" + (f.length - 1 - i);
					else
						equation += "x^" + (f.length - 1 - i);
				} else {
					equation += j;
				}
			}
		}
		return equation;
	}

	public static void main(String args[]) {
		double x[] = { 2.0, 1.0, 3.0 };
		double y[] = { 3.0, 4.0, 7.0 };

		double f[] = LagrangeInterpolation.findPolynomialFactors(x, y);
		
		System.out.println(getPrintableForm(f));
	}
}

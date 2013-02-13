/**
 * Copyright (C) 2013 pauline ruegg-reymond
 * <pauline.ruegg.reymond@gmail.com>
 * eauservice
 * rue de Genève 36
 * case postale 7416
 * CH-1002 Lausanne
 * 
 * This file is part of SmartWaterMeterReading
 * 
 * SmartWaterMeterReading is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * SmartWaterMeterReading is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.recognizer;

/**
 * Abstract class to perform basic vector and matrices operations.
 * These operations are needed by methods of the class Recognizer.
 * 
 * @author pauline ruegg-reymond
 *
 */
public abstract class LinAlg {
	
	/** Adds two matrices.
	 * @param M - matrix.
	 * @param N - matrix.
	 * @return The sum of two matrices.
	 */
	public static double[][] addMat(double[][] M, double[][]N) {
		if(M.length != N.length || M[0].length != N[0].length) {
			throw new IllegalArgumentException("M and N should have the same dimensions");
		}
		double[][] R = new double[M.length][M[0].length];
		for (int i=0;i<M.length;i++) {
			for (int j=0;j<M[0].length;j++) {
				R[i][j] = M[i][j] + N[i][j];
			}
		}
		return R;
	}
	
	
	
	/**	Adds two vectors.
	 * @param v - vector.
	 * @param w - vector.
	 * @return The sum of two vectors.
	 */
	public static double[] addVect(double[] v, double[] w) {
		if (v.length != w.length) {
			throw new IllegalArgumentException("v and w should have the same dimension.");
		}
		double[] res = new double[v.length];
		for (int i=0;i<v.length;i++) {
			res[i] = v[i] + w[i];
		}
		return res;
	}
	
	
	
	/** Returns the square matrix having given vector as diagonal.
	 * @param v - vector.
	 * @return A square matrix with v as diagonal.
	 */
	public static double[][] diag(double[] v) {
		int n = v.length;
		double[][] A = new double[n][n];
		for (int i=0;i<n;i++) {
			A[i][i] = v[i];
		}
		return A;
	}
	
	
	
	public static double[][] inv2(double[][] A) {
		if (A.length != 2 || A[0].length != 2) {
			throw new IllegalArgumentException("A should be of size 2x2.");
		}
		double det = A[0][0]*A[1][1] - A[0][1]*A[1][0];
		
		double[][] B = new double[2][2];
		B[0][0] = A[1][1];
		B[0][1] = -A[0][1];
		B[1][0] = -A[1][0];
		B[1][1] = A[0][0];
		
		if (1E-10*Math.abs(det) < Math.abs(A[1][0]*B[0][0] + A[1][1]*B[1][0])) return null;
		
		B[0][0] /= det;
		B[0][1] /= det;
		B[1][0] /= det;
		B[1][1] /= det;
		
		return B;
	}
	
	
	
	/** Computes the inverse of a 3x3 matrix.
	 * @param A - matrix to invert.
	 * @return The inverse of A if A is invertible, null if not or if A is not a 3x3 matrix.
	 */
	public static double[][] inv3(double[][] A) {
		if (A.length != 3 || A[0].length != 3) {
			throw new IllegalArgumentException("A should be of size 3x3.");
		}
		double det = A[0][0]*A[1][1]*A[2][2] + A[0][1]*A[1][2]*A[2][0] + A[0][2]*A[2][1]*A[1][0];
		det -= A[0][0]*A[1][2]*A[2][1] + A[1][1]*A[0][2]*A[2][0] + A[2][2]*A[0][1]*A[1][0];
		if (Math.abs(det) < 1E-6) {
			throw new IllegalArgumentException("A is not invertible.");
		}
		
		double[][] B = new double[3][3];
		
		B[0][0] = (A[1][1]*A[2][2] - A[1][2]*A[2][1])/det;
		B[1][0] = (- A[1][0]*A[2][2] + A[2][0]*A[1][2])/det;
		B[2][0] = (A[1][0]*A[2][1] - A[1][1]*A[2][0])/det;
		B[0][1] = (- A[0][1]*A[2][2] + A[0][2]*A[2][1])/det;
		B[1][1] = (A[0][0]*A[2][2] - A[0][2]*A[2][0])/det;
		B[2][1] = (- A[0][0]*A[2][1] + A[0][1]*A[2][0])/det;
		B[0][2] = (A[0][1]*A[1][2] - A[0][2]*A[1][1])/det;
		B[1][2] = (- A[0][0]*A[1][2] + A[0][2]*A[1][0])/det;
		B[2][2] = (A[0][0]*A[1][1] - A[0][1]*A[1][0])/det;
		
		return B;
	}
	
	
	
	/** Multiplies two matrices.
	 * @param A - matrix of size mxl.
	 * @param B - matrix of size lxn.
	 * @return The product A*B = matrix of size mxn.
	 */
	public static double[][] matMult(double[][] A, double[][] B) {
		int m = A.length, l = A[0].length, n = B[0].length;
		if(B.length != l) {
			throw new IllegalArgumentException("A and B should have compatible dimensions.");
		}
		
		double[][] C = new double[m][n];
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				for (int k=0;k<l;k++) {
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		return C;
	}
	
	
	
	/** Multiplies a matrix with a vector.
	 * @param A - matrix of size mxn.
	 * @param b - vector of length n.
	 * @return A vector of length m x = A*b
	 */
	public static double[] matVectMult(double[][] A, double[] b) {
		int m = A.length, n = A[0].length;
		if (b.length != n) {
			throw new IllegalArgumentException("A and b should have compatible dimensions.");
		}
		
		double[] x = new double[m];
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				x[i] += A[i][j]*b[j];
			}
		}
		return x;
	}
	
	
	
	/** Computes the Euclidean norm of a vector.
	 * @param v - vector.
	 * @return The norm of v.
	 */
	public static double norm(double[] v) {
		double res = 0;
		for (int i=0;i<v.length;i++) {
			res += v[i]*v[i];
		}
		res = Math.sqrt(res);
		return res;
	}
	
	
	
	/** Multiplies a matrix by a scalar.
	 * @param a - scalar.
	 * @param M - matrix.
	 * @return The product a*M.
	 */
	public static double[][] scalMatMult(double a, double[][] M) {
		double[][] N = M.clone();
		
		for (int i=0;i<N.length;i++) {
			for (int j=0;j<N[0].length;j++) {
				N[i][j] *= a;
			}
		}
		
		return N;
	}
	
	/** Multiplies a vector by a scalar.
	 * @param a - scalar.
	 * @param v - vector of length n.
	 * @return The product a*v of length n.
	 */
	public static double[] scalVectMult(double a, double[] v) {
		double[] w = v.clone();
		
		for (int i=0;i<v.length;i++) {
			w[i] *= a;
		}
		
		return w;
	}
	
	/** Computes the transpose of a matrix.
	 * @param A - matrix of size mxn.
	 * @return The transpose of A of size nxm.
	 */
	public static double[][] transpose(double[][] A) {
		int m = A.length, n = A[0].length;
		double[][] B = new double[n][m];
		
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				B[j][i] = A[i][j];
			}
		}
		return B;
	}
}

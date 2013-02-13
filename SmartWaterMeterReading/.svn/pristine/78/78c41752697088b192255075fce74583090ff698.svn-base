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

import java.util.Arrays;
import java.util.Vector;

/**
 * Abstract class to perform search operations on arrays.
 * These operations are needed by methods of the class Recognizer.
 * 
 * @author pauline ruegg-reymond
 * 
 */
public abstract class Searcher {
	
	/**	Searches for elements of 'nums' having value 'value'.
	 * @param nums - array to search.
	 * @param value - value to look for.
	 * @return Indices of elements of searched array having value 'value'.
	 */
	public static int[] findAll(int[] nums, int value) {
		Vector<Integer> res = new Vector<Integer>();
		for (int i=0;i<nums.length;i++) {
			if (nums[i] == value) {
				res.add(i);
			}
		}
		
		int res2[] = new int[res.size()];
		for(int i=0;i<res.size();i++) {
			res2[i] = res.get(i);
		}
		return res2;
	}
	
	
	
	/**	Searches for maximal elements in an array.
	 * @param nums - searched array.
	 * @return Indices all maximal elements.
	 */
	public static int[] findAllMax(int[] nums) {
		int max = 0;
		Vector<Integer> res = new Vector<Integer>();
		for (int i=0;i<nums.length;i++) {
			if (nums[i] > max) {
				max = nums[i];
				res.clear();
				res.add(i);
			} else if (nums[i] == max) {
				res.add(i);
			}
		}
		
		
		int[] res2 = new int[res.size()];
		for(int i=0;i<res.size();i++) {
			res2[i] = res.get(i);
		}
		return res2;
	}
	
	
	
	/** Searches for the first maximal element in an array.
	 * @param nums - array to search.
	 * @return Index of the first maximal element.
	 */
	public static int findMax(float[] nums) {
		float max = 0;
		int ind = -1;
		for (int i=0;i<nums.length;i++) {
			if (nums[i] > max) {
				max = nums[i];
				ind = i;
			}
		}
		return ind;
	}
	
	
	
	/** Searches for the first maximal element of an array.
	 * @param nums - array to search.
	 * @return Index of the first maximal element.
	 */
	public static int findMax(int[] nums) {
		int max = 0;
		int ind = -1;
		for (int i=0;i<nums.length;i++) {
			if (nums[i] > max) {
				max = nums[i];
				ind = i;
			}
		}
		return ind;
	}
	
	
	
	/** Searches for the first minimal element of an array.
	 * @param nums - array to search.
	 * @return Index of the first minimal element.
	 */
	public static int findMin(float[] nums) {
		float min = Float.MAX_VALUE;
		int ind = -1;
		for (int i=0;i<nums.length;i++) {
			if (nums[i] < min) {
				min = nums[i];
				ind = i;
			}
		}
		return ind;
	}
	
	
	
	/** Searches for the first minimal element of an array.
	 * @param nums - array to search.
	 * @return Index of the first minimal element.
	 */
	public static int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		int ind = -1;
		for (int i=0;i<nums.length;i++) {
			if (nums[i] < min) {
				min = nums[i];
				ind = i;
			}
		}
		return ind;
	}
	
	
	
	/** Searches the minimum of an array.
	 * @param nums - array to search.
	 * @return Value of the minimal element.
	 */
	public static int min(int nums[]) {
		int min = Integer.MAX_VALUE;
		for (int i=0;i<nums.length;i++) {
			if (nums[i] < min) min = nums[i];
		}
		return min;
	}
	
	
	
	/** Searches the minimum of an array.
	 * @param nums - array to search.
	 * @return Value of the minimal element.
	 */
	public static int max(int nums[]) {
		int max = Integer.MIN_VALUE;
		for (int i=0;i<nums.length;i++) {
			if (nums[i] > max) max = nums[i];
		}
		return max;
	}
	
	/** Counts elements of an array having a given value.
	 * @param nums - arrays to search.
	 * @param value - value to look for.
	 * @return Number of elements of 'nums' having value 'value'.
	 */
	public static int numOf(int[] nums, int value) {
		int res = 0;
		
		for(int i=0;i<nums.length;i++) {
			if (nums[i] == value) {
				res++;
			}
		}
		
		return res;
	}
	
	
	
	public static int[] order(double[] nums) {
		int[] res = new int[nums.length];
		
		for (int i=0;i<nums.length;i++) {
			res[i] = i;
			for (int j=0;j<i;j++) {
				if (nums[i] < nums[res[j]]) {
					int tmp = res[j];
					res[j] = i;
					for(int k=j;k<i;k++) {
						int tmp1 = res[k+1];
						res[k+1] = tmp;
						tmp = tmp1;
					}
					break;
				}
			}
		}
		
		return res;
	}
	
	/** Searches for the first line of a multi-array having a given value.
	 * @param array - mult-array to search.
	 * @param key - array to look for.
	 * @return Index of the first line of array 'array' having value 'key'. 
	 */
	public static int search(int[][] array, int[] key) {
		int res = -1;
		for (int i=0;i<array.length;i++) {
			if (Arrays.equals(array[i],key)) {
				res = i;
				break;
			}
		}
		return res;
	}
	
	/** Searches for the first element of 'array' having value 'key'.
	 * @param array - array to search.
	 * @param key - value to look for.
	 * @return Index of the first element of 'array' having value 'key'.
	 */
	public static int search(int[] array, int key) {
		int res = -1;
		for (int i=0;i<array.length;i++) {
			if (array[i] == key) {
				res = i;
				break;
			}
		}
		return res;
	}
}

package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int N;
	private WeightedQuickUnionUF grid;
	public Percolation(int N) {
		if (N <= 0) {
			throw new java.lang.IllegalArgumentException();
		}
		grid = new WeightedQuickUnionUF(N);
	}// create N-by-N grid, with all sites initially blocked
	public void open(int row, int col) {

	}// open the site (row, col) if it is not open already
	public boolean isOpen(int row, int col) {

	}// is the site (row, col) open?
	public boolean isFull(int row, int col) {
		return true;
	}// is the site (row, col) full?
	public int numberOfOpenSites() {
		return numOfOpen;
	}// number of open sites
	public boolean percolates() {
		return true;
	}// does the system percolate?

	public static void main(String[] args) {

	}// use for unit testing (not required)
}

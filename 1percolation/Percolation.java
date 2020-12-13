/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private int mSize;
    private final int mStartIdx;
    private final int mEndIdx;
    private WeightedQuickUnionUF qf;
    private int mOpenSites = 0;
    private boolean[] mSeen;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        mSize = n;
        int size = n * n + 2;
        mStartIdx = n * n;
        mEndIdx = n * n + 1;
        qf = new WeightedQuickUnionUF(size);
//        for (int i = 1; i <= n; i++) {
//            qf.union(0, i);
//            qf.union(mEndIdx, mEndIdx + i);
//        }
        mSeen = new boolean[size];
        for (int i = 0; i < size; i++)
            mSeen[i] = false;
    }

    private int rci(int r, int c) {
        return mSize * (r - 1) + (c - 1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > mSize || col < 1 || col > mSize) throw new IllegalArgumentException();
        int i = rci(row, col);
        if (!mSeen[i])
            mOpenSites += 1;
        mSeen[i] = true;

        int r2 = row - 1;
        int c2 = col;
        if (r2 > 0)
            if (mSeen[rci(r2, c2)] && mSeen[rci(row, col)])
                qf.union(rci(r2, c2), rci(row, col));

        r2 = row;
        c2 = col + 1;
        if (c2 <= mSize)
            if (mSeen[rci(r2, c2)] && mSeen[rci(row, col)])
                qf.union(rci(r2, c2), rci(row, col));

        r2 = row + 1;
        c2 = col;
        if (r2 <= mSize)
            if (mSeen[rci(r2, c2)] && mSeen[rci(row, col)])
                qf.union(rci(r2, c2), rci(row, col));

        r2 = row;
        c2 = col - 1;
        if (c2 > 0)
            if (mSeen[rci(r2, c2)] && mSeen[rci(row, col)])
                qf.union(rci(r2, c2), rci(row, col));

        if (row == 1)
            qf.union(mStartIdx, rci(row, col));
        if (row == mSize)
            qf.union(mEndIdx, rci(row, col));

        boolean test = percolates();
        System.out.println(test);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > mSize || col < 1 || col > mSize) throw new IllegalArgumentException();
        return mSeen[rci(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > mSize || col < 1 || col > mSize) throw new IllegalArgumentException();
        return qf.connected(mStartIdx,rci(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return mOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return qf.connected(mStartIdx, mEndIdx);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation perc = new Percolation(20);
        perc.percolates();
    }
}



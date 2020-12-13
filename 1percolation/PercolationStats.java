/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class PercolationStats {

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();


    }

    // sample mean of percolation threshold
    public double mean() {
        return 0;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return 0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 0;
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length<2)
            throw new IllegalArgumentException("Specify two args");
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        for (int i=0; i<t; i++){
            Percolation perc = new Percolation(t);

        }
    }

}

import edu.princeton.cs.algs4.StdIn;


public class Permutation {
    public static void main(String[] args){
        if (args.length==0)
            return;

        RandomizedQueue<String> rq = new RandomizedQueue<>();
        String snum = args[0];
        int num = Integer.parseInt(snum);

        System.out.println( num);

        while(!StdIn.isEmpty()) {
            String nextString = StdIn.readString();
            rq.enqueue(nextString);
        }

        while(num>0){
            System.out.println(rq.dequeue());
            num -=1;
        }
    }
}


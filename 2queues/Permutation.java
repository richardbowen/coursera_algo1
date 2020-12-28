
public class Permutation {
    public static void main(String[] args){
        if (args.length==0)
            return;

        String snum = args[0];
        int num = Integer.parseInt(snum);

        System.out.println( num);

        while (!StdIn.isEmpty()){
            String[] vals = StdIn.readAll().split(" ");
            for(String s : vals){
                System.out.println(s);
            }
        }

    }
}


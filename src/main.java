import java.io.File;
import java.io.IOException;
import java.util.*;

public class main{
    public int i=0;
    public double e = 0.0;
    public int ii=0;
    public int j=0;
    public double count=0;
    public double countwrds=0;
    public double result=0;
    public static String fileName="sampleText.txt";
    public main(String fileName, int topN) throws IOException {
        //Complete this constructor

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                computeEntropy(data,topN);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        computeAvgLengthByFirstChar();
        //Set pairs = calculateMinPairDist();
    }

    private void computeEntropy(String s,int topN) {
        //Fill this function
        int n = 0;
        Map<Character, Integer> occ = new HashMap<>();

        for (int c_ = 0; c_ < s.length(); ++c_) {
            char cx = s.charAt(c_);
            if (occ.containsKey(cx)) {
                occ.put(cx, occ.get(cx) + 1);
            } else {
                occ.put(cx, 1);
            }
            ++n;


        }

        for (Map.Entry<Character, Integer> entry : occ.entrySet()) {
            char cx = entry.getKey();
            double p = (double) entry.getValue() / n;
            e += p * log2(p);
        }
        i++;
        if(i==topN)
        {
            System.out.println("\n Entropy :  "+ -e);
        }

    }
    private static double log2(double a) {
        return Math.log(a) / Math.log(2);
    }

    private void computeAvgLengthByFirstChar()
    {
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> wrds = new ArrayList<String>();
        ArrayList<Integer> wrdscnt = new ArrayList<Integer>();
        ArrayList<Integer> wrdslng = new ArrayList<Integer>();
        String key;
        String text = null;
        try {

            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data=data.toLowerCase();
                StringTokenizer multiTokenizer = new StringTokenizer(data, "://.- ,");

                while (multiTokenizer.hasMoreTokens()) {
                    key=multiTokenizer.nextToken();
                    wrds.add(key);
                    // System.out.println(wrds);
                    a.add(String.valueOf(key.charAt(0)));
                    // System.out.println(key);
                }
            }
            // System.out.println(a);
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Initial Character Average Length : ");
        for(ii=0;ii<=(a.size()-1);ii++)
        {
            System.out.println(a.get(ii)+" : "+ result);
            result=0;
            count=1;
            countwrds=1;
            // System.out.println(a.size());
            for (j=0;j<=a.size()-1;j++) {
                if (a.get(ii).equals(a.get(j))) {
                    //System.out.println(wrds.get(ii) + " " + wrds.get(j));

                    count++;
                    countwrds += wrds.get(j).length();

                }
                result=result+ ((count/countwrds)/countwrds)/2;
            }
            //System.out.println(ii);
            //ii=ii+1;

        }


    }



    private Set calculateMinPairDist() {
        //Fill this function


        return null;
    }




    public static void main(String[] args) throws IOException {
        int topN=3;
        new main(fileName,topN);


    }


}

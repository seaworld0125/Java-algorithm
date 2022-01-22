import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1931 {
    static BufferedReader reader;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int N = Integer.parseInt(str);
        int f, s;

        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            str = reader.readLine();
            st = new StringTokenizer(str, " ");
            f = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            Pair p = new Pair(f, s);
            list.add(p);
        }
        Collections.sort(list);
        int ans = 1;
        int time = list.get(list.size()-1).f;
        for(int i = list.size() - 2; i >= 0; i--) {
            if(list.get(i).s <= time) {
                ans++;
                time = list.get(i).f;
            }
        }
        System.out.println(ans);
    }

    static class Pair implements Comparable<Pair>{

        int f;
        int s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        void setF(int f) {this.f = f;}
        void setS(int s) {this.s = s;}

        @Override
        public boolean equals(Object o) {
            return (((Pair) o).f == this.f) && (o.getClass() == this.getClass());
        }
        @Override
        public int hashCode() {
            int hash = 3;
            hash = 33 * hash + this.f;
            hash = 22 * hash + this.s;
            return hash;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.f == o.f) {
                if(this.s < o.s) return -1;
                else return 1;
            }
            else if(this.f < o.f) {return -1;}
            else return 1;
        }
    }
}
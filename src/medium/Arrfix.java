package medium;

/**
 * Created by kekai on 16/8/18.
 */
public class Arrfix {

    public int mindiff(int[] A, int[] B, int[] F) {
        int len = A.length;
        int diff = A.length;
        boolean[] fmark = new boolean[F.length];
        boolean[] amark = new boolean[A.length];
        for(int i = 0; i < fmark.length; i++) {
            //not used
            fmark[i] = false;
        }

        for (int i = 0; i < amark.length ; i++) {
            amark[i] = false;
        }

        for (int i = 0; i < len; i++) {
            if(A[i] == B[i]) {
                diff = diff - 1;
            }else {
                for(int j = 0; j < F.length; j++) {
                    if(B[i] == F[j]) {
                        if(!fmark[j]) {
                            fmark[j] = true;
                            amark[i] = true;
                            diff = diff - 1;
                            break;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < fmark.length; i++){
            if(!fmark[i]) {
                boolean flag = false;
                for(int j = 0; j < amark.length; j++) {
                    if(!amark[j]) {
                        if (A[j] == F[i]) {
                            fmark[i] = true;
                            amark[j] = true;
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag) {
                    count ++;
                }
            }
        }
        return diff + count;
    }
}

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] arr= new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] days = new int[13];
        days[0] = arr[0];
        for(int i=0;i<12;i++){
            days[i+1] = arr[i]+days[i];
        }
        // for(int n:days){
        //     System.out.print(n+" ");
        // }
        // System.out.println();
        String[] aliceA = arriveAlice.split("-");
        String[] aliceL = leaveAlice.split("-");
        String[] bobA = arriveBob.split("-");
        String[] bobL = leaveBob.split("-");
        int A = days[Integer.valueOf(aliceA[0])-1] + Integer.valueOf(aliceA[1]);
        int B = days[Integer.valueOf(aliceL[0])-1] + Integer.valueOf(aliceL[1]);
        int C = days[Integer.valueOf(bobA[0])-1] + Integer.valueOf(bobA[1]);
        int D = days[Integer.valueOf(bobL[0])-1] + Integer.valueOf(bobL[1]);
        //System.out.println(A+ " "+B +" "+C+" "+D);
        // if(B <= C || A >= D)return 0;

        return Math.max(0, Math.min(B,D) - Math.max(A,C)+1);
        // if(B > C)return B -C+1;
        // if(A < D )return D-A+1;

        // if( A < C && B > D)return D-C+1;
        // if(C < A && B < D)return B-A+1;
        // return 0;
    }
}
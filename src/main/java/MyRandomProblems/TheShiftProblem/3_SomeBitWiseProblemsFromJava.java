package MyRandomProblems.TheShiftProblem;

/**
 * These solutions made me weep, because they're so elegant.
 */
class SomeBitWiseProblemsFromJava {
    /**
     * Problem: For an int, find the number of leading zeros (zeros from right)?
     * Implementation is in the Integer.numberOfLeadingZeros() method of Java.
     * 
     * Solution: This is equivalent to finding the location of first one. The exceptional cases
     * are non-positive numbers, where the number of leading is either zero or 32. Now, get ready
     * to weep.
     * 
     * We suppose it has 31 leading zeros. If a number is greater than 1<<16 (one at the 17th place),
     * then it has less than 16 zeros. Now, shift it 16 places to right. 
     * Then again, if it's greater than 1<<8 (one at 9th place), it has less than 8 ones. So subtract 8 zeros, and continue
     * forward, like this is the quick-sort algorithm.
     * 
     * The point is the two inversions we have here, one is looking for first one, second is reasoning in negations,
     * saying if it's greater than this number, then it has less than these number of zeros.
     */
    public int numberOfLeadingZeros(int i){
        if (i<= 0){
            return i == 0 ? 32 : 0;
        }

        int n = 31;  // n is set to 31, because we now it is not negative.

        if (i <= 1<<16){n-=16; i>>>=16;}
        if (i <= 1<<8){n-=8; i>>>=8;}
        if (i <= 1<<4){n-=4; i>>>=4;}
        if (i <= 1<<2){n-=2; i>>>=2;}
        if (i <= 1<<1){n-=1;}   // Note that we don't check for 0, because we already took care of it!

        return n;
    }


}
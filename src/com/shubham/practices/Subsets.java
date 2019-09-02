package com.shubham.practices;

public class Subsets {

    public void generateSubsets(int[] set, CallbackListener callbackListener) {
        generateSubsets(set, -1, "", 0, 0, callbackListener);
    }

    private void generateSubsets(int[] set, int start, String path, int subsetLength, int subsetSum, CallbackListener callbackListener) {
        for (int i = start + 1; i < set.length; i++) {
            performAction(callbackListener, path + "," + i, subsetSum + set[i], subsetLength + 1);
            generateSubsets(set, i, path + "," + i, subsetLength + 1, subsetSum + set[i], callbackListener);
        }
    }

    private void performAction(CallbackListener callbackListener, Object... data) {
        if (callbackListener != null)
            callbackListener.callback("Path = " + data[0], "Sum = " + data[1], "Length = " + data[2]);
    }
}

package com.shubham.practices;

public class Subsets {

    public void generateSubsets(int[] set) {
        for (int i = 0; i < set.length; i++)
            generateSubsets(set, null);
    }

    public void generateSubsets(int[] set, CallbackListener callbackListener) {
        for (int i = 0; i < set.length; i++)
            generateSubsets(set, i, "" + i, 1, set[i], callbackListener);
    }

    private void generateSubsets(int[] set, int start, String path, int subsetLength, int subsetSum, CallbackListener callbackListener) {
        performAction(callbackListener, "Path = " + path, "Sum = " + subsetSum, "Length = " + subsetLength);
        for (int i = start + 1; i < set.length; i++)
            generateSubsets(set, i, path + "," + i, subsetLength + 1, subsetSum + set[i], callbackListener);
    }

    private void performAction(CallbackListener callbackListener, String... data) {
        if (callbackListener != null)
            callbackListener.callback(data);
    }
}

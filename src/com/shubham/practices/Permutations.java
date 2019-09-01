package com.shubham.practices;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<String> getPermutationsList(String str) {
        return getPermutationsList(str.toCharArray());
    }

    public List<String> getPermutationsList(char[] inputArr) {
        List<String> list = new ArrayList();
        permute(inputArr, 0, list, null);
        return list;
    }

    public void generatePermutations(String str, CallbackListener callbackListener) {
        generatePermutations(str.toCharArray(), callbackListener);
    }

    public void generatePermutations(char[] inputArr, CallbackListener callbackListener) {
        permute(inputArr, 0, null, callbackListener);
    }

    private void permute(char[] inputArr, int start, List<String> list, CallbackListener callbackListener) {
        performAction(callbackListener, list, String.valueOf(inputArr, 0, start));
        if (start == inputArr.length - 1) {
            performAction(callbackListener, list, String.valueOf(inputArr, 0, inputArr.length));
            return;
        }

        for (int i = start; i < inputArr.length; i++) {
            swap(inputArr, start, i);
            permute(inputArr, start + 1, list, callbackListener);
            swap(inputArr, start, i);
        }
    }

    private void swap(char[] inputArr, int i, int j) {
        char temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
    }

    private void performAction(CallbackListener callbackListener, List<String> list, String data) {
        if (!data.isEmpty()) {
            if (list != null)
                list.add(data);
            if (callbackListener != null)
                callbackListener.callback(data);
        }
    }
}

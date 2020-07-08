package com.developer.chithlal.ezetaplib;

public
interface MathOps {
    void addTwoNumbers(int op_one,int op_two);
    void subtractTwoNumbers(int op_one,int op_two);
    void onResultFailed(String message);
    void onResultReady(int result);
}

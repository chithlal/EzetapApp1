package com.developer.chithlal.ezetaplib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MathOperation implements MathOps {
    private Context mContext;
    private OperationInterface mOperationInterface;
    private int mResult;
    public static final String MATH_ACTION = "com.developer.chithlal.ezetaplib.math";
    public static final String PARAM_ONE = "param_one";
    public static final String PARAM_TWO = "param_two";
    public static final String PARAM_OPERATION = "OPERATION";
    public static final String OP_ADD = "Add";
    public static final String OP_SUB = "sub";
    public static final int RES_CODE = 100;

    public MathOperation(Context context,OperationInterface operationInterface) {
        mContext = context;
        mOperationInterface = operationInterface;

    }

    @Override
    public void addTwoNumbers(int op_one, int op_two) {
        Intent intent = new Intent();
        intent.setAction(MATH_ACTION);
        intent.putExtra(PARAM_ONE, op_one);
        intent.putExtra(PARAM_TWO, op_two);
        intent.putExtra(PARAM_OPERATION, OP_ADD);
        intent.setType("text/plain");
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            //ActivityHelper activityHelper = new ActivityHelper(this);
            intent.setFlags(0);
            ((Activity)mContext).startActivityForResult(intent,RES_CODE);
        }
    }

    @Override
    public void subtractTwoNumbers(int op_one, int op_two) {
        Intent intent = new Intent();
        intent.setAction(MATH_ACTION);
        intent.putExtra(PARAM_ONE, op_one);
        intent.putExtra(PARAM_TWO, op_two);
        intent.putExtra(PARAM_OPERATION, OP_SUB);
        intent.setType("text/plain");
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
           // ActivityHelper activityHelper = new ActivityHelper(this);
            intent.setFlags(0);
            ((Activity)mContext).startActivityForResult(intent,RES_CODE);
        }
    }

    @Override
    public void onResultFailed(String message) {
        mOperationInterface.onResultError(message);
    }

    @Override
    public void onResultReady(int result) {

        mResult = result;
        mOperationInterface.onResultReady(mResult);

    }
    public interface OperationInterface{
        void onResultReady(int result);
        void onResultError(String message);
    }

}

package com.app.mvp.utils;

/**
 * Log ��������
 * @Author ����ǿ
 */
public class Log {
    public static boolean mIsShow = true;

    /**
     * �����Ƿ��Log����
     *
     * @param pIsShow
     */
    public static void setShow(boolean pIsShow) {
        mIsShow = pIsShow;
    }

    /**
     * ����tag��ӡ���v��Ϣ
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.v(tag, traceInfo + msg);
        }
    }

    /**
     * ����tag��ӡv��Ϣ,����Throwable����Ϣ
     * * @param tag
     *
     * @param msg
     * @param tr
     */
    public static void v(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.v(tag, msg, tr);
        }
    }


    /**
     * ����tag��ӡ���debug��Ϣ
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.d(tag, traceInfo + msg);
        }
    }

    /**
     * ����tag��ӡ����debug��Ϣ ����Throwable����Ϣ
     * * @param tag
     *
     * @param msg
     * @param tr
     */
    public static void d(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.d(tag, msg, tr);
        }
    }

    /**
     * ����tag��ӡ���info����Ϣ
     * * @param tag
     *
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.i(tag, traceInfo + msg);
        }
    }

    /**
     * ����tag��ӡ����info��Ϣ ����Thorwbale����Ϣ
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void i(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.i(tag, msg, tr);
        }
    }

    /**
     * ����tag��ӡ���error��Ϣ
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (mIsShow) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>>";
            android.util.Log.e(tag, traceInfo + msg);
        }
    }

    /**
     * ����tag��ӡ�����error��Ϣ ����Thorwable����Ϣ
     *
     * @param tag
     * @param msg
     * @param tr
     */
    public static void e(String tag, String msg, Throwable tr) {
        if (mIsShow) {
            android.util.Log.e(tag, msg, tr);
        }
    }
}


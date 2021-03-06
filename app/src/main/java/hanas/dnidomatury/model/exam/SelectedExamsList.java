package hanas.dnidomatury.model.exam;

import android.content.Context;

import java.io.Serializable;

public class SelectedExamsList implements Serializable {

    private static final long serialVersionUID = 4029L;
    private volatile static ExamsList list;

    private SelectedExamsList() {}

    public static synchronized ExamsList getInstance(Context context) {
        if (list == null) {
            list = ExamsFileSupportedList.fromFile(true, context);
        }
        return list;
    }
}

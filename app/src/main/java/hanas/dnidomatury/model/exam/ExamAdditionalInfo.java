package hanas.dnidomatury.model.exam;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

import hanas.dnidomatury.model.examSpecific.ExamItemsList;
import hanas.dnidomatury.model.examSpecific.task.Task;
import hanas.dnidomatury.model.examSpecific.task.TasksList;
import hanas.dnidomatury.model.fileSupport.FileSupported;

public class ExamAdditionalInfo extends Observable implements Serializable, FileSupported<ExamAdditionalInfo> {
    public static final String FILE_SUFFIX = "data";
    private String time;
    private String room;
    private String person;
    private String extra;

    @Override
    public String getFileSuffix() {
        return FILE_SUFFIX;
    }

    public void set(String time, String room, String person, String extra) {
        this.time = time;
        this.room = room;
        this.person = person;
        this.extra = extra;
        setChanged();
        notifyObservers();
    }

    private ExamAdditionalInfo() {}

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getPerson() {
        return person;
    }

    public String getExtra() {
        return extra;
    }

    public static ExamAdditionalInfo fromFile(Context context, Exam exam) {
        String fileTitle = FileSupported.getFileTitle(exam, FILE_SUFFIX);
        ExamAdditionalInfo info = FileSupported.fromFile(context, fileTitle);
        if (info == null) return new ExamAdditionalInfo();
        return info;
    }

}

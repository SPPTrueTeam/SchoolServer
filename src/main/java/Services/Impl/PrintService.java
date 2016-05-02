package Services.Impl;

import Entities.Pupil;
import Entities.Subject;
import Entities.Teacher;
import Services.Interfacies.IPrintService;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by Артем on 02.05.2016.
 */
public class PrintService implements IPrintService {

    public InputStream PrintPDFAchivementStatistics(Pupil pupil) {
        return null;
    }

    public InputStream PrintXLSAchivementStatistics(Pupil pupil) {
        return null;
    }

    public InputStream PrintCSVAchivementStatistics(Pupil pupil) {
        return null;
    }

    public InputStream PrintPDFThanksLetter(Pupil pupil, Teacher teacher) {
        return null;
    }

    public InputStream PrintXLSThanksLetter(Pupil pupil, Teacher teacher) {
        return null;
    }

    public InputStream PrintCSVThanksLetter(Pupil pupil, Teacher teacher) {
        return null;
    }

    public InputStream PrintPDFSubjecList(Subject subject) {
        return null;
    }

    public InputStream PrintXLSSubjectList(Subject subject) {
        return null;
    }

    public InputStream PrintCSVSubjectList(Subject subject) {
        return null;
    }

    public InputStream PrintPDFTeacheDaySchedule(Teacher teacher, Date date) {
        return null;
    }

    public InputStream PrintXLSTeacherDaySchedule(Teacher teacher, Date date) {
        return null;
    }

    public InputStream PrintCSVTeacherDaySchedule(Teacher teacher, Date date) {
        return null;
    }

    public InputStream PrintPDFPupilDaySchedule(Pupil pupil, Date date) {
        return null;
    }

    public InputStream PrintXLSPupilDaySchedule(Pupil pupil, Date date) {
        return null;
    }

    public InputStream PrintCSVPupilDaySchedule(Pupil pupil, Date date) {
        return null;
    }
}

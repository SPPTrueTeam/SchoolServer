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

    public InputStream PrintPDFSubjectList(Subject subject) {
        return null;
    }

    public InputStream PrintXLSSubjectList(Subject subject) {
        return null;
    }

    public InputStream PrintCSVSubjectList(Subject subject) {
        return null;
    }

    public InputStream PrintPDFTeacherDaySchedule(Teacher teacher) {
        return null;
    }

    public InputStream PrintXLSTeacherDaySchedule(Teacher teacher) {
        return null;
    }

    public InputStream PrintCSVTeacherDaySchedule(Teacher teacher) {
        return null;
    }

    public InputStream PrintPDFPupilDaySchedule(Pupil pupil) {
        return null;
    }

    public InputStream PrintXLSPupilDaySchedule(Pupil pupil) {
        return null;
    }

    public InputStream PrintCSVPupilDaySchedule(Pupil pupil) {
        return null;
    }

}

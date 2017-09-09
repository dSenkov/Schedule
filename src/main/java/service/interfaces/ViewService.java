package service.interfaces;

import domain.LessonType;

import java.time.DayOfWeek;

public interface ViewService {

    String dayToRussian (DayOfWeek dayOfWeek);

    String getDayByNumber (Integer dayNumber);

    String lessonTypeToRussian (LessonType lessonType);
}

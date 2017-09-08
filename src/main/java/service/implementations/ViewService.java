package service.implementations;

import domain.LessonType;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class ViewService {

    public String dayToRussian(DayOfWeek dayOfWeek) {
        String day = "";
        switch (dayOfWeek) {
            case MONDAY:
                day =  "Понедельник";
            break;
            case TUESDAY:
                day =  "Вторник";
            break;
            case WEDNESDAY:
                day =  "Среда";
            break;
            case THURSDAY:
                day =  "Четверг";
            break;
            case FRIDAY:
                day =  "Пятница";
            break;
            case SATURDAY:
                day =  "Суббота";
                break;
            case SUNDAY:
                day =  "Воскресенье";
            break;
        }
        return day;
    }

    public String getDayByNumber(Integer dayNumber){
        String day = "";
        switch (dayNumber) {
            case 1:
                day =  "Понедельник";
                break;
            case 2:
                day =  "Вторник";
                break;
            case 3:
                day =  "Среда";
                break;
            case 4:
                day =  "Четверг";
                break;
            case 5:
                day =  "Пятница";
                break;
            case 6:
                day =  "Суббота";
                break;
            case 7:
                day =  "Воскресенье";
                break;
        }
        return day;
    }

    public String lessonTypeToRussian (LessonType lessonType){
        String result = "";
        switch (lessonType){
            case LECTURE:
                result = "Лек.";
                break;
            case PRACTISE:
                result = "Прак.";
                break;
            case LAB:
                result = "Лаб.";
                break;
            case CONSULTATION:
                result = "Конс.";
                break;
        }
        return result;
    }
}

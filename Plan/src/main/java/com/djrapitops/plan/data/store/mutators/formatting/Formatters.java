package com.djrapitops.plan.data.store.mutators.formatting;

import com.djrapitops.plan.data.store.objects.DateHolder;
import com.djrapitops.plan.utilities.FormatUtils;

import java.util.Calendar;
import java.util.function.Function;

/**
 * Class that holds static methods for getting new instances of different {@link Formatter}s.
 *
 * @author Rsl1122
 */
public class Formatters {

    private Formatters() {
        /* Static method class */
    }

    public static Formatter<DateHolder> year() {
        return dateHolder -> {
            long date = dateHolder.getDate();
            return date > 0 ? FormatUtils.formatTimeStampYear(date) : "-";
        };
    }

    public static Formatter<Long> yearLongValue() {
        return date -> {
            return date > 0 ? FormatUtils.formatTimeStampYear(date) : "-";
        };
    }

    public static Formatter<DateHolder> day() {
        return dateHolder -> {
            long date = dateHolder.getDate();
            return date > 0 ? FormatUtils.formatTimeStampDay(date) : "-";
        };
    }

    public static Formatter<DateHolder> second() {
        return dateHolder -> {
            long date = dateHolder.getDate();
            return date > 0 ? FormatUtils.formatTimeStampSecond(date) : "-";
        };
    }

    public static Formatter<DateHolder> clock() {
        return dateHolder -> {
            long date = dateHolder.getDate();
            return date > 0 ? FormatUtils.formatTimeStampClock(date) : "-";
        };
    }

    public static Formatter<DateHolder> iso8601NoClock() {
        return dateHolder -> FormatUtils.formatTimeStampISO8601NoClock(dateHolder.getDate());
    }

    public static Formatter<Long> timeAmount() {
        return new TimeAmountFormatter();
    }

    public static Function<Long, Integer> dayOfYear() {
        return date -> {
            Calendar day = Calendar.getInstance();
            day.setTimeInMillis(date);
            return day.get(Calendar.DAY_OF_YEAR);
        };
    }
}
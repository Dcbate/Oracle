
# 📅 Java Time API Guide

The **Java Time API** introduced in **Java 8** provides a modern way to work with dates, times, and durations. This guide covers the key classes and features of the `java.time` package.

## Key Concepts and Classes

- **`Instant`**: Represents a timestamp (date and time) in UTC.
- **`LocalDate`**: Represents a date without a time zone (e.g., 2024-10-24).
- **`LocalTime`**: Represents a time without a date or time zone (e.g., 12:30:45).
- **`LocalDateTime`**: Combines `LocalDate` and `LocalTime` without a time zone.
- **`ZonedDateTime`**: Represents a date and time with a time zone.
- **`Duration`**: Represents the time between two instants.
- **`Period`**: Represents the date-based time between two `LocalDate` instances (days, months, years).

## 📌 `Instant` Example

An `Instant` represents a moment in time, often used for timestamps.

```java
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Current timestamp: " + now);
    }
}
```

### ⏳ Difference between Instants

To find the time between two instants, use `Duration`.

```java
import java.time.Duration;
import java.time.Instant;

public class DurationExample {
    public static void main(String[] args) {
        Instant start = Instant.now();
        // Simulate some work
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration.toMillis() + " milliseconds");
    }
}
```

## 📅 `LocalDate` Example

`LocalDate` is useful for representing a specific date without time.

```java
import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        // Specific date
        LocalDate specificDate = LocalDate.of(2024, 10, 24);
        System.out.println("Specific Date: " + specificDate);
    }
}
```

## ⏰ `LocalTime` Example

`LocalTime` is useful for representing time without any associated date or time zone.

```java
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalTime specificTime = LocalTime.of(12, 30);
        System.out.println("Specific Time: " + specificTime);
    }
}
```

## 🗓 `LocalDateTime` Example

`LocalDateTime` combines date and time without a time zone.

```java
import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current DateTime: " + now);

        LocalDateTime specificDateTime = LocalDateTime.of(2024, 10, 24, 12, 30);
        System.out.println("Specific DateTime: " + specificDateTime);
    }
}
```

## 🌍 `ZonedDateTime` Example

`ZonedDateTime` provides date and time information along with time zone support.

```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime zonedNow = ZonedDateTime.now();
        System.out.println("Current Zoned DateTime: " + zonedNow);

        ZonedDateTime specificZonedDateTime = ZonedDateTime.of(2024, 10, 24, 12, 30, 0, 0, ZoneId.of("Europe/London"));
        System.out.println("Specific Zoned DateTime: " + specificZonedDateTime);
    }
}
```

## 📅 `Period` Example

`Period` deals with date-based amounts of time (years, months, days).

```java
import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2023, 10, 1);
        LocalDate endDate = LocalDate.of(2024, 10, 24);
        
        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");
    }
}
```

## ⏳ `Duration` Example

`Duration` is useful for measuring time between instants or times.

```java
import java.time.Duration;
import java.time.LocalTime;

public class DurationExample {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(12, 30);
        
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Duration: " + duration.toHours() + " hours and " + duration.toMinutesPart() + " minutes");
    }
}
```

---

## 🧠 Summary

- **`Instant`**: Represents a point in UTC time.
- **`LocalDate`, `LocalTime`, `LocalDateTime`**: Date, time, and combination without a time zone.
- **`ZonedDateTime`**: Date and time with a time zone.
- **`Period`**: Difference between two `LocalDate` instances in days, months, or years.
- **`Duration`**: Difference between two `Instant` or `LocalTime` instances in hours, minutes, etc.

---
package learning.basics;

public class DateFormatter {

    public static void main(String[] args) {
        long time = Long.parseLong("1345927283740");
        long years = time / (60 * 60 * 24 * 365);
        time = time % (60 * 60 * 24 * 365);
        long months = time / (60 * 60 * 24 * 30);
        time = time % (60 * 60 * 24 * 30);
        long hours = (time) / (60 * 60);
        time = (time) % (60 * 60);
        long minutes = (time) / 60;
        time = (time) % 60;
        long seconds = time % 60;

        StringBuilder result = new StringBuilder();

        if (years > 0) {
            result.append(years).append(years == 1 ? " year" : " years");
            if (months > 0 || hours > 0 || minutes > 0 || seconds > 0) result.append(", ");
        }

        if (months > 0) {
            result.append(months).append(months == 1 ? " month" : " months");
            if (hours > 0 || minutes > 0 || seconds > 0) result.append(", ");
        }

        if (hours > 0) {
            result.append(hours).append(months == 1 ? " hour" : " hours");
            if (minutes > 0 || seconds > 0) result.append(", ");
        }

        if (minutes > 0) {
            result.append(minutes).append(minutes == 1 ? " minute" : " minutes");
            if (seconds > 0) result.append(", ");
        }

        if (seconds > 0) {
            result.append(seconds).append(seconds == 1 ? " second" : " seconds");
        }

        if (result.length() == 0) System.out.println(result);
        else {
            if (result.lastIndexOf(",") > 0) {
                String str = result.substring(0, result.lastIndexOf(",")) + " and" + result.substring(result.lastIndexOf(",") + 1);
                System.out.println(str);
            } else System.out.println(result);
        }
    }
}

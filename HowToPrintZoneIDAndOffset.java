import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class HowToPrintZoneIDAndOffset {
    public static void main(String[] args) {

        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();
        // Create a list using set of zones
        List<String> zonelist = new ArrayList<String>(allZones);
        Collections.sort(zonelist);
        // iterate the sorted zonelist using for loop
        for (String s : zonelist) {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            Set<String> secondsOfHour = ZoneId.getAvailableZoneIds(); // int secondsOfHour = offset.getTotalSeconds() %
                                                                      // (60 * 60);
            String out = String.format(" %35s %5s%n", zone, offset);
            if (secondsOfHour != null) {
                System.out.println(out);
            }
        }

    }
}

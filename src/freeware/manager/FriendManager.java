package freeware.manager;

import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class FriendManager
{
    public static List<String> friends = new ArrayList<>();

    public static boolean isFriend(final String s) {
        boolean b = false;
        for (String value : friends) {
            if (value.equals(s)) {
                b = true;
                break;
            }
        }
        return b;
    }
    
    public static void AX() {
        try {
            final Stream<String> lines = Files.lines(Paths.get("C:\\freeware\\friends.txt"));
            friends = lines.collect(Collectors.toList());
            if (lines != null) {
                lines.close();
            }
        } catch (Exception e) {
            System.out.println("Arkadas listesi alinamadi.");
        }
    }
}

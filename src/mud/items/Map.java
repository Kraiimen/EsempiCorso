package mud.items;

import mud.rooms.MagicMap;
import mud.rooms.Room;

import java.util.List;

public class Map extends Item {
    private String outputFormat = "%20s%20s%20s%n";
    private List<String> roomsNames = MagicMap.getRooms().stream().map(Room::getName).toList();

    public Map(String name) {
        super(name);
    }

    //NON FUNZ IL PRINTF
    public void printMap(){
        System.out.printf(outputFormat,roomsNames.get(9),roomsNames.get(0),roomsNames.get(1));
        System.out.printf(outputFormat,roomsNames.get(4),roomsNames.get(2),roomsNames.get(3));
        System.out.printf(outputFormat,"",roomsNames.get(5),"");
        System.out.printf(outputFormat,"",roomsNames.get(6),"");
        System.out.printf(outputFormat,"",roomsNames.get(7),"");
        System.out.printf(outputFormat,"",roomsNames.get(8),"");
    }
}

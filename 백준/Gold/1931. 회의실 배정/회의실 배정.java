import java.util.*;
import java.io.*;

class Main {

    public static class Room implements Comparable<Room>{
        int start;
        int finish;

        public Room(int start, int finish){
            this.start = start;
            this.finish = finish;
        }

        @Override
        public int compareTo(Room room){
            if(this.finish == room.finish){
                return Integer.compare(this.start, room.start);
            }
            return Integer.compare(this.finish, room.finish);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Room> rooms = new ArrayList<>();
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());

            rooms.add(new Room(start, finish));
        }

        Collections.sort(rooms);

        int count = 0;
        int hour = 0;
        for(int i = 0 ; i < N ; i++){
            Room room = rooms.get(i);
            if(hour <= room.start){
                hour = room.finish;
                count++;
            }
        }

        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Exercise1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //int ticketsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ticketsTemp = new ArrayList<>();

        /*IntStream.range(0, ticketsCount).forEach(i -> {
            try {
                ticketsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> tickets = ticketsTemp.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        */
        List<Integer> tickets = new ArrayList<>();
        tickets.add(9);
        tickets.add(7);
        tickets.add(6);
        tickets.add(5);
        tickets.add(4);
        tickets.add(6);
        int res = maxTickets(tickets);
        System.out.println("result:"+res);
    }

    private static int maxTickets(List<Integer> tickets) {
        findSubLists(tickets);

        return 0;
    }

    private static void findSubLists(List<Integer> seed) {
        seed.sort(Comparator.naturalOrder());
        for (int x = 0; x < seed.size(); x++) {
            System.out.print(seed.get(x) + ",");
        }
        System.out.println();
        System.out.println();
        System.out.println("cantidad:"+seed.size());

       for(int i=0; i < seed.size(); i++) {

           for (int j = 0; j < seed.size(); j++) {
               System.out.print(seed.get(j) + ",");
               for (int k = j + 1; k < seed.size() - 1; k++) {
                   System.out.println(seed.get(k));
               }
           }
           System.out.println();
       }
    }

    /*
    4
4
13
2
3
     */
}

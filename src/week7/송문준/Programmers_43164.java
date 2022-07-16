package week7.송문준;

import java.util.*;

public class Programmers_43164 {
    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        Map<String, Ticket> map = new HashMap<>();

        linkNext(tickets, map);

        sortNext(map);

        int cnt = map.size();
        dfs(map.get("ICN"), result, cnt - 1);

        return result.toArray(new String[result.size()]);
    }

    private void sortNext(Map<String, Ticket> map) {
        for (Map.Entry<String, Ticket> ele : map.entrySet()) {
            Collections.sort(ele.getValue().next);
        }
    }

    private void linkNext(String[][] tickets, Map<String, Ticket> map) {
        for (String[] ticket : tickets) {
            Ticket from = map.getOrDefault(ticket[0], new Ticket(ticket[0]));
            Ticket to = map.getOrDefault(ticket[1], new Ticket(ticket[1]));
            from.addNext(to);

            map.put(ticket[0], from);
            map.put(ticket[1], to);
        }
    }

    private void dfs(Ticket ticket, List<String> result, int cnt) {
        if (cnt != 0 && ticket.next.size() == 0) {
            ticket.visited = false;
        } else {
            result.add(ticket.airPort);

            for (Ticket next : ticket.next) {
                if (!ticket.visited || !next.visited) {
                    ticket.visited = true;
                    dfs(next, result, cnt - 1);
                }
            }
        }
    }

    static class Ticket implements Comparable<Ticket> {
        String airPort;
        boolean visited;
        List<Ticket> next;

        public Ticket(String airPort) {
            this.airPort = airPort;
            this.next = new LinkedList<>();
        }

        public void addNext(Ticket ticket) {
            next.add(ticket);
        }

        @Override
        public int compareTo(Ticket o) {
            return airPort.compareTo(o.airPort);
        }
    }
}

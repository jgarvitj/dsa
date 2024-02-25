class Solution {

    class Element {

        Integer val;
        Integer time;

        Element(Integer val, Integer time) {
            this.val = val;
            this.time = time;
        }
 
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {


        //sort meeting time, in what cases will it be benificial to sort
        // Arrays.sort(meetings, Comparator.comparingInt(e -> e[2]));

        Map<Integer, List<Element>> adjList = getAdjList(meetings);
        Map<Integer, Integer> nodeSecretTimeMap = new HashMap<>();
        nodeSecretTimeMap.put(0, 0);
        nodeSecretTimeMap.put(firstPerson, 0);

        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(0);
        bfs.add(firstPerson);

        //parse bfs
        Integer curr = bfs.poll();
        while(curr != null) {
            if(adjList.containsKey(curr)) {
            List<Element> adjNodes = adjList.get(curr);
                for(Element e : adjNodes) {
                    //is meeting is happening after curr has the secret, else not need to parse
                    if(nodeSecretTimeMap.get(curr) <= e.time) {
                        //is secret already known, can we update earliest secret known time for element
                        if(
                            (!nodeSecretTimeMap.containsKey(e.val) || 
                            nodeSecretTimeMap.containsKey(e.val) && nodeSecretTimeMap.get(e.val) > e.time)
                            ) {
                            bfs.add(e.val);
                            nodeSecretTimeMap.put(e.val, e.time);
                        }
                    }
                }
            }
            curr = bfs.poll();
        }
        return new ArrayList<>(nodeSecretTimeMap.keySet());
        
    }

    private Map<Integer, List<Element>> getAdjList(int[][] meetings) {

        Map<Integer, List<Element>> adjList = new HashMap<>();
        for(int i = 0; i < meetings.length; i++) {

            Element e1 = new Element(meetings[i][1], meetings[i][2]);
            addElement(adjList, meetings[i][0], e1);

            Element e2 = new Element(meetings[i][0], meetings[i][2]);
            addElement(adjList, meetings[i][1], e2);
        }


        return adjList;
    }

    private void addElement(Map<Integer, List<Element>> adjList, Integer key, Element val) {

        if(!adjList.containsKey(key)) {
            List<Element> vals = new ArrayList<>();
            adjList.put(key, vals);
        }

        adjList.get(key).add(val);
              
    }
}

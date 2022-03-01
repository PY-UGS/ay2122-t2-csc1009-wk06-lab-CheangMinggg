import java.util.*;

public class lab6{

     public static void main(String []args){
        LinkedList<Integer> list = initializeLinkedList();
        
        
        Scanner obj = new Scanner(System.in);

        list = addAndSort(list, 11);
        System.out.println("===============");
        list = swapValues(list, 1, 5);
        System.out.println("===============");
        
        LinkedList<Integer> newRandomList = generateRandomList();
        int random_int = (int)Math.floor(Math.random()*(9999-1000+1)+1000);
        System.out.println("random value generated = " + random_int);
        int searchResult = search(newRandomList, random_int);
        System.out.println("Does " + random_int + " exist: " + searchResult);
        System.out.println("==============================================");

        Q4(obj);
        Q5(obj);
        Q6(obj);
     }
     
     public static LinkedList<Integer> initializeLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
         
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(7);
        linkedList.add(9);
         
        return linkedList;
     }
     
     public static LinkedList<Integer> addAndSort(LinkedList<Integer> list, int value) {
        System.out.println("before add = " + list);
        
        LinkedList<Integer> newList = new LinkedList<>();
        
        for (int i=0; i<list.size();i++) {
            int currentElement = list.get(i);
            
            if (value <= currentElement) {
                newList.add(value);
            }
            
            newList.add(currentElement);
        }
        
        // if value is the largest, to be placed at the end
        if (list.size() == newList.size()) {
            newList.add(value);
        }
        
        System.out.println("after add = " + newList);
        return newList;
     }
     
     public static LinkedList<Integer> swapValues(LinkedList<Integer> list, int indexOne, int indexTwo) {
        System.out.println("before swap = " + list);
         
        int indexOneValue = list.get(indexOne);
        int indexTwoValue = list.get(indexTwo);
         
        list.set(indexOne, indexTwoValue);
        list.set(indexTwo, indexOneValue);
         
        System.out.println("after swap = " + list);
        return list;
     }
     
     public static LinkedList<Integer> generateRandomList() {
        LinkedList<Integer> list = new LinkedList<>();
        
        int min = 1000;
        int max = 9999;
        
        for (int i=0; i<500; i++) {
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            list.add(random_int);
        }
        
        System.out.println("random generated list = " + list);
        System.out.println("==============================================");
        return list;
     }
     
     public static int search(LinkedList<Integer> list, int searchValue) {
        int size = list.size();
        for (int i=0; i<size; i++) {
            int current = list.get(i);
            
            if (current == searchValue) {
                return 1;    
            }
        }
        return -1;
     }
     
     public static void Q4(Scanner input) {

        HashMap<Integer, Integer> HashMap = new HashMap<Integer, Integer>();
        HashMap.put(0, 1);
        HashMap.put(1, 3);
        HashMap.put(2, 5);
        HashMap.put(3, 7);
        HashMap.put(4, 9);
        HashMap.put(5, 11);

        /* Before */
        for (int i = 0; i < HashMap.size(); i++) {
            System.out.print(HashMap.get(i) + " ");
        }
        /* After */
        System.out.println("\nInsert a number into HashMap: \n");
        AddAndSortHM(HashMap, input.nextInt());
        for (int i = 0; i < HashMap.size(); i++) {
            System.out.print(HashMap.get(i) + " ");
        }
        System.out.println(" ");
    }

    public static void Q5(Scanner input) {

        HashMap<Integer, Integer> HashMap = new HashMap<Integer, Integer>();
        HashMap.put(0, 1);
        HashMap.put(1, 3);
        HashMap.put(2, 5);
        HashMap.put(3, 7);
        HashMap.put(4, 9);
        HashMap.put(5, 11);

        /* Before */
        for (int i = 0; i < HashMap.size(); i++) {
            System.out.print(HashMap.get(i) + " ");
        }
        /* After */
        System.out.println("\nSwap 2 indexes in the HashMap: \n");
        SwapHM(HashMap, input.nextInt(), input.nextInt());
        for (int i = 0; i < HashMap.size(); i++) {
            System.out.print(HashMap.get(i) + " ");
        }
    }

    public static void Q6(Scanner input) {

        HashMap<Integer, Integer> HashMap = new HashMap<Integer, Integer>();

        System.out.println(" ");
        for (int i = 0; i < 500; i++) {
            HashMap.put(i, (int) (Math.random() * (9999 - 1000 + 1)) + 1000);
        }
        System.out.println("\n");
        /* Before */
        for (int i = 0; i < HashMap.size(); i++) {
            System.out.print(HashMap.get(i) + " ");
        }
        /* After */
        System.out.println("\nSearch a number: ");
        int idx = FindValueHM(HashMap, input.nextInt());
        System.out.println("\nInput number is found in index " + idx);

    }

    public static void AddAndSort(LinkedList<Integer> list, int value) {
        int idx = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < value) {
                idx += 1;
                continue;
            } else {
                idx = list.indexOf(list.get(i));
                break;
            }

        }

        list.add(idx, value);

    }

    public static void Swap(LinkedList<Integer> list, int val1, int val2) {

        int listSize = list.size() - 1;
        if (val1 > listSize || val2 > listSize) {
            System.out.println("\n Index is out of range!");
            return;
        }

        int temp = list.get(val1);
        list.set(val1, list.get(val2));
        list.set(val2, temp);

    }

    public static int FindValue(LinkedList<Integer> list, int value) {

        if (list.contains(value)) {
            return list.indexOf(value);
        } else {
            return -1;
        }

    }

    public static void AddAndSortHM(HashMap<Integer, Integer> hashmap, int value) {

        hashmap.put(hashmap.size(), value);

        ArrayList<Integer> hmlist = new ArrayList<>(hashmap.values());
        hmlist.sort((a, b) -> a.compareTo(b));

        for (int i = 0; i < hashmap.size(); i++) {
            hashmap.put(i, hmlist.get(i));
        }

    }

    public static void SwapHM(HashMap<Integer, Integer> hashmap, int value, int value2) {

        int idx1 = hashmap.get(value);
        int idx2 = hashmap.get(value2);
        hashmap.put(value, idx2);
        hashmap.put(value2, idx1);
        
    }

    public static int FindValueHM(HashMap<Integer, Integer> hashmap, int value) {


        for (int i = 0; i < hashmap.size(); i++) {

            if (hashmap.get(i) == value) {
                return i;
            }

        }

        return -1;

    }
}
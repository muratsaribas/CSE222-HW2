public class TestList {
    public static void main(String[] args){
        MSArrayList<Integer> aList = new MSArrayList<>();
        MSLinkedList<Integer> lList = new MSLinkedList<>();

        aList.add(10);
        aList.add(20);
        aList.add(30);
        aList.add(40);
        aList.add(50);

        System.out.println("#######################");
        aList.print();
        System.out.println("#######################");

        aList.add(2, 35);
        aList.add(0,28);
        System.out.println("#######################");
        aList.print();
        System.out.println("#######################");


        System.out.println(aList.get(0));
        System.out.println(aList.get(3));

        aList.set(1, 11);
        aList.set(2, 15);
        System.out.println("#######################");
        aList.print();
        System.out.println("#######################");

        aList.remove(0);
        aList.remove(3);
        System.out.println("#######################");
        aList.print();
        System.out.println("#######################");

        Integer integer = 40;
        aList.remove(integer);
        System.out.println("#######################");
        aList.print();
        System.out.println("#######################");

        System.out.println(aList.size());
        System.out.println(aList.isEmpty());
        System.out.println(aList.indexOf(50));
        System.out.println(aList.contains(30));
        System.out.println(aList.contains(15));

        System.out.println("########## LINKED LIST #############");
        lList.add(1);
        lList.add(2);
        lList.add(3);
        lList.addFirst(0);
        lList.addLast(5);
        lList.add(4, 4);

        System.out.println("#######################");
        lList.print();
        System.out.println("#######################");

        System.out.println(lList.getFirst());
        System.out.println(lList.getLast());
        System.out.println(lList.contains(3));
        System.out.println(lList.indexOf(3));

        lList.remove(0);
        integer = 2;
        lList.remove(integer);
        integer = 5;
        lList.remove(integer);
        System.out.println("#######################");
        lList.print();
        System.out.println("#######################");

        System.out.println(lList.get(0));
        System.out.println(lList.get(2));

        lList.set(1, 9);
        System.out.println("#######################");
        lList.print();
        System.out.println("#######################");

        MSArrayList<Integer> ms1 = new MSArrayList<>();
        ms1.add(10);
        ms1.add(15);
        ms1.add(35);
        MSArrayList<Integer> ms2 = new MSArrayList<>();
        ms2.add(99);
        ms2.add(88);
        ms2.add(77);
        MSArrayList<Integer> ms3 = new MSArrayList<>();
        ms3.add(22);
        ms3.add(33);
        ms3.add(55);

        HybridList<Integer> hl1 = new HybridList<>();
        hl1.add(ms1);
        hl1.add(ms2);
        hl1.add(ms3);

        System.out.println("#######################");
        hl1.print();
        System.out.println("#######################");

        System.out.println(hl1.size());

        MSArrayList<Integer> temp = hl1.get(0);
        temp.print();

        hl1.remove(2);
        System.out.println("#######################");
        hl1.print();
        System.out.println("#######################");





    }
}
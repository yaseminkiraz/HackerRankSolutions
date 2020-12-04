package yk.InterviewPreparationKit.CTCI_Chapter1_ArraysAndStrings;
//fun snacks!!

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final String[] names = {"Test1","Test2"};

        final ArrayList<String> books = new ArrayList<>();

        books.add("Hello");
        books.add("Hallo");
        books.add("Hii");

        if(books.contains("Hii"))
            System.out.println("HiiContains");

        System.out.println(books.get(0));

        Comparator c = Collections.reverseOrder();
        Collections.sort(books,c);
//        Collections.sort(books);

        books.set(2,"bıdı");
        System.out.println(books.lastIndexOf("Hello"));



        Consumer<String> printConsumer = new Consumer<>() {
            public void accept(String name) {
                if (name.equals("Hello"))
                    System.out.println(name);
            }
        };

        books.forEach(printConsumer);


        books.forEach(name -> {
            if(name.contains("H"))
                System.out.println(name);
        });

        ArrayList<Student> arraylist = new ArrayList<>();
        arraylist.add(new Student(223, "Jake"));
        arraylist.add(new Student(200, "Miley"));
        arraylist.add(new Student(100, "Jasmin"));

        arraylist.forEach(st -> System.out.println(st.Id));

        Collections.sort(arraylist);
        arraylist.forEach(st -> System.out.println(st.Id));


        ArrayList<Integer> list= new ArrayList<>();
        System.out.println("Initial Capacity:" + findCapacity(list));
        for (int i=0;i<10;i++)
            list.add(i);
        System.out.println("Size increases, capacity:" + findCapacity(list));
        for (int i=10;i<25;i++) {
            list.add(i);
            System.out.println("Size increases,i:" + i + " capacity:" + findCapacity(list));
        }

        list.trimToSize();
        System.out.println("Capacity after trimToSize: " + findCapacity(list));

        Stream<Integer> streamOfCollection = list.stream();
        Optional<Integer> anyElement = streamOfCollection.filter(element -> element == 10).findAny();

        System.out.println("Stream.filter().findAny(): " + (anyElement.isPresent() ? anyElement.get():""));

//        List<String> collectorCollection =
                arraylist.stream().map(Student::getName)
                        .collect(Collectors.toList()).forEach(System.out::println);

        String collector =
                arraylist.stream().map(Student::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(collector);

    }

    private static int findCapacity(ArrayList<Integer> list) throws NoSuchFieldException, IllegalAccessException {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(list)).length;
    }

    public static class Student implements Comparable{
        private  int Id;
        private String name;

        private Student(int id, String name) {
            Id = id;
            this.name = name;
        }

        private int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        private String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Object o) {
            int objectId=((Student)o).getId();
            System.out.println("ida:" + objectId +"Id:"+ this.Id);

            /* For Ascending order*/
            return this.Id-objectId;

            /* For des order*/
//            return objectId-this.Id;
        }
    }

}

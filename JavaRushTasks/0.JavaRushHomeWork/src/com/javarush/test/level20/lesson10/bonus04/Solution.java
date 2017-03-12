package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements Serializable, Cloneable, List<String>
{


    int size = 0;
    Node<String> first;
    Node<String> last;


    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException
    {
        List<String> listTree = new Solution();
        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());

        for (int i = 1; i < 16; i++)
        {
            listTree.add(String.valueOf(i));
        }
        System.out.println(listTree);


        System.out.println("Check isEmpty: " + listTree.isEmpty() + " Size: " + listTree.size());
        List<String> list2222 = new Solution();
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        list2222.add("test");
        System.out.println("Check isEmpty: " + list2222.isEmpty() + " Size: " + list2222.size());
        List<String> list1111 = new Solution();
        System.out.println("Check isEmpty: " + list1111.isEmpty() + " Size: " + list1111.size());

        System.out.println("\nExpected null, actual is " + ((Solution) listTree).getParent("1"));
        System.out.println("Expected 3, actual is " + ((Solution) listTree).getParent("8"));
        listTree.remove("5");
        System.out.println("Expected null, actual is " + ((Solution) listTree).getParent("11"));
        listTree.clear();
        for (int i = 1; i < 16; i++)
        {
            listTree.add(String.valueOf(i));
        }

        //For additional check correct work clone method
        Solution list = ((Solution) listTree).clone();

        System.out.println("Start value with using clone: " + listTree);
        System.out.println("\n===== REMOVE Remove 2 and 9 =====");
        list.remove("2");
        list.remove("9");
        for (String s : list) System.out.print(s + " ");
        System.out.println("\n===== ADD 16, 17, 18, 19, 20 =====");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        for (String s : list) System.out.print(s + " ");
        System.out.println("\n===== REMOVE 18 and 20 =====");
        list.remove("18");
        list.remove("20");
        for (String s : list) System.out.print(s + " ");
        System.out.println("\n===== ADD 21 and 22 =====");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("25");
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        list.add("30");
        list.add("31");
        list.add("32");
        //list.add(null);
        for (String s : list) System.out.print(s + " ");
        System.out.println("\n---------------------------------------");
        System.out.println("3 Expected 1, actual is " + ((Solution) list).getParent("3"));
        System.out.println("4 Expected 1, actual is " + ((Solution) list).getParent("4"));
        System.out.println("8 Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println("11 Expected null, actual is " + ((Solution) list).getParent(null));
        System.out.println("15 Expected 7, actual is " + ((Solution) list).getParent("15"));
        System.out.println("16 Expected 7, actual is " + ((Solution) list).getParent("16"));
        System.out.println("10 Expected 4, actual is " + ((Solution) list).getParent("10"));
        System.out.println("17 Expected 8, actual is " + ((Solution) list).getParent("17"));
        System.out.println("19 Expected 10, actual is " + ((Solution) list).getParent("19"));
        System.out.println("21 Expected 10, actual is " + ((Solution) list).getParent("21"));
        System.out.println("22 Expected 15, actual is " + ((Solution) list).getParent("22"));
        System.out.println("--->> By task and add more item:");
        System.out.println("23 Expected 15, actual is " + ((Solution) list).getParent("23"));
        System.out.println("24 Expected 16, actual is " + ((Solution) list).getParent("24"));
        System.out.println("25 Expected 16, actual is " + ((Solution) list).getParent("25"));
        System.out.println("26 Expected 17, actual is " + ((Solution) list).getParent("26"));
        System.out.println("27 Expected 17, actual is " + ((Solution) list).getParent("27"));
        System.out.println("28 Expected 19, actual is " + ((Solution) list).getParent("28"));
        System.out.println("29 Expected 19, actual is " + ((Solution) list).getParent("29"));
        System.out.println("30 Expected 21, actual is " + ((Solution) list).getParent("30"));
        System.out.println("31 Expected 21, actual is " + ((Solution) list).getParent("31"));
        System.out.println("32 Expected 22, actual is " + ((Solution) list).getParent("32"));
        System.out.println("---------------------------------------");
        System.out.println("Size array = " + list.size() + " expected = 22");
        System.out.println();

        System.out.println("=============== Clone test ==================");

        System.out.println("Object: " + list + " --> Size = " + list.size());
        Solution sol = list.clone();
        //list.remove("7"); //Select for test
        System.out.println("Clone object: " + sol + " --> Size = " + sol.size());
        System.out.println("Result: " + list.containsAll(sol));

        System.out.println("\nTest addAll: ");
        Solution add = new Solution();
        add.addAll(sol);
        System.out.println(add + " --> Size: " + add.size() + " = " + sol.size());

        System.out.println("=============== Iterator test ===============");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext())
        {
            String a = itr.next();
            System.out.print(a + " ");
        }
        System.out.println("\nExpected size 22 = " + list.size());

        System.out.println("\nIter remove");
        Iterator<String> itr2 = list.iterator();
        while (itr2.hasNext())
        {
            if (itr2.next().contains("31"))
            {
                itr2.remove();
            }
        }
        System.out.println("For test " + list + " --> Size = " + list.size());
        System.out.println("Collect size " + list.size() + " Expected 21");

        System.out.println("\n===== SERIALIZATION and DESERIALIZATION =====");
        System.out.println("Collect before serializable " + list);
        System.out.print("Save list");
        FileOutputStream fos = new FileOutputStream("file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
        System.out.println(" Serializable done");
        System.out.print("Load list");
        FileInputStream fis = new FileInputStream("file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<String> list2 = (List<String>) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(" Deserializable done");
        System.out.println("Collect after deserializable " + list2);

        System.out.println("\n================ Clear test =================");
        System.out.println("Before: " + listTree);
        listTree.clear();
        System.out.println("After clear: " + listTree + (listTree.isEmpty() ? " OK" : " Badly"));
    }

    public String getParent(String value)
    {

        for (Node<String> x = first; x != null; x = x.next)
        {
            if (value == null && x.item == null)
            {
                return x.parent != null ? x.parent.item : null;
            }
            if (x.item.equals(value))
            {
                return x.parent != null ? x.parent.item : null;
            }
        }
        return null;
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public void clear()
    {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o)
    {
        for (Node<String> x = first; x != null; x = x.next)
        {
            if (o.equals(x.item))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(String s)
    {
        if (first == null)
        {
            first = new Node<>(null, s, null);
            last = first;
        } else if (last.equals(first))
        {
            last = new Node<>(null, s, first);
            first.next = last;
        } else if (last.parent == null)
        {
            first.firstChild = new Node<>(first, s, last);
            last.next = first.firstChild;
            last = first.firstChild;
        } else if (last.parent.secondChild == null)
        {
            last.parent.secondChild = new Node<>(last.parent, s, last);
            last = last.parent.secondChild;
            last.parent.firstChild.next = last;
        } else
        {
            for (Node<String> x = last.parent.next; x != null; x = x.next)
            {
                if (x.firstChild == null)
                {
                    x.firstChild = new Node<>(x, s, last);
                    last.next = x.firstChild;
                    last = x.firstChild;
                    break;
                }
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        if (o == null)
        {
            for (Node<String> x = first; x != null; x = x.next)
            {
                if (x.item == null)
                {
                    final Node<String> next = x.next;
                    final Node<String> prev = x.prev;
                    final Node<String> parent = x.parent;
                    final Node<String> firstCh = x.firstChild;
                    final Node<String> secondCh = x.secondChild;

                    if (prev == null)
                    {
                        first = next;
                    } else
                    {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null)
                    {
                        last = prev;
                    } else
                    {
                        next.prev = prev;
                        x.next = null;
                    }


                    if (parent != null)
                    {
                        if (parent.firstChild.item == null)
                        {
                            parent.firstChild = parent.secondChild;
                        }
                        parent.secondChild = null;
                    }

                    x = null;

                    if (firstCh != null) remove(firstCh.item);
                    if (secondCh != null) remove(secondCh.item);

                    size--;
                    remove(o);
                    return true;
                }
            }
            return false;
        } else
        {
            for (Node<String> x = first; x != null; x = x.next)
            {
                if (o.equals(x.item))
                {
                    final Node<String> next = x.next;
                    final Node<String> prev = x.prev;
                    final Node<String> parent = x.parent;
                    final Node<String> firstCh = x.firstChild;
                    final Node<String> secondCh = x.secondChild;

                    if (prev == null)
                    {
                        first = next;
                    } else
                    {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null)
                    {
                        last = prev;
                    } else
                    {
                        next.prev = prev;
                        x.next = null;
                    }

                    if (parent != null)
                    {
                        if (parent.firstChild.item.equals(o))
                        {
                            parent.firstChild = parent.secondChild;
                        }
                        parent.secondChild = null;
                    }

                    x = null;

                    if (firstCh != null) remove(firstCh.item);
                    if (secondCh != null) remove(secondCh.item);

                    size--;
                    remove(o);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException
    {

        //super.clone();

        Solution clone = new Solution();
        for (Node<String> x = first; x != null; x = x.next)
        {
            clone.add(x.item);
        }
        return clone;
    }

    @Override
    public Iterator<String> iterator()
    {
        return new Iter(this);
    }

    private static class Node<E> implements Serializable
    {
        E item;
        Node<E> prev;
        Node<E> next;
        Node<E> parent;
        Node<E> firstChild;
        Node<E> secondChild;

        Node(Node<E> parent, E element, Node<E> prev)
        {
            this.item = element;
            this.parent = parent;
            this.prev = prev;
        }
    }

    private class Iter implements Iterator<String>
    {
        private Solution context;
        private Node<String> node;

        private Iter(Solution s)
        {
            this.context = s;
        }

        @Override
        public void remove()
        {
            if (node != null)
            {
                node = node.next;
                context.remove(node.prev.item);
                node = node.prev;
            }
        }

        @Override
        public boolean hasNext()
        {
            if (node != null) return node.next != null;
            return first != null;
        }

        @Override
        public String next()
        {
            if (node != null)
            {
                node = node.next;
                return node.item;
            } else if (first != null)
            {
                node = first;
                return first.item;
            }
            return null;
        }
    }
}

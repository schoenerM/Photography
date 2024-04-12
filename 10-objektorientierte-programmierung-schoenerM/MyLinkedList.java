public class MyLinkedList<E> {
    MyNode<E> head = null;

    public int size() {
        int i;
        MyNode<E> listElement = head;
        if (head == null)
            return 0;
        else {
            for (i = 1; listElement.next != null; i++)
                listElement = listElement.next;
            return i;
        }
    }

    public String toString() {
        MyNode<E> listElement = head;
        StringBuilder result = new StringBuilder(this.size());
        while (listElement != null) {
            result.append("'");
            result.append(listElement.value);
            result.append("' ");

            listElement = listElement.next;
        }

        return result.toString();
    }

    public void add(E e) {
        MyNode<E> nodeToAdd = new MyNode<>(e);
        if (head == null)
            head = nodeToAdd;
        else {
            //go through the list
            MyNode<E> listElement = head;
            while (listElement.next != null)
                listElement = listElement.next;

            //make last element next reference the new element (instead of null)
            listElement.next = nodeToAdd;
            nodeToAdd.next = null;
        }
    }

    public boolean add(E e, int index) {
        MyNode<E> nodeToAdd = new MyNode<>(e);
        if ((index < this.size()) && (index >= 0)) {

            MyNode<E> prevListElement = head;
            MyNode<E> listElement = head.next;
            if (index == 0) {
                nodeToAdd.next = head;
                //exchange references(nodeToAdd becomes head and vice versa)
                MyNode<E> temp = head;
                head = nodeToAdd;
                nodeToAdd = temp;

            } else {
                //go through the list
                for (int i = 1; i < index; i++) {
                    prevListElement = prevListElement.next;
                    listElement = prevListElement.next;
                }

                //make previous element next reference the new element
                nodeToAdd.next = listElement;
                prevListElement.next = nodeToAdd;
            }
        } else throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + this.size());
        return true;
    }

    public E remove(int index) {
        E removed = null;


        //go through the list
        MyNode<E> listElement = head;
        MyNode<E> nodeToRemove = head.next;
        if ((index < this.size()) && (index >= 0)) {
            if (index == 0) {
                removed = head.value;
                head = head.next;
            } else {
                for (int i = 1; i < index; i++) {
                    listElement = listElement.next;
                    nodeToRemove = listElement.next;
                }

                //make element next = the following elements next
                //(leaving that element for the garbage collector)
                removed = nodeToRemove.value;
                listElement.next = nodeToRemove.next;
            }
        } else
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + this.size());

        return removed;
    }

    public E get(int index) {
        MyNode<E> listElement = head;

        if ((index < this.size()) && (index >= 0)) {

            for (int i = 0; i < index; i++)
                listElement = listElement.next;
        } else
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + this.size());

        return listElement.value;
    }


    public static class MyNode<E> {
        E value;
        MyNode<E> next;

        MyNode(E val) {

            value = val;
        }
    }
}
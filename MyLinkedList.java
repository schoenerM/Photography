public class MyLinkedList<E> {
    MyNode<E> head = null;

    public int size() {
        int i;
        MyNode<E> listElement = head;

        for (i = 1; listElement.pointer != null; i++)
            listElement = listElement.pointer;
        return i;
    }

    public String toString() {
        MyNode<E> listElement = head;
        StringBuilder result = new StringBuilder(this.size());
        while (listElement != null) {
            result.append("'");
            result.append(listElement.value);
            result.append("' ");

            listElement = listElement.pointer;
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
            while (listElement.pointer != null)
                listElement = listElement.pointer;

            //make last element pointer reference the new element (instead of null)
            listElement.pointer = nodeToAdd;
            nodeToAdd.pointer = null;
        }
    }

    public boolean add(E e, int index) {
        MyNode<E> nodeToAdd = new MyNode<>(e);
        if ((index < this.size()) && (index >= 0)) {

            MyNode<E> prevListElement = head;
            MyNode<E> listElement = head.pointer;
            if (index == 0) {
                nodeToAdd.pointer = head;
                //exchange references(nodeToAdd becomes head and vice versa)
                MyNode<E> temp = head;
                head = nodeToAdd;
                nodeToAdd = temp;

            } else {
                //go through the list
                for (int i = 1; i < index; i++) {
                    prevListElement = prevListElement.pointer;
                    listElement = prevListElement.pointer;
                }

                //make previous element pointer reference the new element
                nodeToAdd.pointer = listElement;
                prevListElement.pointer = nodeToAdd;
            }
        } else throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + this.size());
        return true;
    }

    public E remove(int index) {
        E removed = null;


        //go through the list
        MyNode<E> listElement = head;
        MyNode<E> nodeToRemove = head.pointer;
        if ((index < this.size()) && (index >= 0)) {
            if (index == 0) {
                removed = head.value;
                head = head.pointer;
            } else {
                for (int i = 1; i < index; i++) {
                    listElement = listElement.pointer;
                    nodeToRemove = listElement.pointer;
                }

                //make element pointer = the following elements pointer
                //(leaving that element for the garbage collector)
                removed = nodeToRemove.value;
                listElement.pointer = nodeToRemove.pointer;
            }
        } else
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + this.size());

        return removed;
    }

    public E get(int index) {
        MyNode<E> listElement = head;

        if ((index < this.size()) && (index >= 0)) {

            for (int i = 0; i < index; i++)
                listElement = listElement.pointer;
        } else
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + this.size());

        return listElement.value;
    }


    public static class MyNode<E> {
        E value;
        MyNode<E> pointer;

        MyNode(E val) {

            value = val;
        }
    }
}
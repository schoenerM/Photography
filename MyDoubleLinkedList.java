public class MyDoubleLinkedList<E> {
    MyNode<E> head = null;
    MyNode<E> tail = null;

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

    public String toStringReverse() {
        MyNode<E> listElement = tail;
        StringBuilder result = new StringBuilder(this.size());
        while (listElement != null) {
            result.append("'");
            result.append(listElement.value);
            result.append("' ");

            listElement = listElement.previous;
        }

        return result.toString();
    }

    public void add(E e) {
        MyNode<E> nodeToAdd = new MyNode<>(e);
        if (head == null) {
            head = nodeToAdd;

        } else if (tail == null) {
            tail = nodeToAdd;
            head.next = nodeToAdd;
            nodeToAdd.previous = head;

        } else {

            //add node behind tail
            nodeToAdd.previous = tail;
            tail.next = nodeToAdd;

            //exchange references(nodeToAdd becomes tail and vice versa)
            MyNode<E> temp = tail;
            tail = nodeToAdd;
            nodeToAdd = temp;

        }
    }


    public boolean add(E e, int index) {
        MyNode<E> nodeToAdd = new MyNode<>(e);
        if ((index <= this.size()) && (index >= 0)) {

            MyNode<E> prevListElement = head;
            MyNode<E> listElement = head.next;
            if (index == 0) {
                nodeToAdd.next = head;
                head.previous = nodeToAdd;
                //exchange references(nodeToAdd becomes head and vice versa)
                MyNode<E> temp = head;
                head = nodeToAdd;
                nodeToAdd = temp;

            } else if (index == this.size()) {
                nodeToAdd.previous = tail;
                tail.next = nodeToAdd;
                //exchange references(nodeToAdd becomes head and vice versa)
                MyNode<E> temp = tail;
                tail = nodeToAdd;
                nodeToAdd = temp;

            } else {
                //go through the list
                for (int i = 1; i < index; i++) {
                    prevListElement = prevListElement.next;
                    listElement = prevListElement.next;
                }

                nodeToAdd.next = listElement;
                nodeToAdd.previous = prevListElement;
                listElement.previous = nodeToAdd;
                prevListElement.next = nodeToAdd;
            }
        } else throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + this.size());
        return true;
    }

    public E remove(int index) {
        E removed = null;

        //go through the list
        MyNode<E> elementBefore = head;
        MyNode<E> nodeToRemove = elementBefore.next;
        MyNode<E> elementAfter = nodeToRemove.next;
        if ((index < this.size()) && (index >= 0)) {
            if (index == 0) {
                removed = head.value;
                head = head.next;
                if (size() != 0)
                    head.previous = null;
            } else if (index == this.size() - 1) {
                removed = tail.value;
                tail = tail.previous;
                tail.next = null;
            } else {
                for (int i = 1; i < index; i++) {
                    elementBefore = elementBefore.next;
                    nodeToRemove = elementBefore.next;
                    elementAfter = nodeToRemove.next;

                }

                //make element next = the following elements next
                //(leaving that element for the garbage collector)
                removed = nodeToRemove.value;
                elementBefore.next = nodeToRemove.next;
                    elementAfter.previous = nodeToRemove.previous;
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
        MyNode<E> previous;

        MyNode(E val) {

            value = val;
        }
    }
}

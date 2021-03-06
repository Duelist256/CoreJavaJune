package day170710.homework.linkedlist;

/**
 * Created by Duelist on 10.07.2017.
 */
public class StringLinkedList {
    Node first;
    Node last;
    int size;

    public void add(String value) {
        Node node = new Node(value, null);

        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
        }
        last = node;

        size++;
    }

    public boolean remove(String value) {

        boolean result = false;

        Node current = first;

        Node prev = null;

        while (current != null) {
            if (current.value.equals(value)) {
                if (prev == null) {
                    first = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                result = true;
                break;
            }
            prev = current;
            current = current.next;
        }

        if (first == null) {
            last = null;
        }

        return result;
    }

    public String remove(int index) {

        if (index >= size || index < 0) {
            return null;
        }

        Node current = first;
        Node prev = null;

        int i = 0;
        while (i != index) {
            prev = current;
            current = current.next;
            i++;
        }

        String result;
        if (prev == null) {
            result = first.value;
            first = current.next;
        } else {
            prev.next = current.next;
            result = current.value;
            current = null;
        }
        size--;

        if (first == null) {
            last = null;
        }

        return result;
    }

    @Override
    public String toString() {
        // traverse
        StringBuilder sb = new StringBuilder("[");

        if (first != null) {
            sb.append(first.value);

            Node current = first.next;

            while (current != null) {
                sb.append(", ").append(current.value);
                current = current.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

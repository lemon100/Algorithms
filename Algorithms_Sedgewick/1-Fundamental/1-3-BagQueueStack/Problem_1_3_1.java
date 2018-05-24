import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class Problem_1_3_1 {
    @Test
    public void testFixedCapacityStack() {
        int cap = 10;
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(cap);
        for (int i = 0; i < cap; i++) {
            stack.push("A" + i);
        }
        StdOut.println(stack.isFull());
        for (int i = 0; i < cap; i++) {
            StdOut.println(stack.pop());
        }
    }

    private class FixedCapacityStack<Item> {
        private Item[] a;
        private int N;

        public FixedCapacityStack(int cap) {
            a = (Item[]) new Object[cap];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int getSize() {
            return  N;
        }

        public void push(Item item) {
            a[N++] = item;
        }

        public Item pop() {
            return a[--N];
        }

        public boolean isFull() {
            return N == a.length;
        }
    }
}

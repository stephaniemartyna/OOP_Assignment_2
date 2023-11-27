import utilities.MyStack;

public class App {
    public static void main(String[] args) {

        MyStack<Integer> stackTest = new MyStack<>(100);

        System.out.println(stackTest.isEmpty());
        System.out.println(stackTest.getSize());
        System.out.println(stackTest.getCapacity());

        for (int i = 1; i <= 50; i++) {
            stackTest.push(i);
            System.out.println(stackTest.peek());
        }

        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        System.out.println(stackTest.peek());

        System.out.println(stackTest.isEmpty());
        System.out.println(stackTest.getSize());
        System.out.println(stackTest.getCapacity());

    }
}

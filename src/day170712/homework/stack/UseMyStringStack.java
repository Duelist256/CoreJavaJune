package day170712.homework.stack;

import day170624.mytestframework.Asserts;

/**
 * Created by Duelist on 12.07.2017.
 */
public class UseMyStringStack {
    public static void main(String[] args) {
        MyStringStack stack = new MyStringStack(3);

        // testing push()
        System.out.println(Asserts.assertEquals(stack.push("one"), true));
        System.out.println(Asserts.assertEquals(stack.push("two"), true));
        System.out.println(Asserts.assertEquals(stack.push("three"), true));
        System.out.println(Asserts.assertEquals(stack.push("four"), false));


        System.out.println(Asserts.assertEquals(stack.pop(), "three"));
    }
}

package myExecise;

public class Test {
    public static void main(String[] args){
        Node n1 = new Node("liming");
        Node temp = n1;

        temp.setName("hello");

        System.out.println("n1++++" + n1.getName());
        System.out.println("temp++++" + temp.getName());
    }
}

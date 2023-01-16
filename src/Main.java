public class Main {
    public static void main(String[] args) {

        StackImplement stackImplement = new StackImplement(3);
        stackImplement.push(2);
        stackImplement.push(3);
        stackImplement.push(4);
        stackImplement.push(5);
        stackImplement.push(6);

        int result1 = stackImplement.pop();
        int result2 = stackImplement.pop();
        int result3 = stackImplement.pop();
        int result4 = stackImplement.pop();
        int result5 = stackImplement.pop();


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);



    }
}
public class Main {
    public static void main(String[] args) {

        StackImplement stackImplement = new StackImplement(3);
        int maxItr  = 5;

        //push in stack
        for(int i=0 ; i <maxItr ; i++){
            stackImplement.push(i*2);
        }

        //pop from stack
        for(int i=0 ; i <maxItr ; i++){
            System.out.println("Item popped : "+ stackImplement.pop());
        }
    }
}
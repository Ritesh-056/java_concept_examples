
public class StackImplement implements IntStack{
    private int[] stack;
    private int topOfStack;

    StackImplement(int size){
        stack = new int[size];
        topOfStack = -1;
    }


    @Override
    public void push(int item) {
        if(topOfStack == stack.length-1){

            //dynamic stack implementation
            int[]  newStack = new int[stack.length*2];
            for(int i=0 ; i < stack.length ; i++) {
                newStack[i] = stack[i];
            }
            topOfStack = stack.length;
            stack = newStack;
        }else{
            topOfStack++;
        }
        stack[topOfStack] = item;
        System.out.println("Item pushed successfully:"+stack[topOfStack]);
    }

    @Override
    public int pop() {
        int poppedItem = 0 ;
        if(topOfStack < 0  ) {
            System.out.println("Stack underflow condition");
        }else{
            poppedItem = stack[topOfStack--];
        }
        return poppedItem;
    }
}

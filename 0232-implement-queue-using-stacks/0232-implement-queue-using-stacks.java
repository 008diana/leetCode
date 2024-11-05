//done and dusted!
class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
        System.out.println(st1);
    }
    
    public int pop() {
        int n = st1.size();
        for(int i = 0; i < n - 1; i++){
            int add = st1.pop();
            //System.out.println(st1.size());
            st2.push(add);
        }
        int ans = st1.pop();
        n = st2.size();
        System.out.println(st2);
        for(int i = 0; i < n; i++){
            int add = st2.pop();
            st1.push(add);
        }
        System.out.println(st1);
        
        return ans;

    }
    
    public int peek() {
        int n = st1.size();
        for(int i = 0; i < n - 1; i++){
            int add = st1.pop();
            st2.push(add);
        }
        int ans = st1.pop();
        st1.push(ans);
        n = st2.size();
        for(int i = 0; i < st2.size(); i++){
            int add = st2.pop();
            st1.push(add);
        }
        return ans;

    }
    
    public boolean empty() {
        if(st1.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
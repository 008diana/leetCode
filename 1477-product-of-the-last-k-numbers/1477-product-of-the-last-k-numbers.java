class ProductOfNumbers {

    ArrayList<Integer> list;
    int mul = 1;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        mul = 1;
        for(int i = list.size() - 1 ; i > list.size() - 1 - k; i--){
            mul = mul * (list.get(i));
        }
        return mul;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
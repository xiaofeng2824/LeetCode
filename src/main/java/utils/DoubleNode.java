package utils;


public class DoubleNode {

      public  int value;
      public  DoubleNode last;
      public   DoubleNode next;

    public DoubleNode(){
    }
      public DoubleNode(int value){
          this.value = value;
      }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoubleNode getLast() {
        return last;
    }

    public void setLast(DoubleNode last) {
        this.last = last;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}

package myArray;

public class Feibo {

    public static void main(String[] args) {

        System.out.println(f(10));
        System.out.println(f2(10));

        new Thread(()->{

        }).run();
    }

    // 普通递归写法
    public static int  f(int a){
        if(a == 1) return 1;
        if(a == 2)  return 1;
        return f(a-1) + f(a-2);
    }



    // 动态规划，使用暂存数组写法
    public static int  f2(int a){

        int[] arr = new int[a+1];
        arr[0] = 1;
        arr[1] = 1;

        return f3(arr,a) ;
    }

    public static int f3(int[] arr,int a){
        if (a == 1) return 1;
        if (a == 2) return 1;

        // 已经计算过，直接返回
        int arra = arr[a];
        if (arra != 0){
            return  arra;
        }

        // 没有计算过，计算一下，放在数组中，再返回
        arr[a] = f3(arr,a-1) + f3(arr,a-2);

        return  arr[a];
    }


}

package myString;

public class String_08
{
    public static void main(String[] args)
    {
        int n =4;
        String str = countAndSay(n);
        System.out.println(str);
    }

    public static String countAndSay(int n)
    {
       if(n<=0) return "-1";
       String result = "1";
       for(int i=1;i<n;i++)
       {
           StringBuilder builder = new StringBuilder();
           int index = 0;

           while(index < result.length())
           {
               //��¼ֵ
               char val = result.charAt(index);
               //��¼����λ��
               int count= 0;

               //��������λ�������ϲ���ͬ������ʱֹͣ��
               while(index < result.length() && result.charAt(index) == val)
               {
                   index++;
                   count++;
               }
               //׷������λ���������
               builder.append(String.valueOf(count));
               //׷������λ����ֵ�������
               builder.append(val);
           }

           result = builder.toString();
       }

       return result;



    }

  
}
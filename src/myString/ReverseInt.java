package myString;

/*
* 整数反转
* */
public class ReverseInt
{
    public static void main(String[] args)
    {
        int n = -120;
        int n_reverse = reverse_Int(n);

        System.out.println(n_reverse);

        
    }

    public static int reverse_Int(int x)
    {
        int sum = 0;
            String x_String = String.valueOf(x);
           //
            char[] x_charArray =x_String.toCharArray();
            //System.out.println(x_charArray);
            int length = x_charArray.length;

            if(x_charArray[0] != '-' && x_charArray[length-1] != '0')
            {
                for(int i=0;i<length/2;i++)
                {
                    char tmp = x_charArray[i];
                          x_charArray[i] = x_charArray[length -1- i];
                          x_charArray[length - 1 - i] = tmp;

                }
               // System.out.println(x_charArray);
                  
                  for(int i=0;i<length;i++)
                  {
                      sum = sum*10 + x_charArray[i] - '0';
                  }
                
                
            }else if(x_charArray[0] != '-' && x_charArray[length-1] == '0')
                    {
                        for(int i=0;i<length/2;i++)
                        {
                            char tmp = x_charArray[i];
                            x_charArray[i] = x_charArray[length -1- i];
                            x_charArray[length - 1 - i] = tmp;  
                        }

                        for(int i=1;i<length;i++)
                        {
                            sum = sum*10 + x_charArray[i] - '0';
                        }
                        
                    }
                    else if(x_charArray[0] == '-' && x_charArray[length-1] != '0')
                    {
                        for(int i=0;i<length/2;i++)
                        {
                            char tmp = x_charArray[i];
                            x_charArray[i] = x_charArray[length -1- i];
                            x_charArray[length - 1- i] = tmp;  
                        }

                        for(int i=0;i<length-1;i++)
                        {
                            sum = sum*10 + (int)x_charArray[i] - '0';
                        }
                        sum *= -1;
                    }else if(x_charArray[0] == '-' && x_charArray[length-1] == '0')
                    {
                        for(int i=0;i<length/2;i++)
                        {
                            char tmp = x_charArray[i];
                                  x_charArray[i] = x_charArray[length -1- i];
                                  x_charArray[length - 1 - i] = tmp;
        
                        }
                       // System.out.println(x_charArray);
                          
                          for(int i=1;i<length-1;i++)
                          {
                              sum = sum*10 + x_charArray[i] - '0';
                          }
                          sum *= -1;
                        
                        
                    }

                    if(sum< (-1)*Math.pow(2, 31) || sum >(Math.pow(2,31)-1))
                     return 0;
                     else return sum;
    }
}
package myString;

public class String_03
{
 public static void main(String[] args)
 {
            String s = "loveleetcode";
            int nub = fisstUniqChas(s);
            System.out.println("��һ�����ظ����ַ����±��ǣ�"+nub);
            
        } 
        
        public static int fisstUniqChas(String s)
        {
            int length = s.length();
            int[] s_char = new int[26];
            for(int i=0;i<26;i++)
              s_char[i] = -1;

            int flag =-1;

            char[] s_charArrays = s.toCharArray();
            for(int i=0;i<length;i++)
            {
                s_char[s_charArrays[i] - 'a']++;
            }
            
            for(int i=0;i<length;i++)
            {
                if(s_char[s_charArrays[i] - 'a'] == 0)
                {
                    flag = s.indexOf(s_charArrays[i]);
                    break;
                }
                
            }

            return flag;

        }
}
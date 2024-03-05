package com.demo;

import java.io.*;

public class HD {

    //读取txt文件的字符串
    public static String string=null;

    //ascii源
    public static int txt[]={};

    //ascii加密后
    public static int Entxt[]={};

    //ascii解密后
    public static int Detxt[]={};

    //ascii解密后还原的字符串
    public static String reString=null;

    //读取txt文件中的base64编码存到string
    public static void readTxtFile(String filePath){
        try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists())
            { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null)
                {
                    string+=lineTxt;
                }
                read.close();
            }
            else {
                System.out.println("找不到指定的文件");
            }
            } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    //base64编码转成Ascii码
    public static void stringToAscii(String string) {
        txt=new int[string.length()];
        Entxt=new int[string.length()];
        Detxt=new int[string.length()];
        StringBuffer strAscii = new StringBuffer();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                txt[i]=(int)chars[i];
            }
            else {
                txt[i]=(int)chars[i];
            }
        }
    }

    //十进制转成8位二进制
    public static String int2bin8(int num){
        String result="";
        for(int i=0;i<8;i++)
        {
            int y=num&(1);
            result+=Integer.toString(y);
            num=num>>1;
        }
        StringBuffer stringBuffer = new StringBuffer(result);
        String res = stringBuffer.reverse().toString();

        return res;
    }

    //十进制转换成16位二进制
    public static String int2bin16(int num){
        String result="";
        for(int i=0;i<16;i++)
        {
            int y=num&(1);
            result+=Integer.toString(y);
            num=num>>1;
        }
        StringBuffer stringBuffer = new StringBuffer(result);
        String res = stringBuffer.reverse().toString();

        return res;
    }

    //复合混沌加密
    public static void Encryption(int j0,int g0,double x0){
        int txtLength=txt.length;
        String g=int2bin16(g0);
        String m="";
        for(int i=0;i<txtLength;i++)
        {
            String ans="";
           m=int2bin8(txt[i]); //一个值
           for(int j=0;j<8;j++)
           {
               int ri=(g.charAt(g.length()-1)-'0'); // 手摇密码机最后一位；
               int qi=ri^(m.charAt(j)-'0');
               double xi=1-Math.sqrt(Math.abs(2*x0-1));
               if(qi==0)
                   xi=1-xi;
               x0=xi;
               int t=(g.charAt(0)-'0')^(g.charAt(12)-'0')^(g.charAt(15)-'0');
               g=String.valueOf(t)+g.substring(0,15);
               int ci=(int)Math.floor(xi*(Math.pow(2,j0)))%2;

               ans+=String.valueOf(ci);
           }

            int re=0;
            for(int l=0;l<8;l++)
            {
                if(ans.charAt(l)=='1') {
                    re+=Math.pow(2,8-l-1);
                }
            }
            Entxt[i]=re;
        }
    }

    //复合混沌解密
    public static void Decryption(int j0,int g0,double x0){
        int txtLength=txt.length;
        String g=int2bin16(g0);
        String m="";
        for(int i=0;i<txtLength;i++)
        {
            String ans="";
            m=int2bin8(Entxt[i]); //一个值
            for(int j=0;j<8;j++)
            {
                double xi=1-Math.sqrt(Math.abs(2*x0-1));
                x0=xi;
                int ci=(int)Math.floor(xi*(Math.pow(2,j0)))%2;
                int qi=1-ci^(m.charAt(j)-'0');
                int ri=(g.charAt(g.length()-1)-'0'); // 手摇密码机最后一位；
                int mi=ri^qi;
                int t=(g.charAt(0)-'0')^(g.charAt(12)-'0')^(g.charAt(15)-'0');
                g=String.valueOf(t)+g.substring(0,15);
                ans+=String.valueOf(mi);
                //System.out.println("h1:"+ans);
            }

            int re=0;
            for(int l=0;l<8;l++)
            {
                if(ans.charAt(l)=='1') {
                    re+=Math.pow(2,8-l-1);
                }
            }
            //System.out.println("h2:"+re);
            Detxt[i]=re;
        }
    }

    //ascii码转字符
    public static void asciiToString() {
       reString=new String();
        for(int i=0;i<Detxt.length;i++)
        {
            reString+=(char)Detxt[i];
        }
    }

    //写入txt
    private static void saveAsFile(String content,String filePath) {
        FileWriter fwriter = null;
        try {
            // true表示不覆盖原来的内容，而是加到文件的后面。若要覆盖原来的内容，直接省略这个参数就好
            fwriter = new FileWriter(filePath, true);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //主方法
    public static void main(String []argv) {
        //读取处理数据
       String filepath="F:\\idea_project\\HD\\src\\2.txt";
       readTxtFile(filepath);
       stringToAscii(string);

       //加密
       Encryption(10,30,0.123345);
//       for(int i=0;i<Entxt.length;i++)
//       {
//           System.out.println("源:"+txt[i]+"加密:"+Entxt[i]);
//       }

       //解密
        Decryption(10,30,0.123345);
//        for(int i=0;i<Detxt.length;i++)
//        {
//            System.out.println("源:"+txt[i]+"加密:"+Entxt[i]+"解密:"+Detxt[i]);
//        }

        //还原base64编码
        asciiToString();
       System.out.println(reString);

       //写入
       String filePath1 = "F:\\idea_project\\HD\\src\\3.txt";
       saveAsFile(reString,filePath1);
    }
}

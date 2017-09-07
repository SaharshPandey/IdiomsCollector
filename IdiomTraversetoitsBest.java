/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoupprojects;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.System.in;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class IdiomTraversetoitsBest {
    int count=1;
    public void indexhtml() throws IOException
    {int i=0;
    int j=0;
        Document doc=(Document) Jsoup.connect("http://www.eflnet.com/idioms/idiomlist/all").get();
        Elements element=doc.getElementsByTag("dfn");
        Elements el=doc.getElementsByTag("dd");
        String[] array=new String[100];
        for(Element e1:el)
        {
         array[i]=e1.text();
         i++;
        }
        for(Element e:element)
        {
             System.out.println(count+".  "+e.text()+" --> ");
       // System.out.println(e.attr("dd").toString());
            count++;
             System.out.println("        "+array[j]+"\n");
       j++;
        System.out.println("\t...........................................................................................................................\n");
      
        }
    
    }
    public void htmltraversing() throws IOException
    {int j=0;
    int i=0;
    for(int k=1;k<13;k++)
    {
    Document doc=(Document) Jsoup.connect("http://www.eflnet.com/idioms/idiomlist/all?page="+i).get();
    Elements element=doc.getElementsByTag("dfn");
     Elements el=doc.getElementsByTag("dd");
        String[] array=new String[100];
        for(Element e1:el)
        {
         array[i]=e1.text();
         i++;
        }
    for(Element e:element)
        {
        System.out.println(count+".  "+e.text()+" --> ");
         count++;
       System.out.println("         "+array[j]+"\n");
       j++;
       System.out.println("\t...........................................................................................................................\n");
        }
    }
    
    }
    
    public static void main(String []args) throws IOException
    {
    File f=new File("output.txt");
    FileOutputStream fos = new FileOutputStream(f);
    PrintStream ps = new PrintStream(fos);
    System.setOut(ps);
    
    IdiomTraversetoitsBest idioms=new IdiomTraversetoitsBest();
    idioms.indexhtml();
    idioms.htmltraversing();
    Desktop.getDesktop().edit(f);
   
    //ProcessBuilder pb = new ProcessBuilder("C:\\WINDOWS\\system32\\notepad.exe", "output.txt");
    //pb.start();


    
    
    
    }    
    
}

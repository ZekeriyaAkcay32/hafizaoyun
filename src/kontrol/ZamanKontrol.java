/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author zekeriya
 */
public class ZamanKontrol {
    
    public JLabel  saat,dakika,saniye;
    public JLabel puan;
    public Timer zamanlayici;

    public ZamanKontrol() {
    }
    
    
   

    public ZamanKontrol(JLabel saat,JLabel dakika,JLabel saniye,JLabel puan) {
        this.saat=saat;
        this.dakika=dakika;
        this.saniye=saniye;
        this.puan=puan;
        
    }
    
    public void zamanlayiciBaslat()
    {
         zamanlayici=new Timer(1000,new ActionListener() {
             
             @Override
             public void actionPerformed(ActionEvent e) {
                 int saatdeger=Integer.parseInt(saat.getText());
                 int saniyedeger=Integer.parseInt(saniye.getText());
                 int dakikadeger=Integer.parseInt(dakika.getText());
                 
                
                
//               int a= (((0-(saniyedeger=(saniyedeger+1)%3)>>>31)-1)>>>31);
//               int b= (((0-(dakikadeger=(dakikadeger+a)%3)>>>31)-1)>>>31);
//               int c=a&b;
//               int d= (((0-(saatdeger=(saatdeger+c)%3)>>>31)-1)>>>31);

                //Bit düzeyinde işlemler ile saniye dakika ve saat artışı
               int a,b;
               saatdeger=(saatdeger+((a=(((0-(saniyedeger=(saniyedeger+1)%60)>>>31)-1)>>>31))&((((0-(dakikadeger=(dakikadeger+a)%60)>>>31)-1)>>>31))))%24;
                 
               //Klasik if yapısıyla saniye, dakika ve saat artışı
//                 if(saniyedeger<59)
//                     saniyedeger++;
//                 else
//                 {
//                     saniyedeger=0;
//                     if(dakikadeger<59)
//                        dakikadeger++;
//                     else
//                     {
//                         dakikadeger=0;
//                         saatdeger++;
//                     }
//                 }

                 NumberFormat nf=new DecimalFormat("00");
                 saat.setText(nf.format(saatdeger));
                 dakika.setText(nf.format(dakikadeger));
                 saniye.setText(nf.format(saniyedeger)); 
             }
         });
         zamanlayici.start();
    }
    
    public void zamanlayiciDurdur()
    {
        zamanlayici.stop();
       
    
    
    
    }
    
}

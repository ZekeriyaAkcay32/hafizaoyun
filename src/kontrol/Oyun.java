/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Kutu;

/**
 *
 * @author zekeriya
 */
public class Oyun {
    private int oyunpuan=0;
    private int tiklama=1;
    private int kutuSayisi;
    private Kutu kutu1,kutu2;
    
    JLabel saat,dakika,saniye,puan;
    JPanel panel;
    KutuKontrol kutuKontrol;
    ZamanKontrol zamanKontrol;

    public Oyun(String yerlesim,int kutuSayisi,JLabel saat,JLabel dakika,JLabel saniye,JLabel puan,JPanel panel) {
        this.saat=saat;
        this.dakika=dakika;
        this.saniye=saniye;
        this.puan=puan;
        this.panel=panel;
        this.kutuSayisi=kutuSayisi;
        this.saat.setText("00");
        this.dakika.setText("00");
        this.saniye.setText("00");
        this.puan.setText("0");
        kutuKontrol=new KutuKontrol(this.panel, yerlesim,this);
        zamanKontrol=new ZamanKontrol(saat, dakika, saniye, puan);
        kutuKontrol.kutuOlustur(this.kutuSayisi);
       
    }
    
    public void baslat()
    {
        
        kutuKontrol.yazilariGizle();
        zamanKontrol.zamanlayiciBaslat();
    }
    
    public void durdur()
    {
        zamanKontrol.zamanlayiciDurdur();
        puan.setText(Integer.toString(oyunpuan));
    }
    
    
    
    public void karsilastir(Kutu kutu)
    {
        if(tiklama==1)
        {
            tiklama=2;
            kutu.setText(kutu.getDeger());
            kutu1=kutu;
            
        }
        else if(tiklama==2)
        {
            kutu2=kutu;
            tiklama=1;
            if(kutu1.getActionCommand().equalsIgnoreCase(kutu2.getActionCommand()))
            {
               
                kutu1.setText("");
                kutu2.setText("");
                kutu1.setSelected(false);
                kutu2.setSelected(false);
              
                
                
            }
            else if(kutu1.getDeger().equalsIgnoreCase(kutu2.getDeger()))
            {
                kutu2.setText(kutu2.getDeger());
                kutu1.setEnabled(false);
                kutu2.setEnabled(false);
                kutu1.setDurum(false);
                kutu2.setDurum(false);
                oyunpuan+=50;
                
            }
            else
            {
                kutu1.setText("");
                kutu2.setText("");
                kutu1.setSelected(false);
                kutu2.setSelected(false);
                oyunpuan-=20;
            }
            //System.out.println(oyunpuan);
            //ZamanKontrol.puan.setText(Integer.toString(oyunpuan));
            
        }
    }
    
    public void oyunSonuKontrol(ArrayList kutular)
    {
         Kutu k=null;
         boolean bul=false;
       
        for(int i=0; i<kutular.size(); i++)
        {
            k=(Kutu)kutular.get(i);
            if(k.isDurum())
                bul=true;
            
        }
        if(bul==false)
        {
            oyunpuan=oyunpuan*kutular.size();
            durdur();
            JOptionPane jop=new JOptionPane("OYUN BİTTİ",JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION);
            JDialog dlg=jop.createDialog("Mesaj");
            dlg.setVisible(true);
           
        }
            
        
    }
    
}

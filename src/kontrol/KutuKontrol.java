/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrol;

import dinleyici.DugmeDinleyici;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import model.Kutu;

/**
 *
 * @author zekeriya
 */
public class KutuKontrol {
    
    private DugmeDinleyici dugmeDinleyici;
    public JPanel panel;
    private ArrayList kutular=new ArrayList();
    private ArrayList rastgeleSayilar=new ArrayList();
   private int kutuSayisi=0;
    private String yerlesimDuzeni;
    
    public KutuKontrol(JPanel pnl,String yerlesim,Oyun oyun) {
        this.panel=pnl;
        this.yerlesimDuzeni=yerlesim;
        dugmeDinleyici = new DugmeDinleyici(oyun);
    }
    
    
    
    public void kutuOlustur(int adet)
    {
        
       if(adet%2==1)
           adet++;
       this.kutuSayisi=adet;
      for(int i=0; i<adet; i++)
          rastgeleSayilar.add(0);
      rastgeleSayilarUret();
     // for(int i=0; i<adet; i++)
          //System.out.println(rastgeleSayilar.get(i).toString());
      panel.removeAll();
      panel.repaint();
       panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()));
       GridLayout gl=new GridLayout(2,adet/2);
       FlowLayout fl=new FlowLayout(1);
       if(yerlesimDuzeni.equalsIgnoreCase("GridLayout"))
           panel.setLayout(gl);
       else if(yerlesimDuzeni.equalsIgnoreCase("FlowLayout"))
            panel.setLayout(fl);      
        for(int i=0; i<adet; i++)
        {
            Kutu yenikutu;
            yenikutu=new Kutu(dugmeDinleyici,rastgeleSayilar.get(i).toString());
            yenikutu.setDurum(true);
            yenikutu.setActionCommand(Integer.toString(i));
            yenikutu.setPreferredSize(new Dimension(75,75));
            kutular.add(yenikutu);
            yenikutu.setVisible(true);
            yenikutu.setEnabled(false);
            panel.add(yenikutu);
        }
        dugmeDinleyici.setKutular(kutular);
        panel.doLayout(); 
    }
    
    public void rastgeleSayilarUret()
    {
        Random rastgele=new Random();
        int tutulan;
        Integer j,k;
        for(j=1; j<=(kutuSayisi/2); j++)
        {
            for(k=1; k<=2; k++)
            {
                    while(true)
                    {
                        tutulan=rastgele.nextInt(kutuSayisi);
                        
                        if(rastgeleSayilar.get(tutulan).equals(0))
                            break;
                            
                    }
                    rastgeleSayilar.set(tutulan,j);
            }
        }
    }
    
    public void yazilariGizle()
    {
        for(int i=0; i<kutular.size(); i++)
        {
            ((Kutu)(kutular.get(i))).setText("");
            ((Kutu)(kutular.get(i))).setEnabled(true);
            
        }
    }
}

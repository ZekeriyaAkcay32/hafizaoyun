/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dinleyici;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import kontrol.Oyun;
import kontrol.ZamanKontrol;
import model.Kutu;

/**
 *
 * @author zekeriya
 */
public class DugmeDinleyici implements ActionListener {
    
    private Oyun oyun;
    ZamanKontrol zk;
    
    private ArrayList kutular;

    public DugmeDinleyici(Oyun oyun) {
       this.oyun=oyun;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Kutu k=null;
       
        for(int i=0; i<getKutular().size(); i++)
        {
            k=(Kutu)getKutular().get(i);
            if(k.getActionCommand().equalsIgnoreCase(e.getActionCommand()))
            {
                //System.out.println("Bulundu");
                break;
            }
               
        }
       //System.out.println(k.getDeger());
        oyun.karsilastir(k);
        oyun.oyunSonuKontrol(kutular);
    }

    /**
     * @return the kutular
     */
    public ArrayList getKutular() {
        return kutular;
    }

    /**
     * @param kutular the kutular to set
     */
    public void setKutular(ArrayList kutular) {
        this.kutular = kutular;
    }

    
    
    
    
}

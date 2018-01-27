/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojtree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author tritu
 */
public class ItemClick implements  MouseListener{

private Explorer ex ;

    public ItemClick(JFrame ex) {
        this.ex = (Explorer) ex;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       Item item = (Item) e.getSource(); // sự kiện xảy ra như nào 
        System.out.println("Selected: " +item.getText());
        ArrayList<Item> list = new ArrayList<>();
        list = this.ex.getItems();
        for (Item item1 : list) {
            item1.setSelected(false);
        }
    try {
        ex.loadItems(item.getPath());
    } catch (IOException ex) {
        Logger.getLogger(ItemClick.class.getName()).log(Level.SEVERE, null, ex);
    }
        ex.updateItems(null);
        item.setSelected(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}

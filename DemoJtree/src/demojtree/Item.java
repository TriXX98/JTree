/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojtree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author tritu
 */
public class Item extends JPanel{
    private boolean selected;
    private boolean folder;
    private String text;
    private Image fldIcon = null;
    private Image fileIcon = null;
    private String path;
    private JLabel labelName ;
    private JLabel labelImage ;

    public Item() {
        
    }

    Item(String name, boolean directory) throws IOException {
        this.text = name;
        this.folder = directory;
         this.eventUI();
        try {
            this.fldIcon = ImageIO.read(new File("C:\\Users\\tritu\\OneDrive\\Pictures\\Saved Pictures\\Folders-Free-PNG-Image.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            this.fileIcon = ImageIO.read(new File("C:\\Users\\tritu\\OneDrive\\Pictures\\Saved Pictures\\Docs-icon.png")).getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING);
        } catch (FileNotFoundException ex) {
            ex.getMessage();
    }

    }

    public String getPath() {
        return path;
    }

    public Item setPath(String path) {
        this.path = path;
        return this;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            selected();
        } else {
            unSelected();
        }
    }

    public boolean isFolder() {
        return folder;
    }
    

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

  
        
    
    private void eventUI(){
    this.setBackground(Color.BLUE);
    this.setPreferredSize(new Dimension(50,50));
    this.setLayout(new BorderLayout());
    labelName = new JLabel(this.text);
    labelName.setLayout(new FlowLayout(FlowLayout.CENTER));
    labelImage = new JLabel();
    labelImage.setHorizontalAlignment(SwingConstants.CENTER);
    if(this.folder){
    labelImage.setIcon(new ImageIcon(this.fldIcon));   
    }
    else{
    labelImage.setIcon(new ImageIcon(this.fileIcon));
    }
    
    this.add(labelName,BorderLayout.NORTH);
    this.add(labelImage, BorderLayout.CENTER);
    }
    
    private void selected(){
    this.setBorder(BorderFactory.createLineBorder(new Color(102, 255, 255, 255)));
        this.setBackground(new Color(204, 255, 255, 255));
    }
    
    private void unSelected(){
     this.setBorder(null);
        this.setBackground(new Color(255, 255, 255, 255));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojtree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author tritu
 */
public class Explorer extends JFrame{
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel fPanel;
    private JLabel fLabel;
    private JTextField fText ;
    private Container con;
    private ArrayList<Item>  items;
    private JTree folderTree;
    private DefaultMutableTreeNode root = null;
    private UpdateTree treeUpdate = null;
   
    public ArrayList<Item> getItems() {
        return items;
    }
    private ItemClick click ;
    
    
    
    public Explorer() {
        super("File Explorer");
        this.setSize(600,600);
        this.setLocation(ABORT,ABORT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initLayOut();
    }
    

    private void initLayOut() {
        
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(Color.WHITE);
         
       
        
        folderTree = new JTree();
        treeUpdate = new UpdateTree(buildTree());
        folderTree.setModel(treeUpdate);
        leftPanel.add(folderTree);
        
        folderTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
             DefaultMutableTreeNode node = (DefaultMutableTreeNode) folderTree.getLastSelectedPathComponent();   
                try {
                    loadItems(e.getPath().toString());
                     updateItems(node);
                } catch (IOException ex) {
                    Logger.getLogger(Explorer.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
        });
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT ,leftPanel, rightPanel);
        splitPane.setContinuousLayout(true);
        this.add(splitPane, BorderLayout.CENTER);
        
        JButton findBtn = new JButton("Find");
        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XuLiTimKiem();
                
            }
        });
        fPanel = new JPanel();
        fText = new JTextField("                      ");
        fPanel.add(fText, BorderLayout.EAST);
        
        fLabel = new JLabel("Search This PC");
        fLabel.setFont(new Font("Carlibri", Font.PLAIN , 15));
        fPanel.add(fLabel , BorderLayout.EAST);
        fPanel.add(findBtn ,BorderLayout.EAST);
        con = new Container();
        con = this.getContentPane();
        con.add(fPanel,BorderLayout.EAST);
    }
    
    private  TreeNode buildTree(){
        
        root = new DefaultMutableTreeNode("This PC");
        
        for (File f : File.listRoots()) {
          DefaultMutableTreeNode node = new DefaultMutableTreeNode(f.getAbsolutePath());
         root.add(node);
        }
        return root;
//        DefaultMutableTreeNode pc = new DefaultMutableTreeNode("This PC");
//        DefaultMutableTreeNode fd = new DefaultMutableTreeNode("Floders");
//        DefaultMutableTreeNode file = new DefaultMutableTreeNode("File");
//        
//        pc.add(fd);
//        fd.add(file);
//        return pc;
    }    
    
     public void loadItems(String file) throws IOException {
         readFile(file);
            }
     
    
     
     
      public void updateItems(DefaultMutableTreeNode node) {
          click = new ItemClick(this);
          rightPanel.removeAll();
          rightPanel.repaint();
          for (Item item : items) {
              rightPanel.add(item);
              item.addMouseListener(click);
              
            if(node !=null){
              if(item.isFolder()){
              DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(item.getText());
              treeUpdate.insertNodeInto(treeNode, node, 10);
              }
              }
          }
          treeUpdate.reload();
            }
      
       private void readFile(String file) throws IOException {
         
           File[] f = new File(file).listFiles();
           if(f == null) return ;
           
           for (File file1 : f) {
               items.add(new Item(file1.getName(),file1.isDirectory()).setPath(file1.getAbsolutePath()));
           }
    }
       
     private  void XuLiTimKiem(){
    
    }

   
    }
    
  
    
    


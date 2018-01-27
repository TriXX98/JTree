/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojtree;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author tritu
 */
public class UpdateTree extends DefaultTreeModel{
    
    public UpdateTree(TreeNode root) {
        super(root);
    }

    @Override
    public void reload() {
        super.reload(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getRoot() {
        return super.getRoot(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRoot(TreeNode root) {
        super.setRoot(root); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

import view.Subject;

/**
 *
 * @author Saad
 */
public interface Observer {
    public void update();
    public void setSubject(Subject subject);
}

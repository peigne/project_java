/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Interfaces;

/**
 *
 * @author Flo
 */

import View.Interfaces.IPoint;

public interface IBeacon extends IPoint{
    public String getCode();
    public String getType();
}

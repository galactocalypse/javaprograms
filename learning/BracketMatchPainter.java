/*
 This file is part of the BlueJ program. 
 Copyright (C) 1999-2009  Michael K�lling and John Rosenberg 
 
 This program is free software; you can redistribute it and/or 
 modify it under the terms of the GNU General Public License 
 as published by the Free Software Foundation; either version 2 
 of the License, or (at your option) any later version. 
 
 This program is distributed in the hope that it will be useful, 
 but WITHOUT ANY WARRANTY; without even the implied warranty of 
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 GNU General Public License for more details. 
 
 You should have received a copy of the GNU General Public License 
 along with this program; if not, write to the Free Software 
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA. 
 
 This file is subject to the Classpath exception as provided in the  
 LICENSE.txt file that accompanied this code.
 */
// Copyright (c) 2000, 2005 BlueJ Group, Deakin University
//
// This software is made available under the terms of the "MIT License"
// A copy of this license is included with this source distribution
// in "license.txt" and is also available at:
// http://www.opensource.org/licenses/mit-license.html 
// Any queries should be directed to Michael Kolling mik@bluej.org

package bluej.editor.moe;

import java.awt.*;

import javax.swing.text.*;

import bluej.utility.Debug;
 ing matching bracket in text component as
 * a rectangle.
 */
public class BracketMatchPainter extends DefaultHighlighter.DefaultHighlightPainter
{
     
    public BracketMatchPainter(Color colour)
    {
        super(colour);
    }
        
    /**
     * Paints a rectangle around a matching bracket
     * This seems to be the only method we need to over-ride.
     *
     * @return area highlighted 
     */
    public Shape paintLayer(Graphics g, int begin, int end, Shape bounds, JTextComponent comp, View view) 
    {
        g.setColor(getColor());
        Rectangle rect = null;
        try {
            Shape shape = view.modelToView(begin, Position.Bias.Forward,
                                           end,Position.Bias.Backward,
                                           bounds);
            rect = shape.getBounds();                
            g.drawRect(rect.x, rect.y, rect.width -1, rect.height - 1);
        } catch (BadLocationException ble) {
            Debug.reportError("bad location exception thrown");
            ble.printStackTrace();
        }    
        return rect;
    }
    
}
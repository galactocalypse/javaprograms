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

import bluej.Config;
import java.awt.*;              // New Event model    
import javax.swing.*;

/**
*lass StatusLabel extends JLabel
{
    // ---------------- CONSTANTS -----------------

    public static Font statusFont = new Font("SansSerif", Font.BOLD | Font.ITALIC, 11);

    // current save state
    static final int READONLY = 0;
    static final int SAVED = 1;   
    static final int CHANGED = 2; 

    private final String[] stateString = { 
        Config.getString("editor.state.readOnly"), 
        Config.getString("editor.state.saved"),
        Config.getString("editor.state.changed")
    };


    // ------------ INSTANCE VARIABLES ------------

    private int state;


    // -------------- CONSTRUCTORS ----------------

    public StatusLabel(int initialState)
    {
        super("", JLabel.CENTER);
        setText(stateString[initialState]);
        setFont(statusFont);
        setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        state = initialState;
    }

    // ------------- PUBLIC METHODS ---------------

    public boolean isSaved() 
    {
        return (state != CHANGED);
    }

    public boolean isChanged() 
    {
        return (state == CHANGED);
    }

    public boolean isReadOnly() 
    {
        return (state == READONLY);
    }

    public void setState(int newState)
    {
        state = newState;
        setText(stateString[state]);
    }

}  // end class StatusLabel

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.cos.basys.common.wmrestclient.QueryResponses;

import de.dfki.cos.basys.common.wmrestclient.dto.Frame;
import de.dfki.cos.basys.common.wmrestclient.dto.Sector;

/**
 *
 * @author tospie
 */
public class FrameResponse {
    public String id;
    public int index;
    public Frame.FrameType type;
    public Sector.SectorEnum hullregion;
}
